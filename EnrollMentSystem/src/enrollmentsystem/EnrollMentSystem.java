/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import static enrollmentsystem.Choice.transaction;
import java.io.BufferedWriter;

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
                = new File(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupA\\Desktop\\Accounts.txt", true)),
                        new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupA\\Desktop\\Personal_Info.txt", true)),
                        new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupA\\Desktop\\Courses.txt", true)));
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

                                break;
                        }
                        endRetrieve = Choice.endChoice(write, "retrieve");
                    }
                    break;

                case 2:
                    boolean endAdd = true;
                    while (endAdd) {
                        
                        transaction("add");
                        int choiceAdd = Choice.ans(write);
                        if (transactionChoice == 0) {
                            continue;
                        }
                        switch (choiceAdd) {
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

                                break;
                        }
                        endAdd = Choice.endChoice(write, "add");
                    }
                    break;
                case 3:
                    boolean endDelete = true;
                    while (endDelete) {
                        
                        transaction("delete");
                        int choiceDelete= Choice.ans(write);
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

                                break;
                        }
                        endAdd = Choice.endChoice(write, "delete");
                    }
                    break;
                case 4:
                    boolean endUpdate = true;
                    while (endUpdate) {
                        
                        transaction("update");
                        int choiceUpdate= Choice.ans(write);
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

                                break;
                        }
                        endAdd = Choice.endChoice(write, "update");
                    }
                    break;
                case 5:
                    boolean endSearch = true;
                    while (endSearch) {
                        
                        transaction("search");
                        int choiceSearch= Choice.ans(write);
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
