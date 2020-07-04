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
import com.so.demosboot.modules.db.entity.SalaryDetail;
import com.so.demosboot.modules.db.service.SalaryDetailService;


/**
 * 薪资明细Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/salaryDetail")
public class SalaryDetailController{

	@Autowired
	private SalaryDetailService salaryDetailService;
	
	@ModelAttribute
	public SalaryDetail get(@RequestParam(required=false) String id) {
		SalaryDetail entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = salaryDetailService.getById(id);
		}else{
			entity = new SalaryDetail();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(SalaryDetail salaryDetail, Model model) {
		PageHelper.startPage(salaryDetail.getPageNo(),10);
		List<SalaryDetail> list = salaryDetailService.findList(salaryDetail);
		PageInfo<SalaryDetail> pageInfo = new PageInfo<SalaryDetail>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "db/salaryDetailList";
	}

	@RequestMapping(value = "form")
	public String form(SalaryDetail salaryDetail, Model model) {
		if (StringUtils.isNotEmpty(salaryDetail.getId())){
			salaryDetail = salaryDetailService.getById(salaryDetail.getId());
			model.addAttribute("salaryDetail",salaryDetail);
		}
		return "db/salaryDetailForm";
	}

	@RequestMapping(value = "save")
	public String save(SalaryDetail salaryDetail,RedirectAttributes redirectAttributes) {
		salaryDetailService.save(salaryDetail);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/db/salaryDetail";
	}
	
	@RequestMapping(value = "delete")
	public String delete(SalaryDetail salaryDetail, RedirectAttributes redirectAttributes) {
		salaryDetailService.delete(salaryDetail.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/db/salaryDetail";
	}

}