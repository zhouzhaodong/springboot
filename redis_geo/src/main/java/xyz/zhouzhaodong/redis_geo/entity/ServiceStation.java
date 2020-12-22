package xyz.zhouzhaodong.redis_geo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 油站实体类
 * @author zhouzhaodong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceStation implements Serializable {

    /** 油站 */
    private String serviceStationName;

    /** 经度 */
    private Double longitude;

    /** 纬度 */
    private Double latitude;

}
