package com.wechat.wcbike.boot.service;

import com.wechat.wcbike.boot.mapper.BikeMapper;
import com.wechat.wcbike.boot.pojo.Bike;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 根据数据库的类型操作来保存数据
 */
public class BikeServiceImpl implements BikeServer {

    // 按类型注入，会自己去找类型 数据库操作
    @Autowired
    private BikeMapper bikeMapper;

    @Override
    public void save(Bike bike) {
        // 保存至数据库
        bikeMapper.save(bike);
        bikeMapper.save(bike);
    }
}
