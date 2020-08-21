package cn.soboys.kenx;

import cn.hutool.core.date.DateUtil;

import java.sql.*;

/*
 * jdbc 预编译sql
 * PreparedStatement crud
 * */
public class JDBCPreparedStatement {
    BasicUse basicUse = new BasicUse();

    public int ins() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //这里参数用?占位符表示
        String sql = "insert into student (name, age, addr, hobby) values (?,?,?,?)";
        try {
            //获取数据连接
            connection = basicUse.getConnection();

            //获取发送sql指令执行sql进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //设置sql语句参数索引从1开始
            preparedStatement.setObject(1, "Tom");
            preparedStatement.setObject(2, 24);
            preparedStatement.setObject(3, "上海");
            preparedStatement.setObject(4, "篮球");

            System.out.println("执行sql" + sql);
            //执行成功返回1
            int success = preparedStatement.executeUpdate(); //注意这里不需要在放入sql
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "select * from user limit 0,1";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //获取发送sql指令执行sql对象
            preparedStatement = connection.prepareStatement(sql);
            //返回查询结果集用于保存数据库查询内容
            rs = preparedStatement.executeQuery();
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
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {
                rs.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public int update() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //这里参数用?占位符表示
        String sql = "update student set hobby=? where id = 11";
        try {
            //获取数据连接
            connection = basicUse.getConnection();

            //获取发送sql指令执行sql进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //设置sql语句参数索引从1开始
            preparedStatement.setObject(1, "足球");


            System.out.println("执行sql" + sql);
            //执行成功返回1
            int success = preparedStatement.executeUpdate(); //注意这里不需要在放入sql
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public int del() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //这里参数用?占位符表示
        String sql = "delete from student where id=?";
        try {
            //获取数据连接
            connection = basicUse.getConnection();

            //获取发送sql指令执行sql进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //设置sql语句参数索引从1开始
            preparedStatement.setObject(1, 11);


            System.out.println("执行sql" + sql);
            //执行成功返回1
            int success = preparedStatement.executeUpdate(); //注意这里不需要在放入sql
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public int[] updateBatch() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //这里参数用?占位符表示
        String sql = "update student set hobby=? where id = 11";
        try {
            //获取数据连接
            connection = basicUse.getConnection();

            //获取发送sql指令执行sql进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //批量执行sql
            for (int i = 12; i <= 16; i++) {
                //设置sql语句参数索引从1开始
                preparedStatement.setObject(1, i);
                preparedStatement.addBatch();
            }
            System.out.println("执行sql" + sql);
            //执行成功返回更新计数的数组
            int[] success = preparedStatement.executeBatch(); //注意这里不需要在放入sql
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
