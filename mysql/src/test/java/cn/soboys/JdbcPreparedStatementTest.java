package cn.soboys;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.soboys.kenx.JDBCPreparedStatement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JdbcPreparedStatementTest {
    JDBCPreparedStatement jdbcPreparedStatement = new JDBCPreparedStatement();
    private long startTime;

    @Before
    public void  testBefor(){
        startTime=System.currentTimeMillis();

    }

    @After
    public void testAfter(){
        long useTime=System.currentTimeMillis()-startTime;
        System.out.println("执行方法时间"+DateUtil.formatBetween(useTime));

    }

    @Test
    public void ins() {
        int success = jdbcPreparedStatement.ins();
        System.out.println(success);
    }

    @Test
    public void select() {
        jdbcPreparedStatement.select();
    }

    @Test
    public void update() {
        int success = jdbcPreparedStatement.update();
        System.out.println(success);
    }

    @Test
    public void updBatch() {
        int[] success = jdbcPreparedStatement.updateBatch();
        if (!StrUtil.isEmptyIfStr(success)) {
            System.out.println("批量更新行数" + success.length);
        }

    }

    @Test
    public void del() {
        int success = jdbcPreparedStatement.del();
        System.out.println(success);
    }
}
