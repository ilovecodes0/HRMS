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
import com.so.demosboot.modules.db.entity.FlInfo;
import com.so.demosboot.modules.db.service.FlInfoService;


/**
 * 部门信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/flInfo")
public class FlInfoController{

    @Autowired
    private FlInfoService flInfoService;

    @ModelAttribute
    public FlInfo get(@RequestParam(required=false) String id) {
        FlInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = flInfoService.getById(id);
        }else{
            entity = new FlInfo();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(FlInfo flInfo, Model model) {
        PageHelper.startPage(flInfo.getPageNo(),10);
        List<FlInfo> list = flInfoService.findList(flInfo);
        PageInfo<FlInfo> pageInfo = new PageInfo<FlInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        return "db/flInfoList";
    }

    @RequestMapping(value = "form")
    public String form(FlInfo flInfo, Model model) {
        if (StringUtils.isNotEmpty(flInfo.getId())){
            flInfo = flInfoService.getById(flInfo.getId());
            model.addAttribute("flInfo",flInfo);
        }
        return "db/flInfoForm";
    }


    @RequestMapping(value = "look")
    public String look(FlInfo flInfo, Model model) {
        if (StringUtils.isNotEmpty(flInfo.getId())){
            flInfo = flInfoService.getById(flInfo.getId());
            model.addAttribute("flInfo",flInfo);
        }
        return "db/flInfoForm";
    }

    @RequestMapping(value = "save")
    public String save(FlInfo flInfo,RedirectAttributes redirectAttributes) {
        flInfoService.save(flInfo);
        redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
        return "redirect:"+"/db/flInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(FlInfo flInfo, RedirectAttributes redirectAttributes) {
        flInfoService.delete(flInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/flInfo";
    }

}