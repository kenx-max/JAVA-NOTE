package cn.soboys;

import cn.hutool.core.util.StrUtil;
import cn.soboys.kenx.JDBCExecuteBatch;
import org.junit.Test;

public class JdbcExecuteBatchTest {
    JDBCExecuteBatch jdbcExecuteBatch = new JDBCExecuteBatch();

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
