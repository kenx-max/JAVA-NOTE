package cn.soboys;

import cn.soboys.kenx.BasicUse;
import cn.soboys.kenx.datasource.C3p0DataSource;
import org.junit.Test;

public class C3p0DatasourceTest {
    C3p0DataSource c3p0DataSource = new C3p0DataSource();

    @Test
    public void testConnectionXml() {
        c3p0DataSource.getConnectionByC3p0PoolXml();
    }

    @Test
    public void testConnectionCode() {
        c3p0DataSource.getConnectionByC3p0PoolCode();
    }

    @Test
    public void testConnectionCodeProperties() {
        c3p0DataSource.getConnectionByC3p0PoolProperties();
    }
}
