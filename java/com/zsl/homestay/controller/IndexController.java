package com.zsl.homestay.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
测试回退1.0
测试回退2.0
测试回退3.0
测试回退4.0
    @GetMapping("/index")
    @ApiOperation(value="首页")
    public String index() {
        return "index";
    }
}
