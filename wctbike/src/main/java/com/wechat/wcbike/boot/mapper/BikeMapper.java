package com.wechat.wcbike.boot.mapper;

import com.wechat.wcbike.boot.pojo.Bike;
import org.apache.ibatis.annotations.Mapper;

/**
 * 根据接口和xml配置文件生成一个操作数据库的实现类
 */
@Mapper
public interface BikeMapper {
    public void save(Bike bike);
}
