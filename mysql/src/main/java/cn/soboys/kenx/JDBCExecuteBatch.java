package cn.soboys.kenx;

import cn.hutool.core.date.DateUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/*
 * jdbc批量操作
 * 更新，删除，添加
 */
public class JDBCExecuteBatch {
    BasicUse basicUse = new BasicUse();

    public int[] insBatch() {
        Connection connection = null;
        Statement statement = null;
        String sql = "";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            for (int i = 0; i < 10; i++) {
                StringBuffer sbf = new StringBuffer("insert into student (name, age, addr, hobby) ");
                sbf.append(" values ('kenx',24,'上海','篮球')");
                sql = sbf.toString();
                System.out.println("执行sql" + sql);
                //将指定SQL添加到Statement对象的当前命令列表中
                statement.addBatch(sql);
            }
            //执行成功返回更新计数的数组
            int[] success = statement.executeBatch();  //批量执行所有sql返回一个更新计数的数组
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public int[] updBatch() {
        Connection connection = null;
        Statement statement = null;
        String sql = "";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            for (int i = 12; i <= 16; i++) {
                StringBuffer sbf = new StringBuffer("update student set  hobby='足球'");
                sbf.append(" where id=" + i);
                sql = sbf.toString();
                System.out.println("执行sql" + sql);
                //将指定SQL添加到Statement对象的当前命令列表中
                statement.addBatch(sql);
            }
            //执行成功返回更新计数的数组
            int[] success = statement.executeBatch();  //批量执行所有sql返回一个更新计数的数组
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public int[] deldBatch() {
        Connection connection = null;
        Statement statement = null;
        String sql = "";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            for (int i = 1; i < 10; i++) {
                StringBuffer sbf = new StringBuffer("delete from student ");
                sbf.append(" where id=" + i);
                sql = sbf.toString();
                System.out.println("执行sql" + sql);
                //将指定SQL添加到Statement对象的当前命令列表中
                statement.addBatch(sql);
            }
            //执行成功返回更新计数的数组
            int[] success = statement.executeBatch();  //批量执行所有sql返回一个更新计数的数组
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {

                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
