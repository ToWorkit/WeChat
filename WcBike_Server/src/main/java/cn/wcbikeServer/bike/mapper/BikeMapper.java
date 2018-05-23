package cn.wcbikeServer.bike.mapper;

import cn.wcbikeServer.bike.pojo.Bike;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 根据接口和xml配置文件生成一个操作数据库的实现类
public interface BikeMapper {

    public void save(Bike bike);
}
