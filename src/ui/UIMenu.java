package ui;

import java.util.Scanner;

public class UIMenu {
    public static int showMenu(){
        System.out.println();
        System.out.println("::Main Menu");
        System.out.println("Please select an option");
        System.out.println("1. Teachers");
        System.out.println("2. Students");
        System.out.println("3. Courses");
        System.out.println("0. Exit");
        System.out.println();
        return UIMenu.scanInt();
    }
    public static int scanInt (){
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        return value;
    }
    public static String scanString(){
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        return value;
    }
    public static void defaultString(){
        System.out.println("------------------------------");
        System.out.println("Please select a correct answer");
        System.out.println("------------------------------");
    }

}
