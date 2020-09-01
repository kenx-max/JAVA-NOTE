package cn.soboys.kenx.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/*
 * jdbc 通过数据连接池 Druid 获取数据库连接
 */
public class DruidDatasource {

    //通过属性文件配置，数据源工厂不需要手动配置单个属性
    public Connection getConnectionByDuridPoolProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/durid.properties"));
            // 获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            System.out.println("数据库连接成功");
            return dataSource.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //通过代码配置
    public Connection getConnectionByDBCPPoolCode() {

        try {
            DruidDataSource bds=new DruidDataSource();
            bds.setUrl("jdbc:mysql://localhost:3306/kenx_test?characterEncoding=utf-8");
            bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            bds.setUsername("root");
            bds.setPassword("root");
            bds.setInitialSize(5);
            Connection conn = bds.getConnection();
            System.out.println("数据库连接成功");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
