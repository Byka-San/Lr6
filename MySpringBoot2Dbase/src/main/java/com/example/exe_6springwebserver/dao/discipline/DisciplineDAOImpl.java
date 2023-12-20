package com.example.exe_6springwebserver.dao.discipline;

import com.example.exe_6springwebserver.entity.Discipline;
import com.example.exe_6springwebserver.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO {
    private final EntityManager entityManager;
    @Autowired
    public DisciplineDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Discipline> getAllDiscipline() {
        Query query =  entityManager.createQuery("from Discipline ");
        List<Discipline> allDiscipline = query.getResultList();
        if (allDiscipline.isEmpty()){
            log.error("база данных пуста");
            return null;
        }

        log.info("получены все дисциплины");
        return allDiscipline;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return entityManager.merge(discipline);
    }

    @Override
    public Discipline putDiscipline(Discipline discipline, int id) {
        discipline.setId(id);

        if (getDiscipline(id) != null) {
            return entityManager.merge(discipline);
        } else {
            log.info("запись успешно изменена");
            return null;
        }
    }

    @Override
    public Discipline getDiscipline(int id) {
        Discipline discipline = entityManager.find(Discipline.class,id);
        if (discipline== null){
            log.error("Дисциплины с таким id не существует");
            return null;
        }
        log.info("получена искомая дисциплина");
        return discipline;
    }

    @Override
    public void deleteDiscipline(int id) {
        getDiscipline(id);
        Query query = entityManager.createQuery("delete from Discipline where id=:disciplineId");
        query.setParameter("disciplineId",id);
        query.executeUpdate();
        log.info("дисциплина успешна удалена");
    }

}
