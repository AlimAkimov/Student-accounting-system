package org.exapmle;

import org.example.exceptions.StudentNotFoundException;
import org.example.model.Student;
import org.example.service.ServiceStudentImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceStudentImplTest {
    private ServiceStudentImpl service;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        service = new ServiceStudentImpl();
        student1 = new Student(1, "Иван Петрович", 2);
        student2 = new Student(2, "Мария Владимировна", 4);
    }

    @Test
    void addStudent() {
        service.addStudent(student1);
        Student found = service.findStudent(1);
        assertEquals(student1, found);
    }

    @Test
    void removeStudent() {
        service.addStudent(student1);
        service.removeStudent(1);
        assertThrows(StudentNotFoundException.class, () -> service.findStudent(1));
    }

    @Test
    void findStudent() {
        service.addStudent(student1);
        Student found = service.findStudent(1);
        assertEquals(student1, found);
    }

    @Test
    void findStudentNotFound() {
        assertThrows(StudentNotFoundException.class, () -> service.findStudent(999));
    }

    @Test
    void listAll() {
        service.addStudent(student1);
        service.addStudent(student2);
        assertDoesNotThrow(() -> service.listAll());
    }

}
