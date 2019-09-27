/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

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
            int transactionChoice = 0;
            Choice.transaction();
            try {
                transactionChoice = write.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("opps please I'm asking for a digit!!!");
                write.next();
                continue;
            }
            switch (transactionChoice) {
                case 1:
                    Choice.condition(write, "retrive");
                    break;

                case 2:
                    Choice.condition(write, "add");
                    break;
                case 3:
                    Choice.condition(write, "delete");
                    break;
                case 4:
                    Choice.condition(write, "update");
                    break;
                case 5:
                    Choice.condition(write, "search");
                    break;
                default:
                    System.out.println("please you didn't choose properly!! idiot!");
                    break;
            }
            end = Choice.endChoice(write, "transaction");
        }
    }

}
