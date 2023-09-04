package Ejercicio3;
/**
 * Programa de manejo de notas
 * @author Ultimate-Truth-Seeker
 * @version 03/09/2023
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGrading {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<String> campuslist = new ArrayList<String>();
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Matemáticas");
        courses.add("Lenguaje");
        courses.add("Química");
        courses.add("Física");
        courses.add("Comprensión lectora");
        courses.add("Estadística");
        Scanner s = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido, elija una opción:\n1) Ingresar campus\n2) Ingresar datos de estudiante\n3) Ingresar nota de un estudiante\n 4) Datos estadísticos\n 5)Salir");
            switch (s.nextInt()) {
                case 1:
                System.out.println("Ingrese el nombre del campus: ");
                s.nextLine();
                campuslist.add(s.nextLine());
                break;
                case 2:
                System.out.println("Ingrese el nombre del estudiante:");
                String name = s.nextLine();
                System.out.println("Ingrese el apellido del estudiante:");
                String lastname = s.nextLine();
                System.out.println("Ingrese el codigo de identificación del estudiante:");
                boolean cc = true;
                int id = 0;
                while (cc){
                    cc = false;
                    id = s.nextInt();
                    for (Student st : students) {
                        if (st.getId() == id){
                            cc = true;
                        }
                    }
                }
                s.nextLine();
                System.out.println("Ingrese la fecha de nacimiento del estudiante:");
                System.out.println("Ingrese el día:");
                int dd = s.nextInt();
                System.out.println("Ingrese el mes:");
                int mm = s.nextInt();
                System.out.println("Ingrese el año:");
                int yy = s.nextInt();
                String birthdate = dd + "/"+ mm +"/" + yy;
                s.nextLine();
                System.out.println("Ingrese el correo electrónico del estudiante:");
                String email = s.nextLine();
                students.add(new Student(name, lastname, id, birthdate, email));
                break;
                case 3:
                if (campuslist.size() == 0) {
                    System.out.println("Ingrese primero un campus");
                    break;
                }
                if (students.size() == 0) {
                    System.out.println("Ingrese primero un estudiante:");
                    break;
                }
                System.out.println("Ingrese el codigo del estudiante:");
                int gid = s.nextInt();
                Student gst = new Student("", "", 0, "", "");
                boolean exist = false;
                for (Student st : students) {
                    if (st.getId() == gid) {
                        gst = st;
                        exist = true;
                        break;
                    }
                }
                if (exist == false){
                    System.out.println("El estudiante no ha sido encontrado");
                    break;
                }
                int c = 1;
                System.out.println("Ingrese el número del campus del examen:");
                for (String x : campuslist){
                    System.out.println(c + ". " + x);
                }
                do{
                    c = s.nextInt();
                } while (c < 1 || c > campuslist.size());
                String campus = campuslist.get(c-1);
                s.nextLine();
                System.out.println("Ingrese el nombre del curso del exámen:");
                String course;
                for (String x : courses){
                    System.out.println(x);
                }
                while (true) {
                    course = s.nextLine();
                    boolean cond = false;
                    for (String x: courses){
                        if (x == course){
                            cond =true;
                        }
                    }
                    if (cond){
                        break;
                    }
                }
                System.out.println("Ingrese la puntuación obtenida:");
                int score;
                do {
                    score = s.nextInt();
                } while (score < 0 || score > 100);
                Grade grade = new Grade(campus, course, score);
                gst.addGrade(grade);
                break;
                case 4:
                System.out.println("Datos estadísticos por campus:");
                for (String cmps : campuslist) {
                    System.out.println("Datos estadísticos para " + cmps + ":");
                    for (String crs : courses) {
                        System.out.println(crs + ":");
                        ArrayList<Integer> lst = new ArrayList<Integer>();
                        int avg = 0;
                        int sz = 0;
                        float stddev = 0;
                        for (Student st : students){
                            ArrayList<Integer> grds = st.getGradeGroup(cmps, crs);
                            for (int gr : grds) {
                                avg += gr;
                                sz ++;
                                lst.add(gr);
                            }
                        }
                        Collections.sort(lst);
                        System.out.println("Promedio: " + (avg/sz));
                        int max = 0; int tmax = 0; int mode = 0; boolean mdn = true;
                        for (int i = 1; i < lst.size(); i++) {
                            if (lst.get(i) == lst.get(i-1)) {
                                tmax ++;
                                if (i == lst.size() - 1) {
                                    if (tmax +1 > max){
                                    mode = lst.get(i-1);
                                    max = tmax + 1;
                                }
                                }
                            }
                            else {
                                if (tmax +1 > max){
                                    mode = lst.get(i-1);
                                    max = tmax + 1;
                                }
                                tmax = 0;
                            }
                            if ((i+1)*2 >= lst.size() && mdn) {
                                if ((i+1)*2 == lst.size()) {
                                    System.out.println("Mediana: " + ((lst.get(i) + lst.get(i+1)) / 2));
                                }
                                else {
                                    System.out.println("Mediana: " + lst.get(i));
                                }
                                mdn = false;
                            }
                        }
                        System.out.println("Moda: " + (mode));
                        for (int gr : lst){
                            stddev += (gr - (avg/sz)) * (gr - (avg/sz));
                        }
                        System.out.println("Desviación estándar: " + (stddev / (sz - 1)));

                    }
                }
                break;
                case 5:
                menu = false;
                break;
                default:
                System.out.println("Ingrese una opción correcta");
                break;
            }
        }
        s.close();
    }    
}
