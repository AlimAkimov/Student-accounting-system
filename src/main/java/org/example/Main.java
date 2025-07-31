package org.example;


import org.example.exceptions.StudentNotFoundException;
import org.example.model.Student;
import org.example.service.ServiceStudent;
import org.example.service.ServiceStudentImpl;

public class Main {
    public static void main(String[] args) {
        ServiceStudent serviceStudent = new ServiceStudentImpl();

        Student student1 = new Student(1, "Александр", 4);
        Student student2 = new Student(2, "Виктор", 5);
        Student student3 = new Student(3, "Иван", 3);

        serviceStudent.addStudent(student1);
        serviceStudent.addStudent(student2);
        serviceStudent.addStudent(student3);

        serviceStudent.listAll();

        serviceStudent.removeStudent(1);

        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println(serviceStudent.findStudent(i));
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}