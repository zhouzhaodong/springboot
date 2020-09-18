package xyz.zhouzhaodong.springbootswagger.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口返回实体类
 *
 * @author zhouzhaodong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "接口返回实体类", description = "Common Api Response")
public class ResponseBody<T> implements Serializable {
    private static final long serialVersionUID = -8987146499044811408L;
    /**
     * 返回状态
     */
    @ApiModelProperty(value = "返回状态", required = true)
    private Integer code;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息", required = true)
    private String message;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", required = true)
    private T data;
}
