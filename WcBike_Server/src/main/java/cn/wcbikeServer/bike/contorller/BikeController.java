package cn.wcbikeServer.bike.contorller;


import cn.wcbikeServer.bike.pojo.Bike;
import cn.wcbikeServer.bike.service.BikeServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BikeController {

//    @PostMapping("/bike")
//    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
//    public String getById(@RequestBody String data) {
//        //(@RequestBody请求时结束json类型的数据
//        System.out.println(data);
//        return "succ";
//    }

    @Autowired // 按类型注入
    private BikeServce bikeServce;


    @GetMapping("/bike")
    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
    public String getById(Bike bike) {
        //调用Service保存map
        bikeServce.save(bike);
        return "success";
    }
}
