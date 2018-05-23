package cn.wcbikeServer.bike.service;

import cn.wcbikeServer.bike.mapper.BikeMapper;
import cn.wcbikeServer.bike.pojo.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 根据数据库的类型操作来保存数据
 */
@Transactional // mysql 事务 要成功都成功，要失败都失败
@Service // Service层，交给Spring处理(保存的操作)，在实现类上加
public class BikeServiceImpl implements BikeService {

    // 按类型注入，操作mongo数据库的模型
    @Autowired
    private MongoTemplate mongoTemplate;

    // 按类型注入，会自己去找类型 数据库操作
    @Autowired
    private BikeMapper bikeMapper;

    @Override
    public void save(Bike bike) {
        // 保存至数据库
        // 添加事务，要成功都成功，要失败都失败 // 要成功都成功，要失败都失败
        bikeMapper.save(bike);
        //int i = 100 / 0;
        bikeMapper.save(bike);
    }

    @Override
    public void save(String bike) {
        // 保存到bike集合
        mongoTemplate.save(bike, "bike");
    }
}
