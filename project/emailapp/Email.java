package project.emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private static final int DEFAULT_PASSWORD_LENGTH = 10;
    private String alternateEmail;
    private static final String COMPANY_SUFFIX = "anxcompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATE: " + this.firstName + " " + this.lastName);

        // Call a method asking for department - return the department
        this.department = setDepartment();
        System.out.println("Yore department is: " + this.department);

        // Call a method that returns random password
        this.password = randomPassword(DEFAULT_PASSWORD_LENGTH);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + COMPANY_SUFFIX;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "";
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Set alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
