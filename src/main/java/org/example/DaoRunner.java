package org.example;

import org.example.Dao.StudentDao;
import org.example.Entity.Student;
import org.example.dto.StudentFilter;

import java.math.BigDecimal;
import java.util.List;

public class DaoRunner {
    public static void main(String[] args) {

        //findAllFilterTest();
        findAllTest();
        //updateTest();
        //saveTest();
        //deleteTest();
    }

    private static void findAllFilterTest() {
        StudentFilter filter = new StudentFilter(2,0,5.1,"V");
        var students =StudentDao.getInstance().findAll(filter);
        System.out.println(students);
    }

    private static void findAllTest() {
        var students = StudentDao.getInstance().findAll();
        System.out.println(students);
    }

    private static void deleteTest() {
        var studentDao= StudentDao.getInstance();
        var deletedStudent = studentDao.delete(8L);
        System.out.println(deletedStudent);
    }

    private static void saveTest() {
        var studentDao= StudentDao.getInstance();
        var student = new Student();
        student.setFirstName("Viktoria");
        student.setLastName("Romanova");
        student.setCourse(3);
        student.setGradeMathemetic(11.0);
        student.setGradeHistory(10.5);
        student.setGradePhysics(11.9);
        student.setGradeChemistry(9.9);
        student.setSchoolId(1);
        var savedStudent = studentDao.save(student);
        System.out.println(savedStudent);
    }

    private static void updateTest() {
        var studentDao = StudentDao.getInstance();
        var maybeStudent = studentDao.findById(10L);
        System.out.println(maybeStudent);
        maybeStudent.ifPresent(student -> {
            student.setGradeMathemetic(Double.valueOf(5.5));
            studentDao.update(student);
            System.out.println(student);
        });
    }
}
