package xyz.zhouzhaodong.redis_geo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import xyz.zhouzhaodong.redis_geo.entity.ServiceStation;
import xyz.zhouzhaodong.redis_geo.service.RedisGeoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RedisGeoApplicationTests {


    @Autowired
    private RedisGeoService geoService;

    /**
     * 测试 把油站信息保存到 Redis 中
     * */
    @Test
    public void testSaveServiceStationToRedis() {
        List<ServiceStation> serviceStations = new ArrayList<>();
        serviceStations.add(new ServiceStation("金盾", 117.17, 31.52));
        serviceStations.add(new ServiceStation("中石油", 117.02, 30.31));
        serviceStations.add(new ServiceStation("中石化", 116.47, 33.57));
        serviceStations.add(new ServiceStation("山东石化", 116.58, 33.38));
        serviceStations.add(new ServiceStation("青岛石化", 115.48, 32.54));
        serviceStations.add(new ServiceStation("壳牌", 117.21, 32.56));
        serviceStations.add(new ServiceStation("中国化工", 118.18, 29.43));
        System.out.println(geoService.saveServiceStationToRedis(serviceStations));
    }

    /**
     * 测试 获取给定油站的坐标
     * 如果传递的 city 在 Redis 中没有记录, 会返回什么呢 ? 例如, 这里传递的 xxx
     * */
    @Test
    public void testGetServiceStationPos() {

        System.out.println(geoService.getServiceStationPos(
                Arrays.asList("中石油", "中石化", "xxx").toArray(new String[3])
        ));
    }

    /**
     * 测试 获取两个油站之间的距离
     * */
    @Test
    public void testGetTwoServiceStationDistance() {

        System.out.println(geoService.getTwoServiceStationDistance("壳牌", "金盾", null).getValue());
        System.out.println(geoService.getTwoServiceStationDistance("壳牌", "金盾", Metrics.KILOMETERS).getValue());
    }

    /**
     * 测试 根据给定地理位置坐标获取指定范围内的地理位置集合
     * */
    @Test
    public void testGetPointRadius() {

        Point center = new Point(117.17, 31.52);
        Distance radius = new Distance(140, Metrics.KILOMETERS);
        Circle within = new Circle(center, radius);

        System.out.println(geoService.getPointRadius(within, null));

        // 获取前两个油站位置, 同时返回距离中心点的距离
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(2).sortAscending();
        System.out.println(geoService.getPointRadius(within, args));
    }

    /**
     * 测试 根据给定地理位置获取指定范围内的地理位置集合
     * */
    @Test
    public void testGetMemberRadius() {

        Distance radius = new Distance(200, Metrics.KILOMETERS);

        System.out.println(geoService.getMemberRadius("金盾", radius, null));

        // order by 距离 limit 2, 同时返回距离中心点的距离
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(2).sortAscending();
        System.out.println(geoService.getMemberRadius("金盾", radius, args));
    }

    /**
     * 测试 获取某个地理位置的 geohash 值
     * */
    @Test
    public void testGetServiceStationGeoHash() {

        System.out.println(geoService.getServiceStationGeoHash(
                Arrays.asList("中石化", "中石油", "xxx").toArray(new String[3])
        ));
    }
}
