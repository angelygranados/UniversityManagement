package ui;

public class UICourse {
    public static int courseMenu(){
        System.out.println();
        System.out.println("::Courses");
        System.out.println("Please select an option");
        System.out.println("1. Create a new course");
        System.out.println("2. List all the courses");
        System.out.println("0. Return");
        return UIMenu.scanInt();
    }
}
