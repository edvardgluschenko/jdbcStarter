package org.example.Entity;

import java.util.Objects;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private int course;
    private double gradeMathemetic;
    private double gradeHistory;
    private double gradePhysics;
    private double gradeChemistry;
    private int schoolId;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, int course, double gradeMathemetic,
                   double gradeHistory, double gradePhysics, double gradeChemistry, int schoolId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName=lastName;
        this.course=course;
        this.gradeMathemetic=gradeMathemetic;
        this.gradeHistory=gradeHistory;
        this.gradePhysics=gradePhysics;
        this.gradeChemistry=gradeChemistry;
        this.schoolId=schoolId;
    }

    public Long getId (){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public int getCourse(){
        return course;
    }
    public void setCourse(int course){
        this.course=course;
    }
    public double getGradeMathemetic(){
        return gradeMathemetic;
    }
    public void setGradeMathemetic(double gradeMathemetic){
        this.gradeMathemetic=gradeMathemetic;
    }
    public double getGradeHistory (){
        return gradeHistory;
    }
    public void setGradeHistory(double gradeHistory){
        this.gradeHistory=gradeHistory;
    }
    public double getGradePhysics(){
        return gradePhysics;
    }
    public void setGradePhysics(double gradePhysics){
        this.gradePhysics=gradePhysics;
    }
    public double getGradeChemistry(){
        return gradeChemistry;
    }
    public void setGradeChemistry(double gradeChemistry){
        this.gradeChemistry=gradeChemistry;
    }
    public int getSchoolId(){
        return schoolId;
    }
    public void setSchoolId(int schoolId){
        this.schoolId=schoolId;
    }
    public String toString(){
        return "Student{"+"id=" +id+
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                ", gradeMathemetic=" + gradeMathemetic +
                ", gradeHistory=" + gradeHistory +
                ", gradePhysics=" + gradePhysics +
                ", gradeChemistry=" + gradeChemistry +
                ", schoolId=" + schoolId +
                "}";
    }

    public boolean equals (Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                course==student.course &&
                gradeMathemetic==student.gradeMathemetic &&
                gradeHistory==student.gradeHistory &&
                gradePhysics==student.gradePhysics &&
                gradeChemistry==student.gradeChemistry &&
                schoolId==student.schoolId;
    }

    public boolean equals1 (Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return
                        course==student.course &&
                        gradeMathemetic==student.gradeMathemetic &&
                        gradeHistory==student.gradeHistory &&
                        gradePhysics==student.gradePhysics &&
                        gradeChemistry==student.gradeChemistry &&
                        schoolId==student.schoolId;


    }

}