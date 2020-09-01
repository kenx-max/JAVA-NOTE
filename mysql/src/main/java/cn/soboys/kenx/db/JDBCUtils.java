package cn.soboys.kenx.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 封装抽离数据库统一工具类
 * 连接池工具类
 * */
public class JDBCUtils {
    /**
     * 1.定义成员变量
     */
    private static DataSource ds;

    /**
     * 2.读取配置文件
     */
    static {
        ds = new ComboPooledDataSource();
    }

    /**
     * 3.获得连接
     */
    public static Connection getConn() {
        Connection co = null;
        try {
            co = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return co;
    }

    /**
     * 4.释放连接
     */
    public static void close(PreparedStatement pstmt, Connection conn) {
        close(null, pstmt, conn);

    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
