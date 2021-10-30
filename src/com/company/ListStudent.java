package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListStudent {
    private ArrayList<Student> dataStudent;

    /**
     * Constructor with parameter
     * @param dataStudent
     */
    public ListStudent(ArrayList<Student> dataStudent) {
        this.dataStudent = dataStudent;
    }

    /**
     * Default constructor
     */
    public ListStudent(){
        dataStudent = new ArrayList<Student>();
    }

    public boolean isNewDataValid(Student newStudent){
        boolean isValid = true;
        // Check Identical ID
        for (int i = 0; i < dataStudent.size(); i++)
            if (dataStudent.get(i).getID().equals(newStudent.getID()))
                isValid = false;

        if (!isValid)
            System.out.println("New student's ID (" + newStudent.getID() + ") is not unique !!");

        //Check range of GPA
        if (newStudent.getGPA() > 4 || newStudent.getGPA() < 0)
        {
            isValid = false;
            System.out.println("New student's GPA (" + newStudent.getGPA() + ") is out of range (0 -> 4)");
        }

        return isValid;
    }

    public static void clearScreen(){
        for (int i =0; i < 100; i++)
            System.out.println();
    }


    /**
     * Add new student to list
     */
    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        Student stNew = new Student();
        stNew.setInforStudent();

        if (isNewDataValid(stNew)) {
            dataStudent.add(stNew);
            System.out.println("Successfully add student !!");
        }
        else{
            System.out.println("Your student data is not valid !!");
            System.out.println("1. Refill your data  2. Go back");
            System.out.print("Choose your option : ");
            String option = sc.nextLine();

            int choiceNumber;

            try {
                choiceNumber = Integer.valueOf(option).intValue();
            } catch (NumberFormatException e) {
                choiceNumber = 0;
            }

            clearScreen();

            if (choiceNumber == 2)
                return;
            else if (0 == choiceNumber)
                System.out.println("Your option is invalid ! Try again");


        }
    }

    /**
     * View all student on list
     */
    public void viewStudent(){
        for (int i = 0; i < dataStudent.size(); i++)
            dataStudent.get(i).showInforStudent();
    }

    public int getOrderOneStudent(String ID){
        for (int i = 0; i < dataStudent.size(); i++)
            if (dataStudent.get(i).getID().equals(ID))
                return i;

        return -1;
    }

    /**
     * Delete one student on list
     */
    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        viewStudent();
        System.out.print("Press ID student you want to remove : ");
        String idDel = sc.nextLine();

        int orderNumber = getOrderOneStudent(idDel);

        dataStudent.remove(orderNumber);
    }

    /**
     * Write data student to file TXT
     * @param fileName
     * @throws IOException
     */
    public void writeStudentToFileTXT(String fileName) throws IOException {
        PrintStream ps = new PrintStream(fileName);
        for (int i = 0; i < dataStudent.size(); i++)
            dataStudent.get(i).writeInforToFileTxt(ps);

        ps.close();
    }

    /**
     * Write student to file CSV
     * @param fileName
     * @throws FileNotFoundException
     */
    public void writeStudentToFileCSV(String fileName) throws FileNotFoundException {
        PrintStream ps = new PrintStream(fileName);
        ps.println("ID,Name,GPA,image,address,notes");
        for (int i = 0; i < dataStudent.size(); i++)
            ps.println(dataStudent.get(i).convertToCSVString());
        ps.close();
    }

    /**
     * Import student from file txt
     * @param fileName
     * @throws IOException
     */
    public void importStudentFromFileTXT(String fileName) throws IOException {
        dataStudent.clear();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (true){
            String id = br.readLine();
            if (null == id)
                break;

            String name = br.readLine();
            double gpa = Double.valueOf(br.readLine()).doubleValue();
            String image = br.readLine();
            String address = br.readLine();
            String Notes = br.readLine();
            br.readLine();

           Student newStudent = new Student(id, name, image, address, Notes, gpa);

           dataStudent.add(newStudent);
        }
        br.close();
    }

    /**
     * Add new student to file
     * @param fileName
     * @throws IOException
     */
    public void importStudentFromFileCSV(String fileName) throws IOException {
        dataStudent.clear();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine();
        while (true){
            String csvStr = br.readLine();
            if (csvStr == null)
                break;

            Student newStudent = new Student(csvStr);

            dataStudent.add(newStudent);
        }
        br.close();
    }

    /**
     * Sort student by ascending ID
     */

    public void sortByAscendingID() {
        Collections.sort(dataStudent, new compareAscendingID());
    }

    public void sortByAscendingGPA() {
        Collections.sort(dataStudent, new compareAscendingGPA());
    }

    /**
     * Check the valid data of updated
     * @param order
     * @return
     */
    boolean isUpdatedDataValid(int order){
        boolean isValid = true;
        for (int i = 0; i < dataStudent.size(); i++)
            if (i != order && dataStudent.get(i).getID().equals(dataStudent.get(order).getID())){
               isValid = false;
                System.out.println("Updated Student's ID (" + dataStudent.get(order).getID() + ") is not unique");
               break;
            }

        if (dataStudent.get(order).getGPA() > 4.0 || dataStudent.get(order).getGPA() < 0){
            isValid = false;
            System.out.println("Updated student's GPA (" + dataStudent.get(order).getGPA() +
                    " is out of range (0 -> 4)");
        }

        return isValid;
    }

    /**
     * Update student
     */
    public void updateStudent() {
        Scanner sc = new Scanner(System.in);

        String idUpdate = null;

        System.out.println("There are list of student : ");
        viewStudent();
        System.out.print("Press Student's ID who you want to update : ");
        idUpdate = sc.nextLine();

        int order = getOrderOneStudent(idUpdate);
        clearScreen();
        if (order == -1)
            System.out.println("ID You press (" + idUpdate + ") is not valid");
        else {
            boolean isSuccess = dataStudent.get(order).updateInforStudent();
            if (!isUpdatedDataValid(order)) {
                System.out.println("Updated data is not valid !! ");
            }
            else if (isSuccess)
                System.out.println("Successfully update data");
        }


    }
}

class compareAscendingID implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        int IDo1 = Integer.valueOf(o1.getID()).intValue();
        int IDo2 = Integer.valueOf(o2.getID()).intValue();

        if (IDo1 > IDo2)
            return 1;
        else if (IDo1 == IDo2)
            return 0;
        else
            return -1;
    }
}

class compareAscendingGPA implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        Double GPAo1 = o1.getGPA();
        Double GPAo2 = o2.getGPA();
        if (GPAo1 > GPAo2)
            return 1;
        else if (GPAo1 == GPAo2)
            return 0;
        else
            return -1;
    }
}
