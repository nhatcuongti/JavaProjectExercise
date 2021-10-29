package com.company;

import java.io.*;
import java.util.ArrayList;
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

    /**
     * Add new student to list
     */
    public void addStudent(){
        Student stNew = new Student();
        stNew.setInforStudent();
        dataStudent.add(stNew);
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
}
