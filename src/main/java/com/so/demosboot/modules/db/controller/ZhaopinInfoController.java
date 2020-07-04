package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.modules.db.entity.DeptInfo;
import com.so.demosboot.modules.db.entity.StaffInfo;
import com.so.demosboot.modules.db.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.db.entity.ZhaopinInfo;
import com.so.demosboot.modules.db.service.ZhaopinInfoService;
import com.so.demosboot.modules.db.entity.JobInfo;
import com.so.demosboot.modules.db.service.JobInfoService;

import java.lang.System;

import com.so.demosboot.modules.db.service.DeptInfoService;

/**
 * 部门信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/zhaopinInfo")
public class ZhaopinInfoController{

    @Autowired
    private ZhaopinInfoService zhaopinInfoService;
    @Autowired
    private DeptInfoService deptInfoService;
    @Autowired
    private JobInfoService jobInfoService;

    @ModelAttribute
    public ZhaopinInfo get(@RequestParam(required=false) String id) {
        ZhaopinInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = zhaopinInfoService.getById(id);
        }else{
            entity = new ZhaopinInfo();
        }
        //System.out.println(entity);
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(ZhaopinInfo zhaopinInfo, Model model) {
        PageHelper.startPage(zhaopinInfo.getPageNo(),10);
        List<ZhaopinInfo> list = zhaopinInfoService.findList(zhaopinInfo);
        PageInfo<ZhaopinInfo> pageInfo = new PageInfo<ZhaopinInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);

        List<DeptInfo> findList = deptInfoService.findList(new DeptInfo());
        model.addAttribute("depts",findList);//部门

        System.out.println("fasdasdfuck!!!");
        System.out.println();
        for(ZhaopinInfo info:list)
            System.out.println((info));
        System.out.println();
        return "db/zhaopinInfoList";
    }

    @RequestMapping(value = {"sum"})
    public String sum(ZhaopinInfo zhaopinInfo, Model model) {
        PageHelper.startPage(zhaopinInfo.getPageNo(),10);
        List<ZhaopinInfo> list = zhaopinInfoService.findListSum(zhaopinInfo);
        PageInfo<ZhaopinInfo> pageInfo = new PageInfo<ZhaopinInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println("fasdasdfuck!!!");
        System.out.println();
        for(ZhaopinInfo info:list)
            System.out.println((info));
        System.out.println();
        return "db/zhaopinInfoSum";
    }

    @RequestMapping(value = "form")
    public String form(ZhaopinInfo zhaopinInfo, Model model) {

        List<DeptInfo> findList = deptInfoService.findList(new DeptInfo());
        model.addAttribute("depts",findList);//部门

        List<JobInfo> findListJob = jobInfoService.findList(new JobInfo());
        model.addAttribute("jobs",findListJob);//岗位
        if (StringUtils.isNotEmpty(zhaopinInfo.getId())){
            zhaopinInfo = zhaopinInfoService.getById(zhaopinInfo.getId());
            model.addAttribute("zhaopinInfo",zhaopinInfo);
        }
        return "db/zhaopinInfoForm";
    }

    @RequestMapping(value = "save")
    public String save(ZhaopinInfo zhaopinInfo,RedirectAttributes redirectAttributes) {
        zhaopinInfoService.save(zhaopinInfo);
        redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
        return "redirect:"+"/db/zhaopinInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(ZhaopinInfo zhaopinInfo, RedirectAttributes redirectAttributes) {
        zhaopinInfoService.delete(zhaopinInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/zhaopinInfo";
    }

    @ResponseBody
    @RequestMapping(value = "zhaopinInfo")
    public ZhaopinInfo zhaopinInfo(ZhaopinInfo zhaopinInfo, Model model) {
        zhaopinInfo = zhaopinInfoService.getById(zhaopinInfo.getId());
        return zhaopinInfo;
    }

}