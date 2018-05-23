package cn.wcbikeServer.bike.service;

import cn.wcbikeServer.bike.pojo.Bike;

public interface BikeService {

    public void save(Bike bike);

    // 重载的方式
    public void save(String bike);

    // 查找所有的单车信息
    
}
