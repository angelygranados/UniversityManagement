package Test;

import Data.University;

public class Initializer {
    static public University university;

    public static University getUniversityInstance() {
        if (university == null){
            university = new University();//instance will be created at request time
        }
        return university;
    }

    public static University initializeUniversity(){
        university = getUniversityInstance();
        initializeTeachers();
        initializeStudents();
        initializeCourses();
        return university;
    }

    private static void initializeTeachers(){
        university.addNewTeacher("Osmandi Gómez", "osmandi@mail.com", 5, "fullTime");
        university.addNewTeacher("Anahí Salgado", "anahi@mail.com", 30, "partTime");
    }
    private static void initializeStudents(){
        university.addNewStudent("Maria Perez", "maria@mail.com", 15);
        university.addNewStudent("Pablo Ramirez", "pablo@mail.com", 17);
        university.addNewStudent("Lisette Moncada", "lisette@mail.com", 18);
        university.addNewStudent("Brenda Caceres", "brenda@mail.com", 13);
        university.addNewStudent("Javier Fonseca", "javier@mail.com", 16);
        university.addNewStudent("Mariana Lizarazo", "mariana@mail.com", 15);
        university.addNewStudent("Francis Rojas", "francis@mail.com", 18);
        university.addNewStudent("Fernando Contreras", "fernando@mail.com", 13);
    }
    private static void initializeCourses(){
        university.addNewCourse("Francés", 2);
        university.addNewCourse("Alemán", 1);
        university.addNewCourse("Chino", 1);
        university.addNewCourse("Ruso", 2);
        addStudentsToCourse();
    }
    private static void addStudentsToCourse(){
        final int[] sortedStudent = {0};
        university.getCourses().stream().forEach(course -> {
            for (int i = sortedStudent[0]; i < university.getStudents().size() ; i++) {

                university.addStudentToCourse(university.getStudents().get(i).getId(), course.getId());
            }
            sortedStudent[0]++;
        });
    }
}
