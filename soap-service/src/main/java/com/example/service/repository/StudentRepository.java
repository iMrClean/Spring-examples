package com.example.service.repository;

import com.example.generated.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Component
public class StudentRepository {

    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setName("Вася");
        student.setStandard(5);
        student.setAddress("Тушино");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Петя");
        student.setStandard(6);
        student.setAddress("Митино");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Гриша");
        student.setStandard(7);
        student.setAddress("Войковская");
        students.put(student.getName(), student);

    }

    public Student findStudent(String name) {
        return students.get(name);
    }
}