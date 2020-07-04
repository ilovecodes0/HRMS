package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.db.entity.DeptInfo;
import com.so.demosboot.modules.db.entity.StaffInfo;
import com.so.demosboot.modules.db.service.DeptInfoService;
import com.so.demosboot.modules.db.service.StaffInfoService;


/**
 * 员工信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/staffInfo")
public class StaffInfoController{

	@Autowired
	private StaffInfoService staffInfoService;
	@Autowired
	private DeptInfoService deptInfoService;
	
	@ModelAttribute
	public StaffInfo get(@RequestParam(required=false) String id) {
		StaffInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = staffInfoService.getById(id);
		}else{
			entity = new StaffInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(StaffInfo staffInfo, Model model) {
		PageHelper.startPage(staffInfo.getPageNo(),10);
		List<StaffInfo> list = staffInfoService.findList(staffInfo);
		PageInfo<StaffInfo> pageInfo = new PageInfo<StaffInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		//查出所有的部门
		List<DeptInfo> findList = deptInfoService.findList(new DeptInfo());
		model.addAttribute("depts",findList);
		return "db/staffInfoList";
	}

	@RequestMapping(value = "form")
	public String form(StaffInfo staffInfo, Model model) {
		//查出所有的部门
		List<DeptInfo> findList = deptInfoService.findList(new DeptInfo());
		model.addAttribute("depts",findList);
		if (StringUtils.isNotEmpty(staffInfo.getId())){
			staffInfo = staffInfoService.getById(staffInfo.getId());
			model.addAttribute("staffInfo",staffInfo);
		}
		return "db/staffInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(StaffInfo staffInfo,RedirectAttributes redirectAttributes) {
		staffInfoService.save(staffInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/db/staffInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(StaffInfo staffInfo, RedirectAttributes redirectAttributes) {
		staffInfoService.delete(staffInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/db/staffInfo";
	}
	
	@ResponseBody
	@RequestMapping(value = "staffInfo")
	public StaffInfo staffInfo(StaffInfo staffInfo, Model model) {
		staffInfo = staffInfoService.getById(staffInfo.getId());
		return staffInfo;
	}
	
	//保存工资调整信息
	@ResponseBody
	@RequestMapping(value = "saveChange")
	public Map<String, String> saveChange(StaffInfo staffInfo,RedirectAttributes redirectAttributes) {
		Map<String, String> reMap = new HashMap<String, String>();
		StaffInfo staffInfoOld = staffInfoService.getById(staffInfo.getId());
		try {
			staffInfoOld.setBaseSalary(staffInfoOld.getBaseSalary()+staffInfo.getChangePrice());
			if (StringUtils.isNotEmpty(staffInfo.getChangeRemark())) {
				staffInfoOld.setRemarks(staffInfoOld.getRemarks()+"\n"+staffInfo.getChangeRemark());
			}
			staffInfoService.save(staffInfoOld);
			reMap.put("code", "1");
			
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("code", "500");
		}
		return reMap;
	}

}