package cn.soboys;

import cn.soboys.kenx.BasicUse;
import org.junit.Test;

public class BasicUseTest {

    BasicUse basicUse = new BasicUse();

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
