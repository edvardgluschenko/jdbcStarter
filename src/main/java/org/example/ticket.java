package org.example;

public class ticket {
    Long id;
    String data;
    Long cost;

    public ticket() {
    }


    public ticket(Long id, String data, Long cost) {
        this.id = id;
        this.data = data;
        this.cost = cost;
    }


    public String toString() {
        return "ticket{" +
                "id=" + id +
                ", data='" + data + '\''+
                ", cost=" + cost + '}';
    }
}