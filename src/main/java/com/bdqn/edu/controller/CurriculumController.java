package com.bdqn.edu.controller;


import com.bdqn.edu.entity.Curriculum;
import com.bdqn.edu.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public String curriculumList(Model model){
        model.addAttribute("list",curriculumService.findCurriculumList());
        return "curriculum-list";
    }

    @GetMapping("/curriculum-add.html")
    public String toAddCurriculumView(Model model){
        model.addAttribute("opt",1);
        return "curriculum-edit";
    }

    @GetMapping("/curriculum-modify.html")
    public String toModifyCurriculumView(Model model){
        model.addAttribute("opt",1);
        return "curriculum-edit";
    }

    @PostMapping("/curriculum-add-save.html")
    public String doAddSaveCurriculum(Curriculum curriculum){
        curriculumService.saveCurriculum(curriculum);
        return "curriculum-list";
    }

    @PostMapping("/curriculum-modify-save.html")
    public String doAddModifyCurriculum(Curriculum curriculum){
        curriculumService.modifyCurriculum(curriculum);
        return "curriculum-list";
    }


}
