package Ejercicio3;

import java.util.ArrayList;
/**
 * Clase que define estudiante
 * @author Ultimate-Truth-Seeker
 * @version 03/09/2023
 */
public class Student {
    private String name;
    private String lastname;
    private int id;
    private String birthdate;
    private String email;
    private ArrayList<Grade> grades;
    /**
     * Constructor de la clase
     * @param name
     * @param lastname
     * @param id
     * @param birthdate
     * @param email
     */
    public Student(String name, String lastname, int id, String birthdate, String email) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.birthdate = birthdate;
        this.email = email;
        this.grades = new ArrayList<Grade>();
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
    public void addGrade(Grade grade) {
        grades.add(grade);
    }
    public ArrayList<Integer> getGradeGroup(String campus, String course) {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (Grade grade : grades) {
            if (grade.getCampus() == campus && grade.getCourse() == course){
                scores.add(grade.getScore());
            }
        }
        return scores;
    }
    
}
