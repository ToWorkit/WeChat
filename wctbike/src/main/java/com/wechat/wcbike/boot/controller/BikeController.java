package com.wechat.wcbike.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 请求控制器 /bike
public class BikeController {

    /*
    @PostMapping("/bike") // post请求 /bike 接口
    @ResponseBody // 响应ajax请求，会将响应的对象转成json
    public String getById(@RequestBody String data) { // bid 参数
        // @RequestBody 请求时接收json类型的数据
        System.out.println(data);
        return "success";
    }
    */

    // 对数据的操作，按类型注入
    @Autowired


    @GetMapping("/bike")
    public String getById(Bike bike) {

    }
}
