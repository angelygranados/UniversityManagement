package ui;

public class UITeacher {
    public static String typeTeacher(){
        String typeSelectedString = null;
        System.out.println("Type of teacher: ");
        System.out.println("1. Full time");
        System.out.println("2. Part time");
        do{
            int selectedType = UIMenu.scanInt();
            if(selectedType == 1){
                typeSelectedString = "fullTime";
            } else if (selectedType == 2){
                typeSelectedString = "partTime";
            } else {
                System.out.println("Select a correct option");
            }
        } while (typeSelectedString == null);
        return typeSelectedString;
    }
    public static int teachersMenu(){
        System.out.println();
        System.out.println("::Teachers");
        System.out.println("Please select an option");
        System.out.println("1. Register a new teacher");
        System.out.println("2. List all the teachers");
        System.out.println("0. Return");
        return UIMenu.scanInt();
    }
}
