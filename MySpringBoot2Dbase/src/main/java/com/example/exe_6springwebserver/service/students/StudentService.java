package com.example.exe_6springwebserver.service.students;

import com.example.exe_6springwebserver.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudent();
    Student getStudent(int id);
    Student putStudent(Student student,int id);
    Student saveStudent(Student student);
    void deleteStudent(int id);
}
