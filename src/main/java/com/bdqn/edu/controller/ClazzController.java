package com.bdqn.edu.controller;


import com.bdqn.edu.condition.ClazzCondition;
import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * <p>
 * 班级信息 前端控制器
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Controller
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping("/clazz-list.html")
    public String clazzList(Model model, ClazzCondition clazzCondition) {
        if (clazzCondition==null)
            clazzCondition=new ClazzCondition();
        model.addAttribute("list", clazzService.findClazzListByCondition(clazzCondition));
        model.addAttribute("clazzCondition", clazzCondition);
        return "clazz-list";
    }

    @GetMapping("/clazz-add.html")
    public String toAddClazzView(Model model, String msg, @ModelAttribute Clazz clazz) {
        model.addAttribute("opt", 1);
        return "clazz-edit";
    }

    @GetMapping("/clazz-modify.html")
    public String toModifyClazzView(Model model, String msg, Long id) {
        model.addAttribute("opt", 0);
        model.addAttribute("clazz", clazzService.findClazzById(id));
        return "clazz-edit";
    }

    @PostMapping("/clazz-add-save.html")
    public String doAddSaveClazz(Model model, Clazz clazz) {
        model.addAttribute("opt", 1);
        int result = clazzService.saveClazz(clazz);
        String msg;
        if (result == 1) {
            msg = "添加成功";
        } else {
            msg = "添加失败";
        }
        model.addAttribute("msg", msg);
        return "clazz-edit";
    }

    @PostMapping("/clazz-modify-save.html")
    public String doAddModifyClazz(Model model, Clazz clazz) {
        int result = clazzService.modifyClazz(clazz);
        model.addAttribute("opt", 0);
        String msg;
        if (result == 1) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        model.addAttribute("msg", msg);
        return "clazz-edit";
    }

    @ResponseBody
    @GetMapping("/delete-clazz.html")
    public Object deleteClazz(Long id) {
        return clazzService.removeClazz(id) == 1 ? "" : new ArrayList();
    }

    @ResponseBody
    @GetMapping("/clazzList")
    public Object clazzList(ClazzCondition clazzCondition){
        return clazzService.findClazzListByCondition(clazzCondition);
    }
}

