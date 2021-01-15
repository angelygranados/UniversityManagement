package Data;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private int age;
    private List<Integer> studentCourses = new ArrayList<Integer>();

    public Student(String name, String email, int age) {
        super(name, email);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addStudentCourses(Integer courseId){
        this.studentCourses.add(courseId);
    }

    public List<Integer> getStudentCourses() {
        return this.studentCourses;
    }

    public void setStudentCourses(List<Integer> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @Override
    public String toString() {
        return "| Name: " + this.getName() + " | Email: " + this.getEmail() + " | Age: " + this.getAge() + " |";
    }
}
