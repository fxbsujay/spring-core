package com.susu.spring.bean;

import com.susu.spring.beans.factory.annotation.Value;
import com.susu.spring.core.stereotype.Component;

@Component
public class Student {

    @Value("${name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
