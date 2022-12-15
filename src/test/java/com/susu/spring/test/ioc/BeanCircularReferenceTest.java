package com.susu.spring.test.ioc;

import com.susu.spring.context.support.ClassPathXmlApplicationContext;
import com.susu.spring.test.bean.A;
import com.susu.spring.test.bean.B;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class BeanCircularReferenceTest {

    @Test
    public void circularReferenceTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-circular-reference.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        assertThat(a.getB() == b).isTrue();
    }
}
