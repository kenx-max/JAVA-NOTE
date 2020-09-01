package cn.soboys;

import cn.soboys.kenx.datasource.DruidDatasource;
import org.junit.Test;

public class DuridDatasourceTest {
  DruidDatasource druidDataSource=new DruidDatasource();

    @Test
    public void testConnectionXml() {

    }

    @Test
    public void testConnectionCode() {
      druidDataSource.getConnectionByDBCPPoolCode();
    }

    @Test
    public void testConnectionCodeProperties() {
        druidDataSource.getConnectionByDuridPoolProperties();
    }
}
