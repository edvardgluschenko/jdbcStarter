package org.example.Dao;

import org.example.Entity.Student;
import org.example.exception.DaoException;
import org.example.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao {
    private static final StudentDao INSTANCE = new StudentDao();
private static final String DELETE_SQL= """
        delete from students
        where id=?
        """;
private static final String SAVE_SQL= """
        insert into Students(first_name, last_name, course, grade_mathemetic, grade_history, grade_physics, grade_chemistry, school_id)
        values(?, ?, ?, ?, ?, ?, ?, ?)
        """;
private static final String UPDATE_SQL= """
        update students
        set first_name=?,
            last_name=?,
             course=?,
             grade_mathemetic=?,
             grade_history=?,
             grade_physics=?,
             grade_chemistry=?,
             school_id=?
             where id=?
        """;

private static final String FIND_ALL= """
        select id,
               first_name,
               last_name,
               course,
               grade_mathemetic,
               grade_history,
               grade_physics,
               grade_chemistry,
               school_id
               from students
        """;


private static final String FIND_BY_ID = FIND_ALL+"""
               where id=?
        """;

    private StudentDao(){
    }

    public List<Student> findAll(){
        try(var connection = ConnectionManager.get();
        var prepareStatement= connection.prepareStatement(FIND_ALL)){
            var resultSet=prepareStatement.executeQuery();
            List <Student> students = new ArrayList<>();
            while(resultSet.next()){
                students.add(buildStudent(resultSet));
            }
            return students;
        }catch (SQLException throwables){
            throw new DaoException(throwables);
        }

    }


    public Optional<Student> findById(Long id){
        try(var connection = ConnectionManager.get();
        var prepareStatement= connection.prepareStatement(FIND_BY_ID)){
         prepareStatement.setLong(1,id);
         var resultSet =prepareStatement.executeQuery();
         Student students =null;
         if(resultSet.next()){
             students= buildStudent(resultSet);
         }

        return Optional.ofNullable(students);}
        catch (SQLException throwables){
            throw new DaoException(throwables);
        }
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getInt("course"),
                resultSet.getDouble("grade_mathemetic"),
                resultSet.getDouble("grade_history"),
                resultSet.getDouble("grade_physics"),
                resultSet.getDouble("grade_chemistry"),
                resultSet.getInt("school_id"));

    }

    public void update(Student student){
        try(var connection = ConnectionManager.get();
        var prepareStatement= connection.prepareStatement(UPDATE_SQL))
        {
            prepareStatement.setString(1,student.getFirstName());
            prepareStatement.setString(2,student.getLastName());
           prepareStatement.setLong(3,student.getCourse());
            prepareStatement.setDouble(4,student.getGradeMathemetic());
           prepareStatement.setDouble(5,student.getGradeHistory());
            prepareStatement.setDouble(6,student.getGradePhysics());
            prepareStatement.setDouble(7,student.getGradeChemistry());
            prepareStatement.setLong(8,student.getSchoolId());
            prepareStatement.setLong(9,student.getId());

            prepareStatement.executeUpdate();
        }catch (SQLException throwables){
            throw new DaoException(throwables);
        }
    }

    public Student save(Student student){
        try(var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setLong(3, student.getCourse());
            preparedStatement.setDouble(4, student.getGradeMathemetic());
            preparedStatement.setDouble(5, student.getGradeHistory());
            preparedStatement.setDouble(6, student.getGradePhysics());
            preparedStatement.setDouble(7, student.getGradeChemistry());
            preparedStatement.setLong(8, student.getSchoolId());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){

                student.setId(generatedKeys.getLong("id"));
            }
return student;
        }catch (SQLException throwables){
           throw new DaoException (throwables);
        }

    }

    public boolean delete(Long id){
        try(var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;

        }catch (SQLException throwables){
           throw new DaoException(throwables);
        }
    }

    public static StudentDao getInstance(){
        return INSTANCE;
    }
}
