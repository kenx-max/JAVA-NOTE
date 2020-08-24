package cn.soboys.kenx;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.StrUtil;

import java.sql.*;

/*
 * jdbc:mysql:  是指JDBC连接方式；
 *127.0.0.1:       是指你的本机地址；
 * 3306               SQL数据库的端口号；
 * mysql              就是你要连接的数据库的名字。
 * characterEncoding     指定数据库连接的编码方式
 * com.mysql.jdbc.Driver  注册数据库驱动 过时
 * com.mysql.cj.jdbc.Driver  新的数据库驱动
 */
public class BasicUse {
    private long startTime;

    public Connection getConnection() {

        //mysql 连接url
        String url = "jdbc:mysql://localhost:3306/kenx_test?characterEncoding=utf-8";
        //数据库用户名
        String userName = "root";
        //数据库密码
        String passWord = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //注册数据库驱动
            Connection conn = DriverManager.getConnection(url, userName, passWord); //获取数据连接
            System.out.println("数据库连接成功");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //下面进行简单的crud 操作也就是,增加(Create)、检索(Retrieve)、更新(Update)和删除(Delete)

    public int ins() {
        Connection connection = null;
        Statement statement = null;
        String sql = "";
        try {
            //获取数据连接
            connection = getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            StringBuffer sbf = new StringBuffer("insert into user (id, name, age, email, manager_id, create_time)");
            String id = String.valueOf(System.currentTimeMillis());
            Timestamp dateTime = Timestamp.valueOf(DateUtil.now());

            sbf.append(" values (" + id + ",'kenx',24,'17521197955@163.com',155065178165505,'" + dateTime + "')");
            sql = sbf.toString();
            System.out.println("执行sql" + sql);
            //执行成功返回1
            int success = statement.executeUpdate(sql);
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try{

                statement.close();
                connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public void select() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String sql = "select * from user limit 0,1";
        try {
            //获取数据连接
            connection = getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            while (rs.next()) {
                System.out.println("id" + "\t" + rs.getString("id"));
                System.out.println("name" + "\t" + rs.getString("name"));
                System.out.println("age" + "\t" + rs.getString("age"));
                System.out.println("email" + "\t" + rs.getString("email"));
                System.out.println("manager_id" + "\t" + rs.getString("manager_id"));
                System.out.println("create_time" + "\t" + rs.getString("create_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try{
                rs.close();
                statement.close();
                connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }


    public int update() {
        Connection connection = null;
        Statement statement = null;
        String sql = "update user\n" +
                "set manager_id =155065512602445\n" +
                "where id=1597890374878";
        try {
            //获取数据连接
            connection = getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //更新成功返回1
            int success = statement.executeUpdate(sql);
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try{
                statement.close();
                connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }


    public int del(){
        Connection connection = null;
        Statement statement = null;
        String sql = "delete from user where id='1597890374878'";
        try {
            //获取数据连接
            connection = getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //删除成功返回1
            int success = statement.executeUpdate(sql);
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try{
                statement.close();
                connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }


    public  void closeConnection(ResultSet rs,Statement statement,Connection connection){
        //关闭数据库的资源的顺序最好与使用的顺序相反
        try{
            if(!StrUtil.isEmptyIfStr(rs)){
                rs.close();
            }
            if(!StrUtil.isEmptyIfStr(statement)){
                statement.close();
            }

            if(!StrUtil.isEmptyIfStr(connection)){
                connection.close();
            }

            statement.close();

        }catch (Exception e){
            System.out.println("资源释放错误");
            e.printStackTrace();
        }

    }



}
