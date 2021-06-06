package project.studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        // Ask how many new user we want to add
        System.out.print("Enter number of new students to enroll: ");
        Scanner scanner = new Scanner(System.in);
        int numOfStudent = scanner.nextInt();
        Student[] students = new Student[numOfStudent];

        // Create n number of new Student
        for(int i = 0; i < numOfStudent; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.println(students[i].toString());
        }

        for(int i = 0; i < numOfStudent; i++) {
            System.out.println(students[i].toString());
        }

    }
}
