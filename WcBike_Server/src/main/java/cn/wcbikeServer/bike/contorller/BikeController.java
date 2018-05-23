package cn.wcbikeServer.bike.contorller;


import cn.wcbikeServer.bike.pojo.Bike;
import cn.wcbikeServer.bike.service.BikeService;
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
    private BikeService bikeService;

    // get请求接口
    @GetMapping("/bike")
    @ResponseBody  //响应Ajax请求，会将响应的对象转成json
    public String getById(Bike bike) {
        //调用Service保存map
        bikeService.save(bike);
        return "success";
    }

    // 重载 /bike接口的post方法
    @PostMapping("/bike")
    @ResponseBody
    public String save(@RequestBody String bike) {
        // 调用Service保存map
        bikeService.save(bike);
        return "success";
    }

    // get 方法获取所有的单车信息
    @GetMapping("/bikes")
    @ResponseBody
    public List<Bike> findAll() {
        list<Bike> bikes = bikeService.findAll();
        return bikes;
    }

}
