package Data;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private static int classroomID = 10;
    private static int ID = 1;

    private int id;
    private String courseName;
    private int assignedClassroom;
    private int teacherId;
    private List<Integer> courseStudentsIds = new ArrayList<Integer>();

    public Course(String courseName, int teacherId) {
        this.courseName = courseName;
        this.teacherId = teacherId;
        assignedClassroom = classroomID;
        classroomID++;
        this.id = ID;
        ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignedClassroom(){
        return this.assignedClassroom;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Integer> getCourseStudents() {
        return courseStudentsIds;
    }

    public void addCourseStudent(Integer studentId) {
        courseStudentsIds.add(studentId);
    }

    public void removeCourseStudent(Integer studentId){
        courseStudentsIds.remove(studentId);
    }

    @Override
    public String toString() {
        return this.getId() + ". Course: " + this.getCourseName() + " Classroom: " + this.assignedClassroom + " ";
    }
}
