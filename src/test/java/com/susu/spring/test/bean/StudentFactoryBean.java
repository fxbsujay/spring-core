package com.susu.spring.test.bean;

import com.susu.spring.beans.factory.FactoryBean;

public class StudentFactoryBean implements FactoryBean<Student> {

    private String name;

    @Override
    public Student getObject() throws Exception {
        Student student = new Student();
        student.setName(name);
        return student;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }
}
