package project.studentdatabaseapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = scanner.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level:");
        this.gradeYear = scanner.nextInt();

        setStudentID();
    }

    // Generate an id
    public void setStudentID() {
        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }


    // Enroll in courses
    public void enroll() {
        // Get inside loop, user hits 0
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                courses += "\n " + course;
                tuitionBalance += costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        Scanner scanner = new Scanner(System.in);
        viewBalance();
        System.out.print("Enter your payment: $");
        int payment = scanner.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status
    public String toString() {
        return "Name: " + firstName + " " +lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
