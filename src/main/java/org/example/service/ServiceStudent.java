package org.example.service;

import org.example.model.Student;

import java.util.Optional;

public interface ServiceStudent {

    void addStudent(Student student);

    void removeStudent(int id);

    Student findStudent(int id);

    void listAll();
}
