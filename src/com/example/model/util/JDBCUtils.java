package com.example.model.util;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
public class JDBCUtils {
    private static DataSource dataSource;
//    加载配置文件
    static {
        try {
            //数据源配置
            Properties properties=new Properties();
            //通过当前类的class对象获取资源文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("com/druid.properties");
            properties.load(is);
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn=dataSource.getConnection();
        return conn;
    }
    public static DataSource getDataSource(){
        return dataSource;
    }

}
