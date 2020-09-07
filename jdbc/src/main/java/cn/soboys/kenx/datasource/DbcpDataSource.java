package cn.soboys.kenx.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/*
 * jdbc 通过数据连接池 DBCP 获取数据库连接
 */
public class DbcpDataSource {

    //通过代码配置
    public Connection getConnectionByDBCPPoolCode() {

        try {
            BasicDataSource bds = new BasicDataSource();
            bds.setUrl("jdbc:mysql://localhost:3306/kenx_test?characterEncoding=utf-8");
            bds.setDriverClassName("com.mysql.jdbc.Driver");
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

    //通过属性文件配置，数据源工厂不需要手动配置单个属性
    public Connection getConnectionByDBCPPoolProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/dbcp.properties"));
            BasicDataSource bds = BasicDataSourceFactory.createDataSource(prop);
            System.out.println("数据库连接成功");
            return bds.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
