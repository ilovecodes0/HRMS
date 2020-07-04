package com.so.demosboot.modules.db.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.db.entity.ModelInfo;
import com.so.demosboot.modules.db.service.ModelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/db/modelInfo")
public class ModelInfoController {

    @Autowired
    private ModelInfoService modelInfoService;

    @ModelAttribute
    public ModelInfo get(@RequestParam(required=false) String id) {
        ModelInfo entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = modelInfoService.getById(id);
        }else{
            entity = new ModelInfo();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(ModelInfo modelInfo, Model model) {
        PageHelper.startPage(modelInfo.getPageNo(),10);
        List<ModelInfo> list = modelInfoService.findList(modelInfo);
        PageInfo<ModelInfo> pageInfo = new PageInfo<ModelInfo>(list, 10);
        model.addAttribute("pageInfo",pageInfo);
        return "db/modelInfoList";
    }

    @RequestMapping(value = "form")
    public String insert(ModelInfo modelInfo, Model model){
        if(StringUtils.isNotEmpty(modelInfo.getId())){
            modelInfo = modelInfoService.getById(modelInfo.getId());
            model.addAttribute("modelInfo",modelInfo);
        }
        return "db/addModel";
    }

    @RequestMapping(value = "update")
    public String uodate(ModelInfo modelInfo, Model model){
        if(StringUtils.isNotEmpty(modelInfo.getId())){
            modelInfo = modelInfoService.getById(modelInfo.getId());
            model.addAttribute("modelInfo",modelInfo);
        }
        return "db/modifyModel";
    }

    @RequestMapping(value = "save")
    public String save(ModelInfo modelInfo, RedirectAttributes redirectAttributes){
        System.out.println(modelInfo);
        modelInfoService.save(modelInfo);
        redirectAttributes.addFlashAttribute("msg", "添加/保存成功！");
        return "redirect:"+"/db/modelInfo";
    }

    @RequestMapping(value = "delete")
    public String delete(ModelInfo modelInfo, RedirectAttributes redirectAttributes) {
        modelInfoService.delete(modelInfo.getId());
        redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
        return "redirect:"+"/db/modelInfo";
    }
}
