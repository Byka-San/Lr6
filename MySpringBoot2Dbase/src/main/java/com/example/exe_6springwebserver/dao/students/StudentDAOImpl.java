package com.example.exe_6springwebserver.dao.students;

import com.example.exe_6springwebserver.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO{
    private final EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        Query query =  entityManager.createQuery("from Student");
        List<Student> allStudent = query.getResultList();
        if (allStudent.isEmpty()){
            log.error("база данных пуста");
            return null;
        }

        log.info("получены все студенты");
        return allStudent;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student putStudent(Student student, int id) {
        student.setId(id);

        if (getStudent(id) != null) {
            return entityManager.merge(student);
        } else {
            log.error("запись изменена");
            return null;
        }
    }

    @Override
    public Student getStudent(int id) {
        Student student = entityManager.find(Student.class,id);
        if (student == null){
            log.error("человека с таким id не найден");
            return null;
        }
        log.info("получен искомый студент");
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        getStudent(id);
        Query query = entityManager.createQuery("delete from Student where id=:studentId");
        query.setParameter("studentId",id);
        query.executeUpdate();
    }

}
