package Ejercicio3;
/**
 * Clase que define nota
 * @author Ultimate-Truth-Seeker
 * @version 03/09/2023
 */
public class Grade {
    private String campus;
    private String course;
    private int score;
    /**
     * Constructor de la clase
     * @param campus
     * @param course
     * @param score
     */
    public Grade(String campus, String course, int score) {
        this.campus = campus;
        this.course = course;
        this.score = score;
    }
    
    /**
     * getter de campus
     * @return campus
     */
    public String getCampus() {
        return campus;
    }
    /**
     * getter de curso
     * @return curso
     */
    public String getCourse() {
        return course;
    }
    /** getter de nota
     * @return
     */
    public int getScore() {
        return score;
    }
    
}
