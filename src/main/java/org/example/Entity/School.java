package org.example.Entity;

public class School {
    Long id;
    int number;
    String adress;

    public School(){};

    public School(Long id, int number, String adress){
        this.id=id;
        this.number=number;
        this.adress=adress;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public String getAdress(){
        return adress;
    }
    public void setAdress(String adress){
        this.adress=adress;
    }
    public String toString(){
        return "School{" + "school's id=" + id +
                ", school's number=" + number +
                ", school's adress='" + adress + '\'' +
                "}";
    }
}
