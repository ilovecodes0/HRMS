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

import com.so.demosboot.modules.db.entity.FileInfo;

import com.so.demosboot.modules.db.service.FileInfoService;


/**
 * file Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/fileInfo")
public class FileInfoController {

    @Autowired
    private FileInfoService fileInfoService;

    @ModelAttribute
    public FileInfo get(@RequestParam(required=false) String id) {
        FileInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = fileInfoService.getById(id);
        }else{
            entity = new FileInfo();
        }
        return entity;
    }
    @RequestMapping(value = {"list", ""})
    public String list(FileInfo fileInfo, Model model) {
        PageHelper.startPage(fileInfo.getPageNo(),10);
        List<FileInfo> list = fileInfoService.findList(fileInfo);
        PageInfo<FileInfo> pageInfo = new PageInfo<FileInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        return "fileInfoList";
    }


    @RequestMapping(value = "form")
    public String form(FileInfo fileInfo, Model model) {
        if (StringUtils.isNotEmpty(fileInfo.getId())){
            fileInfo = fileInfoService.getById(fileInfo.getId());
            model.addAttribute("fileInfo",fileInfo);
        }
        return "db/fileInfoForm";
    }
    @RequestMapping(value = "save")
    public String save(FileInfo fileInfo,RedirectAttributes redirectAttributes) {
        fileInfoService.save(fileInfo);
        redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
        return "redirect:"+"/db/fileInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(FileInfo fileInfo, RedirectAttributes redirectAttributes) {
        fileInfoService.delete(fileInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/fileInfo";
    }

















}
