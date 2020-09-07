package cn.soboys;

import cn.soboys.kenx.datasource.C3p0DataSource;
import cn.soboys.kenx.datasource.DbcpDataSource;
import org.junit.Test;

public class DbcpDatasourceTest {
   DbcpDataSource dbcpDataSource=new DbcpDataSource();

    @Test
    public void testConnectionXml() {

    }

    @Test
    public void testConnectionCode() {
        dbcpDataSource.getConnectionByDBCPPoolCode();
    }

    @Test
    public void testConnectionCodeProperties() {
       dbcpDataSource.getConnectionByDBCPPoolProperties();
    }
}
