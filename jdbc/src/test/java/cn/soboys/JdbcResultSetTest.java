package cn.soboys;

import cn.soboys.kenx.JdbcResultSet;
import org.junit.Test;

public class JdbcResultSetTest {
    JdbcResultSet jdbcResultSet=new JdbcResultSet();

    @Test
    public void select() {
        jdbcResultSet.selectEasy();
    }
}
