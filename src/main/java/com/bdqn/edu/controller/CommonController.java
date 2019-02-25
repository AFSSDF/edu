package com.bdqn.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/_meta.html")
    public String meta(){
        return "_meta";
    }

    @GetMapping("/_footer.html")
    public String footer(){
        return "_footer";
    }
}
