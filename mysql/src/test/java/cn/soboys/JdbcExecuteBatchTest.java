package cn.soboys;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.soboys.kenx.JDBCExecuteBatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JdbcExecuteBatchTest {
    JDBCExecuteBatch jdbcExecuteBatch = new JDBCExecuteBatch();
    private long startTime;

    @Before
    public void  testBefor(){
        startTime=System.currentTimeMillis();

    }

    @After
    public void testAfter(){
        long useTime=System.currentTimeMillis()-startTime;
        System.out.println("执行方法时间"+ DateUtil.formatBetween(useTime));

    }

    @Test
    public void insBatch() {
        int[] success = jdbcExecuteBatch.insBatch();
        if (!StrUtil.isEmptyIfStr(success)) {
            System.out.println("批量添加行数" + success.length);
        }

    }

    @Test
    public void updBatch() {
        int[] success = jdbcExecuteBatch.updBatch();
        if (!StrUtil.isEmptyIfStr(success)) {
            System.out.println("批量更新行数" + success.length);
        }

    }

    @Test
    public void delBatch() {
        int[] success = jdbcExecuteBatch.deldBatch();
        if (!StrUtil.isEmptyIfStr(success)) {
            System.out.println("批量删除行数" + success.length);
        }

    }

}
