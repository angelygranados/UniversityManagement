package Data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // Teachers Methods
    public List<Teacher> getTeachers() {
        return teachers;
    }
    public void addNewTeacher(String name, String email, int experience_hours, String type){
        if(type.equals("fullTime")){
            this.teachers.add(new FullTimeTeacher(name, email, experience_hours));
        } else {
            this.teachers.add(new PartTimeTeacher(name, email, experience_hours));
        }
    }
    public void addCourseToTeacher(int teacherId, int courseId){
        Teacher foundTeacher = findTeacher(teacherId);
        foundTeacher.addTeacherCourses(courseId);
    }
    public List<Course> getTeacherCourses(int teacherId){
        List<Course> teacherCourses = new ArrayList<>();
        for (Integer courseId: findTeacher(teacherId).getTeacherCourses()) {
            teacherCourses.add(findCourse(courseId));
        }
        return teacherCourses;
    }
    // Students Methods
    public List<Student> getStudents() {
        return students;
    }
    public int addNewStudent(String name, String email, int age){
        Student newStudent = new Student(name, email, age);
        this.students.add(newStudent);
        return newStudent.getId();
    }
    public List<Course> getStudentCourses(int studentId){
        List<Course> studentCourses = new ArrayList<>();
        for (Integer courseId: findStudent(studentId).getStudentCourses()) {
            studentCourses.add(findCourse(courseId));
        }
        return studentCourses;
    }
    public void addStudentToCourse(int studentId, int courseId){
        Course courseFunded = findCourse(courseId);
        courseFunded.addCourseStudent(studentId);
        findStudent(studentId).addStudentCourses(courseId);
    }
    // Courses Methods
    public List<Course> getCourses() {
        return courses;
    }
    public void addNewCourse(String name, int teacherId){
        Course newCourse = new Course(name, teacherId);
        this.courses.add(newCourse);
        addCourseToTeacher(teacherId, newCourse.getId());
    }






    // Utils
    public Teacher findTeacher(int teacherId){
        return this.teachers.stream().filter(teacher -> teacherId == teacher.getId()).findAny().orElse(null);
    }
    private Course findCourse(int courseId){
        return this.courses.stream().filter(course -> courseId == course.getId()).findAny().orElse(null);
    }
    public Student findStudent(int studentId){
        return this.students.stream().filter(student -> studentId == student.getId()).findAny().orElse(null);
    }
}
