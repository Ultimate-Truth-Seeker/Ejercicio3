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
    /**getter
     * @return nombre
     */
    public String getName() {
        return name;
    }
    /**getter lastname
     * @return apellido
     */
    public String getLastname() {
        return lastname;
    }
    /**getter codigo
     * @return id
     */
    public int getId() {
        return id;
    }
    /** getter birthdate
     * @return birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }
    /** getter correo
     * @return correo
     */
    public String getEmail() {
        return email;
    }
    /**getter notas
     * @return notas
     */
    public ArrayList<Grade> getGrades() {
        return grades;
    }
    /**añade una nota al listado de notas del estudiante
     * @param grade la nota a añadir
     */
    public void addGrade(Grade grade) {
        grades.add(grade);
    }
    /** método que retorna las notas del estudiante en cierto lugar y curso
     * @param campus
     * @param course
     * @return las notas obtenidas en el campus y curso especificados
     */
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
