package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.modules.db.entity.CompileInfo;
import com.so.demosboot.modules.db.entity.DeptInfo;
import com.so.demosboot.modules.db.entity.JobInfo;
import com.so.demosboot.modules.db.service.CompileInfoService;
import com.so.demosboot.modules.db.service.DeptInfoService;
import com.so.demosboot.modules.db.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import com.so.demosboot.common.utils.StringUtils;



/**
 * 部门信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/jobInfo")
public class JobInfoController{

    @Autowired
    private JobInfoService jobInfoService;

    @Autowired
    private CompileInfoService compileInfoService;

    @Autowired
    private DeptInfoService deptInfoService;

    @ModelAttribute
    public JobInfo get(@RequestParam(required=false) String id) {
        JobInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = jobInfoService.getById(id);
        }else{
            entity = new JobInfo();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(JobInfo jobInfo, Model model) {
        PageHelper.startPage(jobInfo.getPageNo(),10);
        List<JobInfo> list = jobInfoService.findList(jobInfo);
        PageInfo<JobInfo> pageInfo = new PageInfo<JobInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        return "db/jobInfoList";
    }

    @RequestMapping(value = "form")
    public String form(JobInfo jobInfo, Model model) {
        if (StringUtils.isNotEmpty(jobInfo.getId())){
            jobInfo = jobInfoService.getById(jobInfo.getId());
            model.addAttribute("deptInfo",jobInfo);
        }
        CompileInfo compileInfo = new CompileInfo();
        List<CompileInfo> cList = compileInfoService.findList(compileInfo);
        model.addAttribute("cList",cList);

        DeptInfo deptInfo = new DeptInfo();
        List<DeptInfo> dList = deptInfoService.findList(deptInfo);
        model.addAttribute("dList", dList);
        return "db/jobInfoForm";
    }

    @RequestMapping(value = "save")
    public String save(JobInfo jobInfo,RedirectAttributes redirectAttributes) {
        System.out.println("*********************************************");
        System.out.println(jobInfo);
        System.out.println("*********************************************");
        jobInfoService.save(jobInfo);
        redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
        return "redirect:"+"/db/jobInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(JobInfo jobInfo, RedirectAttributes redirectAttributes) {
        jobInfoService.delete(jobInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/jobInfo";
    }

}
