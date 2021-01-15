package Data;

import java.util.ArrayList;
import java.util.List;

public abstract class Teacher extends Person{
    private double baseSalary = 20000.0;
    private List<Integer> teacherCourses = new ArrayList<Integer>();

    public Teacher(String name, String email) {
        super(name, email);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void addTeacherCourses(Integer courseId){
        this.teacherCourses.add(courseId);
    }
    public List<Integer> getTeacherCourses(){
        return this.teacherCourses;
    }

    public abstract double getSalary();
    public abstract String toString();
}
