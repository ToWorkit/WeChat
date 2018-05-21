package com.wechat.wcbike.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 请求控制器 /bike
public class BikeController {
    @GetMapping("/bike") // get请求 /bike 接口
    @ResponseBody // 响应
    public String getById(String id) { // id 参数
        System.out.println(id);
        return "success";
    }
}
