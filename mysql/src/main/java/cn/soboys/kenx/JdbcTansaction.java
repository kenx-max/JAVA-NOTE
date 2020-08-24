package cn.soboys.kenx;

import cn.hutool.core.util.StrUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/*
 * JDBC 事务提交与回滚
 * */
public class JdbcTansaction {
    BasicUse basicUse = new BasicUse();

    /*
     * 发生异常回滚所有执行更新的sql
     * */
    public void insrolledAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        //这里参数用?占位符表示
        String sqlTeacher = "insert into teacher ( name, age, hobby, addr) values (?,?,?,?)";
        String sqlStudent = "insert into student (name, age, addr, hobby) values (?,?,?,?)";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //设置事务自动提交为手动提交
            connection.setAutoCommit(false);

            //获取发送sql指令执行sql进行预编译
            preparedStatement = connection.prepareStatement(sqlStudent);

            //设置sql语句参数索引从1开始
            preparedStatement.setObject(1, "Tom");
            preparedStatement.setObject(2, 24);
            preparedStatement.setObject(3, "上海");
            preparedStatement.setObject(4, "篮球");
            preparedStatement.executeUpdate();
            System.out.println("执行sqlStudent" + sqlStudent);

            //手动制造异常
            int i = 10 / 0;

            preparedStatement1 = connection.prepareStatement(sqlTeacher);
            preparedStatement1.setObject(1, "kenx");
            preparedStatement1.setObject(2, 24);
            preparedStatement1.setObject(3, "足球");
            preparedStatement1.setObject(4, "北京");
            preparedStatement1.executeUpdate();
            System.out.println("执行sqlTeacher" + sqlTeacher);

            //提交事务
            connection.commit();

        } catch (Exception e) {
            //回滚事务
            try {
                connection.rollback();
                System.out.println("JDBC Transaction rolled back successfully");
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e1.getMessage());
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {
                preparedStatement.close();
                preparedStatement1.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


    /*
     * 发生异常回滚到指定的位置
     * */
    public void insrolledSavepoint() {
        Savepoint savepoint = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        //这里参数用?占位符表示
        String sqlTeacher = "insert into teacher ( name, age, hobby, addr) values (?,?,?,?)";
        String sqlStudent = "insert into student (name, age, addr, hobby) values (?,?,?,?)";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //设置事务自动提交为手动提交
            connection.setAutoCommit(false);

            //获取发送sql指令执行sql进行预编译
            preparedStatement = connection.prepareStatement(sqlStudent);

            //设置sql语句参数索引从1开始
            preparedStatement.setObject(1, "JDBC");
            preparedStatement.setObject(2, 24);
            preparedStatement.setObject(3, "上海");
            preparedStatement.setObject(4, "篮球");
            preparedStatement.executeUpdate();
            System.out.println("执行sqlStudent" + sqlStudent);


            //设置回滚的点  失败只会回滚老师信息
            savepoint = connection.setSavepoint("teacher");

            preparedStatement1 = connection.prepareStatement(sqlTeacher);
            preparedStatement1.setObject(1, "kenx");
            preparedStatement1.setObject(2, 24);
            preparedStatement1.setObject(3, "足球");
            preparedStatement1.setObject(4, "北京");
            preparedStatement1.executeUpdate();
            System.out.println("执行sqlTeacher" + sqlTeacher);

               //手动制造异常
               int i = 10 / 0;
            //提交事务
            connection.commit();


        } catch (Exception e) {
            //回滚事务
            try {
                if (StrUtil.isEmptyIfStr(savepoint)) {
                    //回滚所有更新sql
                    connection.rollback();
                    System.out
                            .println("JDBC Transaction rolled back successfully");
                } else {
                    connection.rollback(savepoint);
                    System.out.println("JDBC Transaction rolled back successfully");
                    connection.commit();
                }

            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e1.getMessage());
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {
                preparedStatement.close();
                preparedStatement1.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


}
