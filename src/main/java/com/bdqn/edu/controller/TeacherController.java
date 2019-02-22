package com.bdqn.edu.controller;


import com.bdqn.edu.condition.TeacherCondition;
import com.bdqn.edu.entity.Teacher;
import com.bdqn.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * <p>
 * 职员信息 前端控制器
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher-list.html")
    public String teacherList(Model model, TeacherCondition teacherCondition) {
        if (teacherCondition==null)
            teacherCondition=new TeacherCondition();
        System.out.println(teacherCondition.getIsDelete());
        model.addAttribute("list", teacherService.findTeacherListByCondition(teacherCondition));
        model.addAttribute("teacherCondition",teacherCondition);
        return "teacher-list";
    }

    @GetMapping("/teacher-add.html")
    public String toAddTeacherView(Model model, String msg, @ModelAttribute Teacher teacher) {
        model.addAttribute("opt", 1);
        return "teacher-edit";
    }

    @GetMapping("/teacher-modify.html")
    public String toModifyTeacherView(Model model, String msg, Long id) {
        model.addAttribute("opt", 0);
        model.addAttribute("teacher", teacherService.findTeacherById(id));
        return "teacher-edit";
    }

    @PostMapping("/teacher-add-save.html")
    public String doAddSaveTeacher(Model model, Teacher teacher) {
        model.addAttribute("opt", 1);
        int result = teacherService.saveTeacher(teacher);
        String msg;
        if (result == 1) {
            msg = "添加成功";
        } else {
            msg = "添加失败";
        }
        model.addAttribute("msg", msg);
        return "teacher-edit";
    }

    @PostMapping("/teacher-modify-save.html")
    public String doAddModifyTeacher(Model model, Teacher teacher) {
        int result = teacherService.modifyTeacher(teacher);
        model.addAttribute("opt", 0);
        String msg;
        if (result == 1) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        model.addAttribute("msg", msg);
        return "teacher-edit";
    }

    @ResponseBody
    @GetMapping("/delete-teacher.html")
    public Object deleteTeacher(Long id) {
        return teacherService.removeTeacher(id) == 1 ? "" : new ArrayList();
    }

    @ResponseBody
    @GetMapping("/teacherList")
    public Object teacherList(){
        return teacherService.findTeacherList();
    }
}
