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
        infoCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt")));
//scanner        
        Scanner write = new Scanner(System.in);
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
                        endRetrieve = Choice.endChoice(write, "retrieve");
                        System.out.println(endRetrieve);
                    }
                    break;

                case 2:
                    boolean endAdd = true;
                    while (endAdd) {
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
                            }
                        } catch (ArithmeticException e) {
                            System.out.println(e);
                            continue;
                        }
                        endAdd = Choice.endChoice(write, "add");
                        String fname = "";
                        String lname = "";
                        int age = 0;
                        System.out.println("enter firstname please");
                        fname = write.next();
                        System.out.println("enter a lastname please");
                        lname = write.next();
                        System.out.println("verify your age.you must be older than 18 yrs old and younger than 100 yrs old");
                        age = write.nextInt();
                        try {
                            if (ExceptionHandler.level_two(fname, lname, age)) {
                                infoCount++;
                                file.sendPersonalInfo(infoCount, counter, fname, lname, age);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                            continue;
                        }

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
