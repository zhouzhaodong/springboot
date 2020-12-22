package xyz.zhouzhaodong.redis_geo.service;

import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import xyz.zhouzhaodong.redis_geo.entity.ServiceStation;

import java.util.Collection;
import java.util.List;

/**
 * 服务接口定义
 * @author zhouzhaodong
 */
public interface RedisGeoService {

    /**
     * 把油站信息保存到 Redis 中
     * @param serviceStations {@link ServiceStation}
     * @return 成功保存的个数
     * */
    Long saveServiceStationToRedis(Collection<ServiceStation> serviceStations);

    /**
     * 获取给定油站的坐标
     * @param serviceStations 给定油站 key
     * @return {@link Point}s
     * */
    List<Point> getServiceStationPos(String[] serviceStations);

    /**
     * 获取两个油站之间的距离
     * @param serviceStation1 第一个油站
     * @param serviceStation2 第二个油站
     * @param metric {@link Metric} 单位信息, 可以是 null
     * @return {@link Distance}
     * */
    Distance getTwoServiceStationDistance(String serviceStation1, String serviceStation2, Metric metric);

    /**
     * 根据给定地理位置坐标获取指定范围内的地理位置集合
     * @param within {@link Circle} 中心点和距离
     * @param args {@link RedisGeoCommands.GeoRadiusCommandArgs} 限制返回的个数和排序方式, 可以是 null
     * @return {@link RedisGeoCommands.GeoLocation}
     * */
    GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(
            Circle within, RedisGeoCommands.GeoRadiusCommandArgs args);

    /**
     * 根据给定地理位置获取指定范围内的地理位置集合
     * @param member 油站名称
     * @param distance 距离范围
     * @param args {@link RedisGeoCommands.GeoRadiusCommandArgs} 限制返回的个数和排序方式, 可以是 null
     * @return
     */
    GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(
            String member, Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args);

    /**
     * 获取某个地理位置的 geohash 值
     * @param serviceStations 给定油站 key
     * @return city geohashs
     * */
    List<String> getServiceStationGeoHash(String[] serviceStations);

}
