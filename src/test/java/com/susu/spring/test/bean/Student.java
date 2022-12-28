package com.susu.spring.test.bean;

import com.susu.spring.beans.factory.annotation.Value;
import com.susu.spring.core.stereotype.Component;
import java.time.LocalDate;

@Component
public class Student {

    @Value("${name}")
    private String name;

    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
