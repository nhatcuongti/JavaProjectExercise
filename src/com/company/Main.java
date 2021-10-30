package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static ListStudent myListStudent;


    /**
     * UI about load/write student from file
     */
    public static void loadwriteStudentUI(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Load/Write Student from file Features");
            System.out.println();
            System.out.println("There are some option : ");
            System.out.println("--------------------------------------");
            System.out.println("1. Load Student from file (.txt, .csv)");
            System.out.println("2. Write Student to file (.txt, .csv)");
            System.out.println("3. Go Back");
            System.out.println("4. Go to main menu");
            System.out.println("--------------------------------------");

            System.out.print("Press your option :");
            String strPressed = sc.nextLine();
            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            System.out.println(choiceNumber);

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    loadStudentUI();
                    break;
                case 2:
                    writeStudentUI();
                    break;
                case 3:
                    return;
                case 4:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }

    }

    public static void loadStudentUI(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Load Student From File Features");
            System.out.println("There are some option : ");
            System.out.println("-----------------------------");
            System.out.println("1. Load Student from file TXT");
            System.out.println("2. Load Student from file CSV");
            System.out.println("3. Go Back");
            System.out.println("4. Go to menu");
            System.out.println("-----------------------------");

            System.out.print("Press your option :");
            String strPressed = sc.nextLine();
            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    loadStudentFromTxtUI();
                    break;
                case 2:
                    loadStudentFromCSVUI();
                    break;
                case 3:
                    return;
                case 4:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }
    }


    private static void loadStudentFromCSVUI() {
        Scanner sc = new Scanner(System.in);
        String fileNameTXT = "file/input.csv";

        try {
            myListStudent.importStudentFromFileCSV(fileNameTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Load Student From File CSV");
            System.out.println("---------------------------------------");
            System.out.println("Successfully load student from file CSV");
            System.out.println("Location : file/input.csv");
            System.out.println("You can go to view to see data student");
            System.out.println("---------------------------------------");
            System.out.println("1. Go Back  2. Go to menu  3. View Student");
            System.out.println("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    return;
                case 2:
                    mainMenu();
                    break;
                case 3:
                    viewStudentUI();
                    return;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }
    }

    public static void loadStudentFromTxtUI(){
        Scanner sc = new Scanner(System.in);

        String fileNameTXT = "file/input.txt";

        try {
            myListStudent.importStudentFromFileTXT(fileNameTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
        System.out.println("Load Student From File TXT");
        System.out.println("---------------------------------------");
        System.out.println("Successfully load student from file txt");
        System.out.println("Location : file/input.txt");
        System.out.println("You can go to view to see data student");
        System.out.println("---------------------------------------");
            System.out.println("1. Go Back  2. Go to menu  3. View Student");
            System.out.println("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    return;
                case 2:
                    mainMenu();
                    break;
                case 3:
                    viewStudentUI();
                    return;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }
    }

    public static void writeStudentUI(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Write Student to file Feature");
            System.out.println("There are some option : ");
            System.out.println("-----------------------------");
            System.out.println("1. Write Student to file TXT");
            System.out.println("2. Export Student to file CSV");
            System.out.println("3. Go Back");
            System.out.println("4. Go to menu");
            System.out.println("-----------------------------");

            System.out.print("Press your option :");
            String strPressed = sc.nextLine();
            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    writeStudentToFileTXT();
                    break;
                case 2:
                    writeStudentToFileCSV();
                    break;
                case 3:
                    return;
                case 4:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }

    }

    private static void writeStudentToFileTXT() {
        Scanner sc = new Scanner(System.in);

        String fileNameTXT = "file/output.txt";
        try {
            myListStudent.writeStudentToFileTXT(fileNameTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.println("Write Student to file TXT");
            System.out.println("--------------------------------------");
            System.out.println("Successfully write student to file TXT");
            System.out.println("File location : file/output.txt");
            System.out.println("--------------------------------------");

            System.out.println("1. Go Back  2. Go to menu ");
            System.out.println("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    return;
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }
    }



    private static void writeStudentToFileCSV(){
        Scanner sc = new Scanner(System.in);

        String fileNameTXT = "file/output.CSV";
        try {
            myListStudent.writeStudentToFileCSV(fileNameTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.println("Write Student to file TXT");
            System.out.println("--------------------------------------");
            System.out.println("Successfully write student to file TXT");
            System.out.println("File location : file/output.csv");
            System.out.println("--------------------------------------");

            System.out.println("1. Go Back  2. Go to menu ");
            System.out.println("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    return;
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }
        }
    }

    /**
     * View student UI
     */
    public static void viewStudentUI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("View Student features");

        System.out.println("There are list of student : ");
        while (true){
            System.out.println("----------------------------------------------");
            myListStudent.viewStudent();
            System.out.println("----------------------------------------------");

            System.out.println("There are some option to view student : ");
            System.out.println("----------------------");
            System.out.println("1. Ascending order ID");
            System.out.println("2. Ascending order GPA");
            System.out.println("3. Go Back");
            System.out.println("----------------------");

            System.out.println("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();
            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    myListStudent.sortByAscendingID();
                    return;
                case 2:
                    myListStudent.sortByAscendingGPA();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }

        }
    }

    /**
     * Function add student UI
     */
    public static void addStudentUI(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Add Student Feature");
            System.out.println("1. Continue  2. Return  3. Go to menu");
            System.out.print("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();

            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    break;
                case 2:
                    return;
                case 3:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;
            }

            myListStudent.addStudent();
        }

    }

    /**
     * Update Student
     */
    public static void updateStudentUI(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Update Student Feature");
            System.out.println("1. Continue  2. Return  3. Go to menu");
            System.out.print("Press your option : ");

            String strPressed = sc.nextLine();

            int choiceNumber;
            try {
                choiceNumber = Integer.valueOf(strPressed).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();

            switch (Integer.valueOf(choiceNumber).intValue()) {
                case 1:
                    break;
                case 2:
                    return;
                case 3:
                    mainMenu();
                    break;
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;
            }

            myListStudent.updateStudent();
        }

    }

    /**
     * Clear screen
     */
    public static void clearScreen(){
        for (int i =0; i < 100; i++)
            System.out.println();
    }

    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Student Managment Program");
            System.out.println("There are some option : ");
            System.out.println("--------------------------------------------");
            System.out.println("1. Load/Write Student from file (.csv, .txt)");
            System.out.println("2. View Student");
            System.out.println("3. Add Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------");

            System.out.print("Press your option :");
            String strPressed = sc.nextLine();
            int choiceNumber;
            try{
                choiceNumber = Integer.valueOf(strPressed).intValue();
            }catch (NumberFormatException e){
                choiceNumber = 0;
            }

            System.out.println(choiceNumber);

            clearScreen();
            switch(Integer.valueOf(choiceNumber).intValue()){
                case 1 :
                    loadwriteStudentUI();
                    break;
                case 2 :
                    viewStudentUI();
                    break;
                case 3 :
                    addStudentUI();
                    break;
                case 4 :
                    updateStudentUI();
                    break;
                case 5 :
                    System.exit(0);
                default:
                    System.out.println("The option you choose is not valid ! Try again");
                    break;

            }

        }
    }

    /**
     * Main function
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	// write your code here
        myListStudent = new ListStudent();
        mainMenu();

    }
}
