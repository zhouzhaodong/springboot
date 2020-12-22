package xyz.zhouzhaodong.redis_geo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.redis_geo.entity.ServiceStation;
import xyz.zhouzhaodong.redis_geo.service.RedisGeoService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 服务接口实现
 * @author zhouzhaodong
 */
@Service
@Slf4j
public class RedisGeoServiceImpl implements RedisGeoService {

    /**
     * redis的key
     */
    private final String GEO_KEY = "ah-cities";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Long saveServiceStationToRedis(Collection<ServiceStation> serviceStation) {
        log.info("start to save station info: {}.", serviceStation);

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        // 将坐标转为坐标点
        serviceStation.forEach(ci -> locations.add(new RedisGeoCommands.GeoLocation<>(
                ci.getServiceStationName(), new Point(ci.getLongitude(), ci.getLatitude())
        )));
        log.info("done to save station info.");
        return ops.add(GEO_KEY, locations);
    }

    @Override
    public List<Point> getServiceStationPos(String[] serviceStations) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        // 根据油站名称获取油站的坐标
        return ops.position(GEO_KEY, serviceStations);
    }

    @Override
    public Distance getTwoServiceStationDistance(String serviceStations1, String serviceStations2, Metric metric) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        return metric == null ?
                ops.distance(GEO_KEY, serviceStations1, serviceStations2) : ops.distance(GEO_KEY, serviceStations1, serviceStations2, metric);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(Circle within, RedisGeoCommands.GeoRadiusCommandArgs args) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        return args == null ?
                ops.radius(GEO_KEY, within) : ops.radius(GEO_KEY, within, args);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(String member, Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        return args == null ?
                ops.radius(GEO_KEY, member, distance) : ops.radius(GEO_KEY, member, distance, args);
    }

    @Override
    public List<String> getServiceStationGeoHash(String[] serviceStations) {
        GeoOperations<String, String> ops = redisTemplate.opsForGeo();
        return ops.hash(GEO_KEY, serviceStations);
    }

}
