package cn.soboys.kenx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcResultSet {
    BasicUse basicUse = new BasicUse();

    /*
     * 简单数据获取遍历
     * */
    public void selectEasy() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String sql = "select * from user limit 0,50";
        try {
            //获取数据连接
            connection = basicUse.getConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            //next()---------------类似指针的效果，会向下移动；
            while (rs.next()) {
                //　getString(String columnname)-------------根据列名获取本列的值；
                //getString(int index)--------------根据索引获取指定位置的值；
                System.out.println("id" + "\t" + rs.getString(1));
                System.out.println("name" + "\t" + rs.getString(2));
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
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
