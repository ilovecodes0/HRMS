package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.modules.db.entity.CompileInfo;
import com.so.demosboot.modules.db.service.CompileInfoService;
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
 * 编制信息Controller
 * @author admin
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/db/compileInfo")
public class CompileInfoController{

    @Autowired
    private CompileInfoService compileInfoService;

    @ModelAttribute
    public CompileInfo get(@RequestParam(required=false) String id) {
        CompileInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = compileInfoService.getById(id);
        }else{
            entity = new CompileInfo();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(CompileInfo compileInfo, Model model) {
        PageHelper.startPage(compileInfo.getPageNo(),10);
        List<CompileInfo> list = compileInfoService.findList(compileInfo);
        PageInfo<CompileInfo> pageInfo = new PageInfo<CompileInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        return "db/compileInfoList";
    }

    @RequestMapping(value = "form")
    public String form(CompileInfo compileInfo, Model model) {
        if (StringUtils.isNotEmpty(compileInfo.getId())){
            compileInfo = compileInfoService.getById(compileInfo.getId());
            model.addAttribute("deptInfo",compileInfo);
        }
        return "db/compileInfoForm";
    }

    @RequestMapping(value = "save")
    public String save(CompileInfo compileInfo,RedirectAttributes redirectAttributes) {
        System.out.println("*********************************************");
        System.out.println(compileInfo);
        System.out.println("*********************************************");
        compileInfoService.save(compileInfo);
        redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
        return "redirect:"+"/db/compileInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(CompileInfo compileInfo, RedirectAttributes redirectAttributes) {
        compileInfoService.delete(compileInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/compileInfo";
    }

}
