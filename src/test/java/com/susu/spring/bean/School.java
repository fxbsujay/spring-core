package com.susu.spring.bean;

import com.susu.spring.beans.factory.annotation.Autowired;
import com.susu.spring.core.stereotype.Component;

@Component
public class School {

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
}
