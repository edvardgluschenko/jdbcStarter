package org.example;

import org.example.Dao.StudentDao;
import org.example.Entity.School;
import org.example.Entity.Student;
import org.example.dto.StudentFilter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaoRunner {
    public static void main(String[] args) {

        findAllFilterTest();
        //findAllTest();
        //updateTest();
        //saveTest();
        //deleteTest();
        //findById();

    }



    private static void findAllFilterTest() {
        StudentFilter filter = new StudentFilter(2,0,5.1,"V");
        var students =StudentDao.getInstance().findAll(filter);
        System.out.println(students);
    }

    private static void findById(){
        var student1 = StudentDao.getInstance().findById(10L);
        System.out.println(student1);
        var student2 = StudentDao.getInstance().findById(12L);
        System.out.println(student2);
    }

    private static void deleteTest() {
        var studentDao= StudentDao.getInstance();
        var deletedStudent = studentDao.delete(13L);
        System.out.println(deletedStudent);
    }

    private static void saveTest() {
        var studentDao= StudentDao.getInstance();
        var student = new Student();
        student.setFirstName("Valya");
        student.setLastName("German");
        student.setCourse(1);
        student.setGradeMathemetic(5.0);
        student.setGradeHistory(10.5);
        student.setGradePhysics(6.9);
        student.setGradeChemistry(9.9);
        student.setSchoolId(1);
        var savedStudent = studentDao.save(student);
        System.out.println(savedStudent);
    }

//    private static void updateTest() {
//        var studentDao = StudentDao.getInstance();
//        var maybeStudent = studentDao.findById(10L);
//        System.out.println(maybeStudent);
//        maybeStudent.ifPresent(student -> {
//            student.setGradeMathemetic(Double.valueOf(5.8));
//            studentDao.update(student);
//            System.out.println(student);
//        });
//    }
}
