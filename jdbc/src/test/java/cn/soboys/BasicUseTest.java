package cn.soboys;

import cn.hutool.core.date.DateUtil;
import cn.soboys.kenx.BasicUse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicUseTest {

    BasicUse basicUse = new BasicUse();
    private long startTime;

    @Before
    public void testBefor() {
        startTime = System.currentTimeMillis();

    }

    @After
    public void testAfter() {
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println("执行方法时间" + DateUtil.formatBetween(useTime));

    }

    @Test
    public void testConnection() {
        basicUse.getConnection();
    }

    @Test
    public void ins() {
        int success = basicUse.ins();
        System.out.println(success);
    }

    @Test
    public void select() {
        basicUse.select();
    }

    @Test
    public void update() {
        int success = basicUse.update();
        System.out.println(success);
    }

    @Test
    public void del() {
        int success = basicUse.update();
        System.out.println(success);
    }
}
