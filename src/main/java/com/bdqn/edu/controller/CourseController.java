package com.bdqn.edu.controller;


import com.bdqn.edu.condition.ClazzCondition;
import com.bdqn.edu.condition.CourseCondition;
import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.CourseResultMap;
import com.bdqn.edu.service.*;
import com.bdqn.edu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        model.addAttribute("teacherList", teacherService.findTeacherList());
        model.addAttribute("roomList", roomService.findRoomList());
        model.addAttribute("clazzList", clazzService.findClazzList());
        return "course-edit";
    }

    @GetMapping("/course-modify.html")
    public String toModifyCourseView(Model model, String msg, Long id) {
        model.addAttribute("opt", 0);
        model.addAttribute("teacherList", teacherService.findTeacherList());
        model.addAttribute("roomList", roomService.findRoomList());
        model.addAttribute("clazzList", clazzService.findClazzList());
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
        model.addAttribute("teacherList", teacherService.findTeacherList());
        model.addAttribute("roomList", roomService.findRoomList());
        model.addAttribute("clazzList", clazzService.findClazzList());
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
        model.addAttribute("teacherList", teacherService.findTeacherList());
        model.addAttribute("roomList", roomService.findRoomList());
        model.addAttribute("clazzList", clazzService.findClazzList());
        model.addAttribute("msg", msg);
        return "course-edit";
    }

    @ResponseBody
    @GetMapping("/delete-course.html")
    public Object deleteCourse(Long id) {
        return courseService.removeCourse(id) == 1 ? "" : new ArrayList();
    }

    @RequestMapping("/downExcel")
    public void downExcel(HttpServletResponse response, Date begin, Date end) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sheetName = "Sheet1";
        String titleName = "ACCP(BENET/BTEST/学士后)中心班级课程表(" + dateFormat.format(begin) + "--" + dateFormat.format(end) + ")";

        CourseCondition courseCondition = new CourseCondition();
        courseCondition.setBegin(begin);
        courseCondition.setEnd(end);
        List<CourseResultMap> courseList = courseService.findCourseListByCondition(courseCondition);

        ClazzCondition clazzCondition=new ClazzCondition();
        clazzCondition.setStage("S1,S2,Y2");
        List<Clazz> clazzList = clazzService.findClazzListByCondition(clazzCondition);

        String fileName = "班级课程表";
        ExcelUtil.exportExcel(response, fileName, sheetName, titleName, begin, end, clazzList, courseList);
    }

}
