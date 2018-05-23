package cn.wcbikeServer.bike.contorller;


import cn.wcbikeServer.bike.pojo.Bike;
import cn.wcbikeServer.bike.service.BikeServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 请求控制器 (来自 /bike 接口)
@Controller
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
    private BikeServce bikeServce;

    // get请求接口
    @GetMapping("/bike")
    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
    public String getById(Bike bike) {
        //调用Service保存map
        bikeServce.save(bike);
        return "success";
    }
}
