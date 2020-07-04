package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.modules.db.entity.JobInfo;
import com.so.demosboot.modules.db.service.JobInfoService;
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
import com.so.demosboot.modules.db.entity.BaomingInfo;
import com.so.demosboot.modules.db.service.BaomingInfoService;

import java.lang.System;

/**
 * 部门信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/baomingInfo")
public class BaomingInfoController{

    @Autowired
    private BaomingInfoService baomingInfoService;
    @Autowired
    private JobInfoService jobInfoService;

    @ModelAttribute
    public BaomingInfo get(@RequestParam(required=false) String id) {
        BaomingInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = baomingInfoService.getById(id);
        }else{
            entity = new BaomingInfo();
        }
        //System.out.println(entity);
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(BaomingInfo baomingInfo, Model model) {
        PageHelper.startPage(baomingInfo.getPageNo(),10);
        List<BaomingInfo> list = baomingInfoService.findList(baomingInfo);
        PageInfo<BaomingInfo> pageInfo = new PageInfo<BaomingInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);

        List<JobInfo> findList = jobInfoService.findList(new JobInfo());
        model.addAttribute("jobs",findList);//岗位

        return "db/baomingInfoList";
    }

//    @RequestMapping(value = {"hegebiao", ""})
//    public String hegebiao(BaomingInfo baomingInfo, Model model) {
//        PageHelper.startPage(baomingInfo.getPageNo(),10);
//        List<BaomingInfo> list = baomingInfoService.findList(baomingInfo);
//        PageInfo<BaomingInfo> pageInfo = new PageInfo<BaomingInfo>(list, 10);
//        model.addAttribute("pageInfo",pageInfo);
//
//        List<JobInfo> findList = jobInfoService.findList(new JobInfo());
//        model.addAttribute("jobs",findList);//岗位
//
//        return "db/baomingInfoHegebiao";
//    }



    @RequestMapping(value = "form")
    public String form(BaomingInfo baomingInfo, Model model) {

        List<JobInfo> findList = jobInfoService.findList(new JobInfo());
        model.addAttribute("jobs",findList);//岗位
        if (StringUtils.isNotEmpty(baomingInfo.getId())){
            baomingInfo = baomingInfoService.getById(baomingInfo.getId());
            model.addAttribute("baomingInfo",baomingInfo);
        }
        return "db/baomingInfoForm";
    }

    @RequestMapping(value = "score")
    public String score(BaomingInfo baomingInfo, Model model) {

        List<JobInfo> findList = jobInfoService.findList(new JobInfo());
        model.addAttribute("jobs",findList);//岗位
        if (StringUtils.isNotEmpty(baomingInfo.getId())){
            baomingInfo = baomingInfoService.getById(baomingInfo.getId());
            model.addAttribute("baomingInfo",baomingInfo);
        }
        return "db/baomingInfoScore";
    }
    @RequestMapping(value = "hege")
    public String hege(BaomingInfo baomingInfo,Model model){
        PageHelper.startPage(baomingInfo.getPageNo(),10);
        List<BaomingInfo> list = baomingInfoService.findList1(baomingInfo);
        PageInfo<BaomingInfo> pageInfo = new PageInfo<BaomingInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        return "db/baomingInfoHege";
    }

    @RequestMapping(value = "save")
    public String save(BaomingInfo baomingInfo,RedirectAttributes redirectAttributes) {
        baomingInfoService.save(baomingInfo);
        redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
        return "redirect:"+"/db/baomingInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(BaomingInfo baomingInfo, RedirectAttributes redirectAttributes) {
        baomingInfoService.delete(baomingInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/baomingInfo";
    }

    @ResponseBody
    @RequestMapping(value = "baomingInfo")
    public BaomingInfo baomingInfo(BaomingInfo baomingInfo, Model model) {
        baomingInfo = baomingInfoService.getById(baomingInfo.getId());
        return baomingInfo;
    }

}