package com.example.exe_6springwebserver.service.students;

import com.example.exe_6springwebserver.dao.students.StudentDAO;
import com.example.exe_6springwebserver.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    private final StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    public Student putStudent(Student student,int id) {
        return studentDAO.putStudent(student,id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }


    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
