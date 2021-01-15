package Test;

import Data.*;
import ui.UICourse;
import ui.UIMenu;
import ui.UIStudent;
import ui.UITeacher;

public class Main {

    private static University university;

    public static void main(String[] args) {
        university = Initializer.initializeUniversity();

        int selected;
        System.out.println("Welcome to Globant University");
        do {
            selected = UIMenu.showMenu();
            switch (selected){
                case 1:
                    teacherMenu();
                    break;
                case 2:
                    studentMenu();
                    break;
                case 3:
                    coursesMenu();
                    break;
                case 0:
                    System.out.println("-----------------------");
                    System.out.println("Thank you for you visit");
                    System.out.println("-----------------------");
                    break;
                default:
                    UIMenu.defaultString();

            }
        } while (selected !=0 );

    }
    private static void coursesMenu(){
        int response;
        do {
            response = UICourse.courseMenu();
            switch (response){
                case 1:
                    int confirmation;
                    String courseName;
                    do {
                        System.out.println();
                        System.out.println("::: Create a new course");
                        System.out.println("Course name");
                        courseName = UIMenu.scanString();
                        System.out.println("Select a teacher");
                        university.getTeachers().stream().forEach(teacher -> System.out.println(teacher.getId() + ". " + teacher.getName()));
                        int selectedTeacher = UIMenu.scanInt();
                        int existTeacher = university.getTeachers().stream().filter(teacher -> teacher.getId() == selectedTeacher ).findAny().orElse(null).getId();
                        if(existTeacher == selectedTeacher){
                            university.addNewCourse(courseName, selectedTeacher);
                            System.out.println();
                            System.out.println("Course created!");
                            confirmation = 1;
                        } else {
                            System.out.println("You need to choose a teacher from the list.");
                            return;
                        }
                    } while(confirmation != 1);
                    break;
                case 2:

                    int exit = 1;
                    do {
                        System.out.println();
                        System.out.println("----------------------");
                        System.out.println("::: List of courses: ");
                        System.out.println("----------------------");
                        System.out.println();
                        university.getCourses().stream().forEach(course -> System.out.println(course.toString()));
                        System.out.println();
                        System.out.println("If you wanna view the details of a course, please enter its number");
                        System.out.println("0. Exit");
                        int selectedCourse = UIMenu.scanInt();
                        if(selectedCourse != 0){
                            Course courseFinded = university.getCourses().stream().filter(course -> course.getId() == selectedCourse).findAny().orElse(null);
                            if(courseFinded != null){
                                System.out.println();
                                String teacherName = university.getTeachers().stream().filter(teacher -> teacher.getId() == courseFinded.getTeacherId()).findAny().orElse(null).getName();
                                System.out.println(courseFinded.toString() + "Teacher: "+ teacherName);
                                System.out.println(" Students: ");
                                for (Integer studentId: courseFinded.getCourseStudents()) {
                                    System.out.println("  | "+ university.findStudent(studentId).getName());
                                }
                            } else {
                                System.out.println();
                                System.out.println("Please enter a valid course from the list.");
                                System.out.println();
                            }
                        } else {
                            exit = 0;
                        }
                    } while (exit != 0);

                    break;
                default:
                    UIMenu.defaultString();
            }
        } while (response != 0);
    }
    private static void studentMenu(){
        int response;
        do {
            response = UIStudent.studentMenu();
            switch (response){
                case 1:
                    int confirmation = 0;
                    String name;
                    String email;
                    int age;
                    do{
                        System.out.println();
                        System.out.println("::: Register new student");
                        System.out.println("Name:");
                        name = UIMenu.scanString();
                        System.out.println("Email: ");
                        email = UIMenu.scanString();
                        System.out.println("Age: ");
                        age = UIMenu.scanInt();
                        System.out.println("The data of the new student is: ");
                        System.out.println("Name: " + name + " Email: " + email + " Age: " + age);
                        System.out.println();
                        System.out.println("1. Correct");
                        System.out.println("2. Incorrect");
                        confirmation = UIMenu.scanInt();
                    } while(confirmation != 1);
                    int newStudentId = university.addNewStudent(name, email, age);
                    System.out.println();
                    System.out.println("Student created!");
                    System.out.println();
                    int enroll = UIStudent.enrollStudent(name);
                    if(enroll == 1){
                        boolean confirmEnroll = false;
                        do {
                            System.out.println("Select a course: ");
                            university.getCourses().stream().forEach(course -> System.out.println(course.toString() + university.findTeacher(course.getTeacherId()).getName()));
                            int selectedCouse = UIMenu.scanInt();
                            int existCourse = university.getCourses().stream().filter(course -> course.getId() == selectedCouse ).findAny().orElse(null).getId();
                            if(existCourse == selectedCouse){
                                university.addStudentToCourse(newStudentId, selectedCouse);
                                System.out.println();
                                System.out.println("Student enrolled!");
                                confirmEnroll = true;
                            } else {
                                return;
                            }
                        } while(!confirmEnroll);
                    }
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.println("::: List of students: ");
                    System.out.println("----------------------");
                    university.getStudents().stream().forEach(student -> System.out.println(student.toString()));
                    break;
                case 3:
                    int exit = 1;
                    do{
                        System.out.println("Select a student to list his courses");
                        university.getStudents().forEach(student -> System.out.println(student.getId() + ". " + student.getName()));
                        int selectedStudent = UIMenu.scanInt();
                        Student student = university.getStudents().stream().filter(st -> st.getId() == selectedStudent ).findAny().orElse(null);
                        int existsStudent = student.getId();
                        if(existsStudent == selectedStudent){
                            System.out.println();
                            System.out.println(student.getName() + "'s courses");
                            university.getStudentCourses(selectedStudent).stream().forEach(course -> System.out.println(course.toString()));
                            System.out.println();
                            System.out.println("Do you want to view another student?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            if(UIMenu.scanInt() == 2){
                                exit = 0;
                            }
                        }
                    } while (exit != 0);

                    break;
                case 0:
                    return;
                default:
                    UIMenu.defaultString();
            }


        } while (response != 0);
    }
    private static void teacherMenu(){
        int response;
        do {
            response = UITeacher.teachersMenu();
            switch (response){
                case 1:
                    int confirmation = 0;
                    String name;
                    String email;
                    String type;
                    int experience_hours;
                    do{
                        System.out.println();
                        System.out.println("::: Register new teacher");
                        System.out.println("Name:");
                        name = UIMenu.scanString();
                        System.out.println("Email: ");
                        email = UIMenu.scanString();
                        type = UITeacher.typeTeacher();
                        if(type == "fullTime"){
                            System.out.println("Years of experience: ");
                            experience_hours = UIMenu.scanInt();
                        } else {
                            System.out.println("Weekly hours: ");
                            experience_hours = UIMenu.scanInt();
                        }
                        System.out.println("The data of the new teacher is: ");
                        System.out.println("Name: " + name + " Email: " + email + " Type: " + type + " Experience/Hours: " + experience_hours);
                        System.out.println();
                        System.out.println("1. Correct");
                        System.out.println("2. Incorrect");
                        confirmation = UIMenu.scanInt();
                    } while(confirmation != 1);
                    university.addNewTeacher(name, email, experience_hours, type);
                    System.out.println();
                    System.out.println("Teacher created!");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.println("::: List of teachers: ");
                    System.out.println("----------------------");
                    university.getTeachers().stream().forEach(teacher -> System.out.println(teacher.toString()));
                    break;
                case 0:
                    return;
                default:
                    UIMenu.defaultString();
            }
        } while (response != 0);
    }
}