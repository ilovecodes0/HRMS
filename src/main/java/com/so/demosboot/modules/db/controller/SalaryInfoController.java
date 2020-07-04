package com.so.demosboot.modules.db.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.so.demosboot.common.utils.DateUtils;
import com.so.demosboot.common.utils.IdGenUtil;
import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.db.entity.SalaryDetail;
import com.so.demosboot.modules.db.entity.SalaryInfo;
import com.so.demosboot.modules.db.entity.StaffInfo;
import com.so.demosboot.modules.db.service.SalaryDetailService;
import com.so.demosboot.modules.db.service.SalaryInfoService;
import com.so.demosboot.modules.db.service.StaffInfoService;


/**
 * 薪资信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/salaryInfo")
public class SalaryInfoController{

	@Autowired
	private SalaryInfoService salaryInfoService;
	@Autowired
	private StaffInfoService staffInfoService;
	@Autowired
	private SalaryDetailService salaryDetailService;
	
	@ModelAttribute
	public SalaryInfo get(@RequestParam(required=false) String id) {
		SalaryInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = salaryInfoService.getById(id);
		}else{
			entity = new SalaryInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(SalaryInfo salaryInfo, Model model) {
		PageHelper.startPage(salaryInfo.getPageNo(),10);
		List<SalaryInfo> list = salaryInfoService.findList(salaryInfo);
		PageInfo<SalaryInfo> pageInfo = new PageInfo<SalaryInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "db/salaryInfoList";
	}

	@RequestMapping(value = "form")
	public String form(SalaryInfo salaryInfo, Model model) {
		if (StringUtils.isNotEmpty(salaryInfo.getId())){
			salaryInfo = salaryInfoService.getById(salaryInfo.getId());
			
		}else {
			salaryInfo.setYearMon(DateUtils.getYear()+"-"+DateUtils.getMonth());
		}
		List<StaffInfo> findList = staffInfoService.findList(new StaffInfo());
		model.addAttribute("staffInfos",findList);
		model.addAttribute("salaryInfo",salaryInfo);
		return "db/salaryInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(SalaryInfo salaryInfo,RedirectAttributes redirectAttributes) {
		salaryInfoService.save(salaryInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/db/salaryInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(SalaryInfo salaryInfo, RedirectAttributes redirectAttributes) {
		salaryInfoService.delete(salaryInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/db/salaryInfo";
	}
	
	/**
	 * 薪资调整界面
	 * @param salaryInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "upAndDown")
	public String upAndDown(SalaryInfo salaryInfo, Model model) {
		if (StringUtils.isNotEmpty(salaryInfo.getId())){
			salaryInfo = salaryInfoService.getById(salaryInfo.getId());
			model.addAttribute("salaryInfo",salaryInfo);
		}
		
		List<StaffInfo> findList = staffInfoService.findList(new StaffInfo());
		model.addAttribute("staffInfos",findList);
		
		return "db/salaryInfoUpAndDown";
	}
	
	@ResponseBody
	@RequestMapping(value = "saveMoney")
	public Map<String, String> saveMoney(@RequestBody String jsonString, RedirectAttributes redirectAttributes) {
		SalaryInfo salaryInfo = JSON.parseObject(jsonString, SalaryInfo.class);
		Map<String, String> reMap = new HashMap<String, String>();
		System.out.println(salaryInfo.getYearMon());
		try {
			//保存工资条
			String id = IdGenUtil.getUUID();
			salaryInfo.setId(id);
			Double totalMoeny = 0.0;
			
			//保存明细
			List<SalaryDetail> details = salaryInfo.getDetails();
			for (SalaryDetail salaryDetail : details) {
				System.out.println(salaryDetail.getName()+":"+salaryDetail.getPrice());
				salaryDetail.setSalaryId(id);
				salaryDetailService.save(salaryDetail);
				totalMoeny += salaryDetail.getPrice();
			}
			salaryInfo.setTruePrice(totalMoeny);
			salaryInfoService.add(salaryInfo);
			reMap.put("code", "1");
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("code", "500");
		}
		
		return reMap;
	}
	
	@RequestMapping(value = "look")
	public String look(SalaryInfo salaryInfo, Model model) {
		salaryInfo = salaryInfoService.getById(salaryInfo.getId());
		
		SalaryDetail querySalaryDetail = new SalaryDetail();
		querySalaryDetail.setSalaryId(salaryInfo.getId());
		List<SalaryDetail> findList = salaryDetailService.findList(querySalaryDetail);
		salaryInfo.setDetails(findList);
		model.addAttribute("salaryInfo",salaryInfo);
		return "db/salaryInfoLook";
	}

}