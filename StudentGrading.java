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
        ArrayList<Student> students = new ArrayList<Student>(); // Listado de estudiante
        ArrayList<String> campuslist = new ArrayList<String>(); // listado de campus
        ArrayList<String> courses = new ArrayList<String>(); // listado de cursos
        courses.add("Matemáticas");// añadir nombres de cursos
        courses.add("Lenguaje");
        courses.add("Química");
        courses.add("Física");
        courses.add("Comprensión lectora");
        courses.add("Estadística");
        Scanner s = new Scanner(System.in);
        boolean menu = true;
        while (menu) {// menú del programa
            System.out.println("Bienvenido, elija una opción:\n1) Ingresar campus\n2) Ingresar datos de estudiante\n3) Ingresar nota de un estudiante\n4) Datos estadísticos\n5) Salir");
            switch (s.nextInt()) {
                case 1:
                System.out.println("Ingrese el nombre del campus: ");
                s.nextLine();
                campuslist.add(s.nextLine());// añade campus a la lista
                break;
                case 2:
                System.out.println("Ingrese el nombre del estudiante:");// solicita la información del estudiante
                String name = s.nextLine();
                s.nextLine();
                System.out.println("Ingrese el apellido del estudiante:");
                String lastname = s.nextLine();
                System.out.println("Ingrese el codigo de identificación del estudiante:");
                boolean cc = true;
                int id = 0;
                while (cc){// verifica que el código sea único
                    cc = false;
                    id = s.nextInt();
                    for (Student st : students) {
                        if (st.getId() == id){
                            cc = true;
                        }
                    }
                }
                s.nextLine();
                System.out.println("Ingrese la fecha de nacimiento del estudiante:");// Añade la fecha preguntando paso a paso
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
                    System.out.println("Ingrese primero un campus");// Verifica que haya campus dentro del programa
                    break;
                }
                if (students.size() == 0) {
                    System.out.println("Ingrese primero un estudiante:");// verifica que haya estudiantes
                    break;
                }
                System.out.println("Ingrese el codigo del estudiante:");
                int gid = s.nextInt();
                Student gst = new Student("", "", 0, "", "");
                boolean exist = false;
                for (Student st : students) {// Verificar estudiante ingresado
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
                System.out.println("Ingrese el número del curso del exámen:");
                String course; c = 0;
                for (String x : courses){
                    System.out.println((c+1) + ". " + x);
                    c++;
                }
                do {
                    c = s.nextInt();
                } while (c < 1 || c > courses.size());
                course = courses.get(c - 1);
                System.out.println("Ingrese la puntuación obtenida:");
                int score;
                do {// Verificar puntuación entre 0 y 100
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
                        ArrayList<Integer> lst = new ArrayList<Integer>();// Lista de notas de todos los estudiantes para el curso
                        float avg = 0;
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
                        if (lst.size() == 0){
                            System.out.println("Sin notas");// salir si no hay notas en este curso
                            continue;
                        }
                        Collections.sort(lst);// Ordenar lista de mayor a menor
                        System.out.println("Promedio: " + (avg/sz));// promedio calculando suma de todo dividido numero total
                        int max = 0; int tmax = 0; float mode = lst.get(0); boolean mdn = true;
                        for (int i = 0; i < lst.size(); i++) {// Calcular moda
                            if (i < lst.size() - 1){
                            if (lst.get(i) == lst.get(i+1)) {
                                tmax ++;
                                if (i == lst.size() - 2) {
                                    if (tmax +1 > max){
                                    mode = lst.get(i);
                                    max = tmax + 1;
                                }
                                }
                            }
                            else {
                                if (tmax +1 > max){
                                    mode = lst.get(i);
                                    max = tmax + 1;
                                }
                                tmax = 0;
                            }}
                            if ((i+1)*2 >= lst.size() && mdn) {// Imprimir mediana verficando que es la de en medio
                                if ((i+1)*2 == lst.size()) {
                                    System.out.println("Mediana: " + (float) ((lst.get(i) + lst.get(i + 1)) / 2));
                                }
                                else {
                                    System.out.println("Mediana: " + lst.get(i));
                                }
                                mdn = false;
                            }
                        }
                        System.out.println("Moda (excluyente): " + (mode));
                        for (float gr : lst){// Calcular varianza
                            stddev += (gr - (avg/sz)) * (gr - (avg/sz));
                        }
                        if (sz > 1) {
                            System.out.println("Desviación estándar: " + Math.sqrt(stddev / (sz - 1)));// Mostrar desviación estándar
                        }
                        else {
                            System.out.println("Desviación estándar: 0");
                        }

                    }
                }
                break;
                case 5:
                menu = false;// salir
                break;
                default:
                System.out.println("Ingrese una opción correcta");
                break;
            }
        }
        s.close();
    }    
}
