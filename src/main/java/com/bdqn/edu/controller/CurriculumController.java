package com.bdqn.edu.controller;


import com.bdqn.edu.condition.CurriculumCondition;
import com.bdqn.edu.entity.Curriculum;
import com.bdqn.edu.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * <p>
 * 课程信息 前端控制器
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Controller
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;

    @GetMapping("/curriculum-list.html")
    public String curriculumList(Model model, CurriculumCondition curriculumCondition) {
        if (curriculumCondition == null)
            curriculumCondition = new CurriculumCondition();
        model.addAttribute("list", curriculumService.findCurriculumListByCondition(curriculumCondition));
        model.addAttribute("curriculumCondition", curriculumCondition);
        return "curriculum-list";
    }

    @GetMapping("/curriculum-add.html")
    public String toAddCurriculumView(Model model, String msg, @ModelAttribute Curriculum curriculum) {
        model.addAttribute("opt", 1);
        return "curriculum-edit";
    }

    @GetMapping("/curriculum-modify.html")
    public String toModifyCurriculumView(Model model, String msg, Long id) {
        model.addAttribute("opt", 0);
        model.addAttribute("curriculum", curriculumService.findCurriculumById(id));
        return "curriculum-edit";
    }

    @PostMapping("/curriculum-add-save.html")
    public String doAddSaveCurriculum(Model model, Curriculum curriculum) {
        model.addAttribute("opt", 1);
        int result = curriculumService.saveCurriculum(curriculum);
        String msg;
        if (result == 1) {
            msg = "添加成功";
        } else {
            msg = "添加失败";
        }
        model.addAttribute("msg", msg);
        return "curriculum-edit";
    }

    @PostMapping("/curriculum-modify-save.html")
    public String doAddModifyCurriculum(Model model, Curriculum curriculum) {
        int result = curriculumService.modifyCurriculum(curriculum);
        model.addAttribute("opt", 0);
        String msg;
        if (result == 1) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        model.addAttribute("msg", msg);
        return "curriculum-edit";
    }

    @ResponseBody
    @GetMapping("/delete-curriculum.html")
    public Object deleteCurriculum(Long id) {
        return curriculumService.removeCurriculum(id) == 1 ? "" : new ArrayList();
    }

    @ResponseBody
    @GetMapping("/curriculumList")
    public Object curriculumList(CurriculumCondition curriculumCondition) {
        return curriculumService.findCurriculumListByCondition(curriculumCondition);
    }

    @ResponseBody
    @GetMapping("/curriculum/{id}")
    public Object curriculum(@PathVariable Long id) {
        return curriculumService.findCurriculumById(id);
    }
}
