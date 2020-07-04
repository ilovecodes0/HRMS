package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.db.entity.CheckWorkInfo;
import com.so.demosboot.modules.db.entity.StaffInfo;
import com.so.demosboot.modules.db.service.CheckWorkInfoService;
import com.so.demosboot.modules.db.service.StaffInfoService;


/**
 * 考勤信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/checkWorkInfo")
public class CheckWorkInfoController{

	@Autowired
	private CheckWorkInfoService checkWorkInfoService;
	@Autowired
	private StaffInfoService staffInfoService;
	
	@ModelAttribute
	public CheckWorkInfo get(@RequestParam(required=false) String id) {
		CheckWorkInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = checkWorkInfoService.getById(id);
		}else{
			entity = new CheckWorkInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(CheckWorkInfo checkWorkInfo, Model model) {
		PageHelper.startPage(checkWorkInfo.getPageNo(),10);
		List<CheckWorkInfo> list = checkWorkInfoService.findList(checkWorkInfo);
		PageInfo<CheckWorkInfo> pageInfo = new PageInfo<CheckWorkInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		//查出所有的员工
		List<StaffInfo> findList = staffInfoService.findList(new StaffInfo());
		model.addAttribute("staffInfos",findList);
		return "db/checkWorkInfoList";
	}

	@RequestMapping(value = "form")
	public String form(CheckWorkInfo checkWorkInfo, Model model) {
		if (StringUtils.isNotEmpty(checkWorkInfo.getId())){
			checkWorkInfo = checkWorkInfoService.getById(checkWorkInfo.getId());
			model.addAttribute("checkWorkInfo",checkWorkInfo);
		}
		//查出所有的员工
		List<StaffInfo> findList = staffInfoService.findList(new StaffInfo());
		model.addAttribute("staffInfos",findList);
		return "db/checkWorkInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(CheckWorkInfo checkWorkInfo,RedirectAttributes redirectAttributes) {
		checkWorkInfoService.save(checkWorkInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/db/checkWorkInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(CheckWorkInfo checkWorkInfo, RedirectAttributes redirectAttributes) {
		checkWorkInfoService.delete(checkWorkInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/db/checkWorkInfo";
	}

}