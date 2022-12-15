package com.susu.spring.test.bean;

import com.susu.spring.beans.factory.DisposableBean;
import com.susu.spring.beans.factory.InitializingBean;
import com.susu.spring.beans.factory.annotation.Autowired;
import com.susu.spring.core.stereotype.Component;

@Component
public class School implements InitializingBean, DisposableBean {

    private String name;

    @Autowired
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }

    public void initMethod() {
        System.out.println("I was born in the method named customInitMethod");
    }

    public void destroyMethod() {
        System.out.println("I died in the method named customDestroyMethod");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Bean 销毁了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean 初始化了");
    }
}
