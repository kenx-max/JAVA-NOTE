package cn.soboys.kenx.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
 * jdbc 通过数据连接池 c3p0 获取数据库连接
 */
public class C3p0DataSource {
    //通过xml配置文件
    public Connection getConnectionByC3p0PoolXml() {
        //创建数据库连接池时，不传参数默认指default-config中参数，传入参数，则根据<name-config name="myc3p0">中的名字去找
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            //或者不使用默认的
            ComboPooledDataSource cpds2 = new ComboPooledDataSource("myc3p0");

            Connection conn = cpds.getConnection();
            System.out.println(cpds.getProperties());//这里可以输出mysql的用户名和密码；
            System.out.println(cpds.hashCode());//这里是输出连接的地址。

            System.out.println("数据库连接成功");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //通过代码配置
    public Connection getConnectionByC3p0PoolCode() {
        //创建数据库连接池时，不传参数默认指default-config中参数，传入参数，则根据<name-config name="myc3p0">中的名字去找
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/kenx_test?characterEncoding=utf-8");
            cpds.setUser("root");
            cpds.setPassword("root");
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(10);
            cpds.setCheckoutTimeout(3000);
            Connection conn = cpds.getConnection();
            System.out.println("数据库连接成功");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //通过属性文件配置，默认c3p0不支持属性文件自动装配 需要我们自己手动设置属性
    public Connection getConnectionByC3p0PoolProperties() {
        //创建数据库连接池时，不传参数默认指default-config中参数，传入参数，则根据<name-config name="myc3p0">中的名字去找
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();

            //加载配置文件
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/c3p0.properties"));

            String driver = properties.getProperty("driverClassName");
            String url = properties.getProperty("jdbcUrl");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            cpds.setDriverClass(driver);
            cpds.setJdbcUrl(url);
            cpds.setUser(username);
            cpds.setPassword(password);

            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(10);
            cpds.setCheckoutTimeout(3000);
            Connection conn = cpds.getConnection();
            System.out.println("数据库连接成功");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
