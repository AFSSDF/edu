package com.bdqn.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 其他主要 前端控制器
 * </p>
 *
 * @author Li
 * @since 2019-02-20
 */
@Controller
public class MainController {
    @GetMapping("/welcome.html")
    public String welcome(){
        return "welcome";
    }
}
