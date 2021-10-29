package com.company;

import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {
	// write your code here
        ListStudent stList = new ListStudent();
        stList.importStudentFromFileCSV("input.csv");
        stList.viewStudent();


    }
}
