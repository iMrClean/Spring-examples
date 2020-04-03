package com.example.service.service;

import com.example.generated.StudentDetailsRequest;
import com.example.generated.StudentDetailsResponse;
import com.example.service.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDetailsResponse getStudent(StudentDetailsRequest request) {
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(studentRepository.findStudent(request.getName()));
        return response;
    }

}
