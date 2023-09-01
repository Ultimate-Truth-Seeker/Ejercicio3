package Ejercicio3;

public class Grade {
    private String campus;
    private String course;
    private int score;
    public Grade(String campus, String course, int score) {
        this.campus = campus;
        this.course = course;
        this.score = score;
    }
    public String getCampus() {
        return campus;
    }
    public String getCourse() {
        return course;
    }
    public int getScore() {
        return score;
    }
    
}
