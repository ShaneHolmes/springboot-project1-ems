package com.shane.ems;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class EmsApplicationTests {

    @Autowired
    ApplicationContext ioc;
    @Autowired
    DataSource dataSource;

    @Test//测试连接数据库的数据源
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test//测试容器中是否有helloService的bean
    public void testHelloService(){
        boolean b = ioc.containsBean("webStatFilter");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        System.out.println();
    }

}
