package com.example.exe_6springwebserver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "surname")
    @NotBlank
    private String surname;

    @Column(name = "faculty")
    @NotBlank
    private String faculty;

    @Column(name = "age")
    @NotNull
    private int age;

    public Student(String name, String surname, String faculty, int age) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.age = age;
    }

}
