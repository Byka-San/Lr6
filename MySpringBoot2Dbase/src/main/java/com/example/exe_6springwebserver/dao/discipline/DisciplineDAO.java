package com.example.exe_6springwebserver.dao.discipline;

import com.example.exe_6springwebserver.entity.Discipline;
import com.example.exe_6springwebserver.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineDAO {
List<Discipline> getAllDiscipline();
Discipline saveDiscipline(Discipline discipline);
Discipline putDiscipline(Discipline discipline,int id);
Discipline getDiscipline(int id);
void deleteDiscipline(int id);

}
