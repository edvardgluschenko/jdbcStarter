import org.example.Dao.StudentDao;
import org.example.Entity.School;
import org.example.Entity.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckProcedurs {
    @Test
    void cTest(){
        var student1 = new Student(15L, "Vika","Ganova",1, 5.0, 10.5, 6.9, 9.9, 1);
        System.out.println(student1);
        var student2 = StudentDao.getInstance().findById(15L);
        System.out.println(student2);
        var student3 = new Student(15L, "Vika","Ganova",1, 5.0, 10.5, 6.9, 9.9, 1);
        System.out.println(student3);
        assertTrue(student1.equals(student3));
        System.out.println(student1.equals1(student3));
    }

@Test
void dwTest(){
        var s =new School(2L, 4, "library");
    System.out.println(s);
}
}
