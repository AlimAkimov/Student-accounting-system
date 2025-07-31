package org.example.service;

import org.example.exceptions.StudentNotFoundException;
import org.example.model.Student;

import java.util.HashMap;
import java.util.Optional;

public class ServiceStudentImpl implements ServiceStudent {

    private HashMap<Integer, Student> studentHashMap = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        if (studentHashMap.containsKey(student.getId())) {
            System.out.println("Студент с таким id уже cуществует");
            return;
        } else {
            studentHashMap.put(student.getId(), student);
        }
        System.out.println("Студент добавлен: " + student.getName());
    }

    @Override
    public void removeStudent(int id) {
        if (studentHashMap.containsKey(id)) {
            Student removed = studentHashMap.remove(id);
            System.out.println("Студент с id " + id + ", " + removed + " удалён");
        } else {
            System.out.println("Студент с ID " + id + " не найден");
        }
    }

    @Override
    public Student findStudent(int id) {
        if (studentHashMap.containsKey(id)) {
            return studentHashMap.get(id);
        } else {
            throw new StudentNotFoundException("Cтудент с id " + id + " не найден");
        }
    }

    @Override
    public void listAll() {
        //из условий не совсем понял каким именно for-each выводить, поэтому решил сделать оба варианта
        //1 вариант
//        if (studentHashMap.isEmpty()) {
//            System.out.println("В системе нет студентов");
//            return;
//        }
//        System.out.println("Список всех студентов через цикл for:");
//        for (Student student : studentHashMap.values()) {
//            System.out.println(student);
//        }
        // 2 вариант
        studentHashMap.values().forEach(e -> System.out.println(e));
    }

}
