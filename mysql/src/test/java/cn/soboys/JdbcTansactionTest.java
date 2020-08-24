package cn.soboys;

import cn.soboys.kenx.JdbcTansaction;
import org.junit.Test;

public class JdbcTansactionTest {
    JdbcTansaction jdbcTansaction = new JdbcTansaction();

    @Test
    public void insrolledAll() {
        jdbcTansaction.insrolledAll();
    }

    @Test
    public void insrolledSavepoint() {
        jdbcTansaction.insrolledSavepoint();
    }
}
