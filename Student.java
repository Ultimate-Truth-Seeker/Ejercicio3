package Ejercicio3;

import java.util.ArrayList;

public class Student {
    private String name;
    private String lastname;
    private int id;
    private String birthdate;
    private String email;
    private ArrayList<Grade> grades;
    public Student(String name, String lastname, int id, String birthdate, String email) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.birthdate = birthdate;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public int getId() {
        return id;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getEmail() {
        return email;
    }
    public ArrayList<Grade> getGrades() {
        return grades;
    }
    
}
