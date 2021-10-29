package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Student {
    private String ID, Name, Image, Address, Notes;
    private double GPA;

    public static void cls(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    /**
     * Default Constructor
     */
    public Student(){

    }

    /**
     * Constructor with many parameter
     * @param ID
     * @param name
     * @param image
     * @param address
     * @param notes
     * @param GPA
     */
    public Student(String ID, String name, String image, String address, String notes, double GPA) {
        this.ID = ID;
        Name = name;
        Image = image;
        Address = address;
        Notes = notes;
        this.GPA = GPA;
    }

    public Student(String csvString){
        String[] strArray = csvString.split(",");
        ID = strArray[0];
        Name = strArray[1];
        GPA = Double.valueOf(strArray[2]).doubleValue();
        Image = strArray[3];
        Address = strArray[4];
        Notes = strArray[5];
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Press information from keyboard to data for student
     */
    public void setInforStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Fill Student's Information");
        System.out.print("1. ID : ");
        ID = sc.nextLine();

        System.out.print("2. Name : ");
        Name = sc.nextLine();

        System.out.print("3. GPA : ");
        GPA = sc.nextDouble();

        sc.nextLine();

        System.out.print("4. Image : ");
        Image = sc.nextLine();

        System.out.print("5. Address : ");
        Address = sc.nextLine();

        System.out.print("6. Notes : ");
        Notes = sc.nextLine();
    }

    /**
     * Print information of student to console
     */
    public void showInforStudent(){
        System.out.println("----------------------------");
        System.out.println("ID : " + ID);
        System.out.println("Name : " + Name);
        System.out.println("GPA : " + GPA);
        System.out.println("Image : " + Image);
        System.out.println("Address : " + Address);
        System.out.println("Notes : " + Notes);
        System.out.println("----------------------------");
    }

    /**
     * Update information for student
     */

    public void updateInforStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------");

        System.out.println("1. ID  2. Name  3. GPA  4. Image  5. Address  6. Notes");
        System.out.print("Choose one attributes you want to upload : ");
        String numberAttribute = sc.nextLine();
        int nb = Integer.valueOf(numberAttribute);
        switch (nb) {
            case 1:
                System.out.println("Old ID : " + ID);
                System.out.print("Press new ID : ");
                ID = sc.nextLine();
                break;
            case 2:
                System.out.println("Old Name : " + Name);
                System.out.print("Press new Name : ");
                Name = sc.nextLine();
                break;
            case 3:
                System.out.println("Old GPA : " + GPA);
                System.out.print("Press new GPA : ");
                GPA = sc.nextDouble();
                sc.nextLine();
                break;
            case 4:
                System.out.println("Old Image : " + Image);
                System.out.print("Press new Image : ");
                Image = sc.nextLine();
                break;
            case 5:
                System.out.println("Old Address : " + Address);
                System.out.print("Press new Address : ");
                Address = sc.nextLine();
                break;
            case 6:
                System.out.println("Old Notes : " + Notes);
                System.out.print("Press new Notes : ");
                Notes = sc.nextLine();
                break;
            default:
                System.out.println("Your number is not correct !");
                break;
        }

        System.out.println("--------------------------------------------------------");

    }

    /**
     * WRite data to file
     * @param ps
     * @throws IOException
     */

    public void writeInforToFileTxt(PrintStream ps) throws IOException {
            ps.println(ID);
            ps.println(Name);
            ps.println(GPA);
            ps.println(Image);
            ps.println(Address);
            ps.println(Notes);
    }

    /**
     * Convert information to CSV String
     * @return
     */
    public String convertToCSVString(){
        String str = ID + "," + Name + "," + String.valueOf(GPA) + "," + Image
                + "," + Address + "," + Notes;

        return str;
    }





}