package com.yingge.qa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2020/12/25 14:43
 * @Description:
 */
@Controller
@RequestMapping("/")
public class DemoController {
    @ResponseBody
    @GetMapping("demo")
    public String demo(){
        return "鹰哥到此一游！！";
    }
}
