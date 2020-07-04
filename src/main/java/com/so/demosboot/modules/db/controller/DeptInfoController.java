package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.db.entity.DeptInfo;
import com.so.demosboot.modules.db.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 * 部门信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/deptInfo")
public class DeptInfoController {

	@Autowired
	private DeptInfoService deptInfoService;
	
	@ModelAttribute
	public DeptInfo get(@RequestParam(required=false) String id) {
		DeptInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = deptInfoService.getById(id);
		}else{
			entity = new DeptInfo();
		}
		return entity;
	}

	@RequestMapping(value = "detail")
	public String detail(DeptInfo deptInfo, Model model){
		if (StringUtils.isNotEmpty(deptInfo.getId())){
			deptInfo = deptInfoService.getById(deptInfo.getId());
			model.addAttribute("deptInfo",deptInfo);
			List<DeptInfo> gList = deptInfoService.genderStatistics(deptInfo);
			model.addAttribute("gList",gList);
			List<DeptInfo> jList = deptInfoService.jobStatistics(deptInfo);
			model.addAttribute("jList",jList);
			List<DeptInfo> rList = deptInfoService.rankStatistics(deptInfo);
			model.addAttribute("rList",rList);
			List<DeptInfo> dList = deptInfoService.degreeStatistics(deptInfo);
			model.addAttribute("dList",dList);
		}
		return "db/deptInfoDetail";
	}


	@RequestMapping(value = {"list", ""})
	public String list(DeptInfo deptInfo, Model model) {
		PageHelper.startPage(deptInfo.getPageNo(),10);
		List<DeptInfo> list = deptInfoService.findList(deptInfo);
		PageInfo<DeptInfo> pageInfo = new PageInfo<DeptInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "db/deptInfoList";
	}

	@RequestMapping(value = "form")
	public String form(DeptInfo deptInfo, Model model) {
		if (StringUtils.isNotEmpty(deptInfo.getId())){
			deptInfo = deptInfoService.getById(deptInfo.getId());
			model.addAttribute("deptInfo",deptInfo);
		}
		return "db/deptInfoForm";
	}

	@RequestMapping(value = "formChild")
	public String formChild(DeptInfo deptInfo, Model model) {
		if (StringUtils.isNotEmpty(deptInfo.getId())){
			deptInfo = deptInfoService.getById(deptInfo.getId());
			model.addAttribute("deptInfo",deptInfo);
		}
		return "db/deptInfoFormChild";
	}

	@RequestMapping(value = "save")
	public String save(DeptInfo deptInfo, RedirectAttributes redirectAttributes) {
		System.out.println("*********************************************");
		System.out.println(deptInfo);
		System.out.println("*********************************************");
		deptInfoService.save(deptInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/db/deptInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(DeptInfo deptInfo, RedirectAttributes redirectAttributes) {
		deptInfoService.delete(deptInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/db/deptInfo";
	}

}