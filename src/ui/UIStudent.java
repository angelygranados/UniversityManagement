package ui;

public class UIStudent {
    public static int studentMenu(){
        System.out.println();
        System.out.println("::Students");
        System.out.println("Please select an option");
        System.out.println("1. Register a new student");
        System.out.println("2. List all the students");
        System.out.println("3. View the courses of a student");
        System.out.println("0. Return");
        return UIMenu.scanInt();
    }
    public static int enrollStudent(String name){
        System.out.println("Do you want to enroll "+ name +" in a course?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int response;
        do {
            response = UIMenu.scanInt();
            if(response == 1 || response == 2){
                return response;
            } else {
                System.out.println("Plese select a correct option");
            }
        } while (response != 1 || response != 2);
        return response;
    }
}
