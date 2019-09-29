/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import static enrollmentsystem.Choice.transaction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnrollMentSystem {

    static int counter = 0;
    static int infoCount = 0;
    static int courCount = 0;

    public static void main(String[] args) throws IOException {
//instantiates here
        File file
                = new File(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt", true)),
                        new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt", true)),
                        new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC"
                                        + "\\Desktop\\Courses.txt", true)));
        counter = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt")));
        courCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Courses.txt")));
        infoCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt")));
        file.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt")));
        Array.setInfoList(file.getList());  
        file.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt")));
        Array.setAccList(file.getList());
        file.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Courses.txt")));
        Array.setCourseList(file.getList());
//scanner        
        Scanner write = new Scanner(System.in);

//instantiating account,course,name classes
        Account acc = new Account();
        Course course = new Course();
        Name name = new Name();
        boolean end = true;
        while (end) {
            Choice.transaction();
            int transactionChoice = Choice.ans(write);
            if (transactionChoice == 0) {
                continue;
            }
            switch (transactionChoice) {
                case 1:
                    boolean endRetrieve = true;
                    while (endRetrieve) {
                        transaction("retrieve");
                        int choiceRetrieve = Choice.ans(write);
                        if (transactionChoice == 0) {
                            continue;
                        }
                        switch (choiceRetrieve) {
                            case 1:
                                System.out.println("display All");
                                System.out.println("display Accounts");
                                Array.displayAccList();
                                System.out.println("display Personal Information");
//                                Array.displayInfoList();
                                System.out.println("display Personal Course");
//                                Array.displayCourseList();
                                break;

                            case 2:
                                System.out.println("display Accounts");
                                Array.displayAccList();
                                break;
                            case 3:
                                System.out.println("display Personal Information");
                                Array.displayInfoList();
                                break;
                            case 4:
                                System.out.println("display Personal Course");
                                Array.displayCourseList();
                                break;                       
                            default:
                                System.out.println("idiot!!! only choose from the given!!");
                                break;
                        }
                        endRetrieve = Choice.endChoice(write, "retrieve");
                        System.out.println(endRetrieve);
                    }
                    break;
//adding info in files
                case 2:
                    boolean endAdd = true;
                    while (endAdd) {
                        //level one
                        file.setAccFile(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt", true)));
                        String user = "";
                        String password = "";
                        String verify = "";
                        System.out.println("enter username please");
                        user = write.next();
                        System.out.println("enter a password please");
                        password = write.next();
                        System.out.println("verify your password");
                        verify = write.next();
                        try {
                            if (ExceptionHandler.level_One(user, password, verify)) {
                                counter++;
                                file.sendAccount(counter, user, password);
                            } else {
                                continue;
                            }
                        } catch (ArithmeticException e) {
                            System.out.println(e);
                            continue;
                        }
                        //level two
                        boolean endPersonalInfoAdd = true;
                        while (endPersonalInfoAdd) {
                            file.setInfoFile(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt", true)));
                            String fname = "";
                            String lname = "";
                            int age = 0;
                            System.out.println("enter firstname please");
                            fname = write.next();
                            System.out.println("enter a lastname please");
                            lname = write.next();
                            System.out.println("verify your age.you must be older than 18 yrs old and younger than 100 yrs old");
                            try {
                                age = write.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("we only accept numbers");
                                write.next();
                                continue;
                            }
                            try {
                                if (ExceptionHandler.level_two(fname, lname, age)) {
                                    infoCount++;
                                    file.sendPersonalInfo(infoCount, counter, fname, lname, age);
                                    endPersonalInfoAdd = Choice.endChoice(write, "Personal Information Add");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                                continue;
                            }
                        }
                        boolean endCourseAdd = true;
                        while (endCourseAdd) {
                            file.setCourseFile(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Courses.txt", true)));
                            String subject = "";
                            String sched = "";
                            int unit = 0;
                            System.out.println("enter subject please");
                            subject = write.next();
                            System.out.println("enter a schedule please");
                            sched = write.next();
                            System.out.println("enter number of units. It must be greater than 10 and less than 50");
                            try {
                                unit = write.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("we only accept numbers");
                                write.next();
                                continue;
                            }
                            try {

                                if (ExceptionHandler.level_Three(subject, sched, unit)) {
                                    courCount++;
                                    file.sendCourse(courCount, counter, subject, sched, unit);
                                    endCourseAdd = Choice.endChoice(write, "Course Information Add");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                                continue;
                            }
                        }
                        endAdd = Choice.endChoice(write, "add");
                    }
                    break;
                case 3:
                    boolean endDelete = true;
                    while (endDelete) {

                        transaction("delete");
                        int choiceDelete = Choice.ans(write);
                        if (transactionChoice == 0) {
                            continue;
                        }
                        switch (choiceDelete) {
                            case 1:

                                break;

                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("idiot!!! only choose from the given!!");
                                break;
                        }
                        endAdd = Choice.endChoice(write, "delete");
                    }
                    break;
                case 4:
                    boolean endUpdate = true;
                    while (endUpdate) {

                        transaction("update");
                        int choiceUpdate = Choice.ans(write);
                        if (transactionChoice == 0) {
                            continue;
                        }
                        switch (choiceUpdate) {
                            case 1:

                                break;

                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("idiot!!! only choose from the given!!");
                                break;
                        }
                        endAdd = Choice.endChoice(write, "update");
                    }
                    break;
                case 5:
                    boolean endSearch = true;
                    while (endSearch) {

                        transaction("search");
                        int choiceSearch = Choice.ans(write);
                        if (transactionChoice == 0) {
                            continue;
                        }
                        switch (choiceSearch) {
                            case 1:

                                break;

                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("idiot!!! only choose from the given!!");
                                break;
                        }
                        endAdd = Choice.endChoice(write, "search");
                    }
                    break;
                default:
                    System.out.println("please you didn't choose properly!! idiot!");
                    break;
            }
            end = Choice.endChoice(write, "transaction");
        }
    }

}
