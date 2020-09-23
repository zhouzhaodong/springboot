package xyz.zhouzhaodong.springbootureport2.config;

import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Ureport 数据源
 *
 * @author zhouzhaodong
 */

@Component
public class UreportDataSource implements BuildinDatasource {
    private static final String NAME = "MyDataSource";
    private final Logger log = LoggerFactory.getLogger(UreportDataSource.class);

    @Resource
    private DataSource dataSource;

    /**
     * 数据源名称
     **/
    @Override
    public String name() {
        return NAME;
    }

    /**
     * 获取连接
     **/
    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Ureport 数据源 获取连接失败！");
            e.printStackTrace();
        }
        return null;
    }

}
