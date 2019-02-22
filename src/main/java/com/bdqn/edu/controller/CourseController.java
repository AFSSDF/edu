package com.bdqn.edu.controller;


import com.bdqn.edu.condition.CourseCondition;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.Teacher;
import com.bdqn.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * <p>
 * 排课信息 前端控制器
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ClazzService clazzService;


    @GetMapping("/course-list.html")
    public String courseList(Model model, CourseCondition courseCondition) {
        if (courseCondition == null)
            courseCondition = new CourseCondition();
        model.addAttribute("list", courseService.findCourseListByCondition(courseCondition));
        model.addAttribute("courseCondition", courseCondition);
        return "course-list";
    }

    @GetMapping("/course-add.html")
    public String toAddCourseView(Model model, String msg, @ModelAttribute Course course) {
        model.addAttribute("opt", 1);
        model.addAttribute("teacherList",teacherService.findTeacherList());
        model.addAttribute("roomList",roomService.findRoomList());
        model.addAttribute("clazzList",clazzService.findClazzList());
        return "course-edit";
    }

    @GetMapping("/course-modify.html")
    public String toModifyCourseView(Model model, String msg, Long id) {
        model.addAttribute("opt", 0);
        model.addAttribute("teacherList",teacherService.findTeacherList());
        model.addAttribute("roomList",roomService.findRoomList());
        model.addAttribute("clazzList",clazzService.findClazzList());
        model.addAttribute("course", courseService.findCourseById(id));
        return "course-edit";
    }

    @PostMapping("/course-add-save.html")
    public String doAddSaveCourse(Model model, Course course) {
        model.addAttribute("opt", 1);
        int result = courseService.saveCourse(course);
        String msg;
        if (result == 1) {
            msg = "添加成功";
        } else {
            msg = "添加失败";
        }
        model.addAttribute("teacherList",teacherService.findTeacherList());
        model.addAttribute("roomList",roomService.findRoomList());
        model.addAttribute("clazzList",clazzService.findClazzList());
        model.addAttribute("msg", msg);
        return "course-edit";
    }

    @PostMapping("/course-modify-save.html")
    public String doAddModifyCourse(Model model, Course course) {
        int result = courseService.modifyCourse(course);
        model.addAttribute("opt", 0);
        String msg;
        if (result == 1) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        model.addAttribute("teacherList",teacherService.findTeacherList());
        model.addAttribute("roomList",roomService.findRoomList());
        model.addAttribute("clazzList",clazzService.findClazzList());
        model.addAttribute("msg", msg);
        return "course-edit";
    }

    @ResponseBody
    @GetMapping("/delete-course.html")
    public Object deleteCourse(Long id) {
        return courseService.removeCourse(id) == 1 ? "" : new ArrayList();
    }
}
