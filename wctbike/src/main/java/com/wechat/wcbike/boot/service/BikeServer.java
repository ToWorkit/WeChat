package com.wechat.wcbike.boot.service;

import com.wechat.wcbike.boot.pojo.Bike;

/**
 * 以接口的形式对数据进行操作
 *      相当于解耦数据操作的配置文件
 */
public interface BikeServer {
    public void save(Bike bike);
}
