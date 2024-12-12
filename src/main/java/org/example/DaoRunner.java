package org.example;

import org.example.Dao.StudentDao;
import org.example.Entity.Student;

import java.math.BigDecimal;

public class DaoRunner {
    public static void main(String[] args) {
        var studentDao = StudentDao.getInstance();
        var maybeStudent = studentDao.findById(10L);
        System.out.println(maybeStudent);
    }
}
