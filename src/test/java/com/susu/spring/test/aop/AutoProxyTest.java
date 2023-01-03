package com.susu.spring.test.aop;

import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import com.susu.spring.test.service.WorldService;
import org.junit.Test;

public class AutoProxyTest {

    @Test
    public void autoProxyTest() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");

        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
    }
}
