package com.example.exe_6springwebserver.controller;

import com.example.exe_6springwebserver.entity.Discipline;
import com.example.exe_6springwebserver.entity.Student;
import com.example.exe_6springwebserver.service.discipline.DisciplineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/dis")
@Slf4j
public class DisciplineController {
   private final DisciplineService disciplineService;
    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/discipline")
    public List<Discipline> showAllDiscipline(){
        List<Discipline> allDiscipline = disciplineService.getAllDiscipline();
        return allDiscipline;
    }
    @GetMapping("/discipline/{id}")
    public Discipline getDiscipline(@PathVariable("id") int id){
        return disciplineService.getDiscipline(id);
    }

    @PostMapping("/discipline")
    public Discipline saveDiscipline(@RequestBody @Valid Discipline discipline, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("не верный запрос на добавление данных");
            return null;
        }
        log.info("Дисциплина успешно добавлена");
        return disciplineService.saveDiscipline(discipline);
    }

    @PutMapping("discipline/{id}")
    public Discipline updeteDiscipline(@PathVariable("id") int id,@RequestBody @Valid Discipline discipline){
        return disciplineService.putDiscipline(discipline,id);
    }
    @DeleteMapping("/discipline/{id}")
    public void deleteDiscipline(@PathVariable("id") int id){
        disciplineService.deleteDiscipline(id);
    }
}
