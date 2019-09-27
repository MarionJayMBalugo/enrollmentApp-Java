/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author balugoma_Sd2023
 */
public class Choice {

    public static void transaction(String done) {
        String[] file = new String[]{" all", " from accounts", " from personal info", " from course"};
        int elemCount = 1;
        for (String fileElem : file) {
            System.out.println("press " + elemCount + " to " + done + fileElem);
            elemCount++;
        }
    }

    public static void transaction() {
        String[] file = new String[]{" to retrieve", " to add", " to delete", " to update", " to search"};
        int elemCount = 1;
        for (String fileElem : file) {
            System.out.println("press " + elemCount + " " + fileElem);
            elemCount++;
        }

    }
    public static boolean endChoice(Scanner write, String end) {
        boolean ans = true;
        System.out.println("press any key to continue\tpress 1 to end " + end);
        String endChoice = write.next();
        if (endChoice == "1") {
            ans = false;
        }
        return false;
    }
    public static int  ans(Scanner write){
        int transactionChoice=0;
        try {
                transactionChoice = write.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("opps please I'm asking for a digit!!!");
                write.next();
                continue;
            }
        return transactionChoice;
    }
    public static void condition(Scanner write, String choice) {
        boolean endAdd = true;
        while (endAdd) {
            int AddChoice = 0;
            transaction(choice);
            try {
                AddChoice = write.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("opps please I'm asking for a digit!!!");
                write.next();
                continue;
            }          
            switch (AddChoice) {
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
            endAdd = Choice.endChoice(write, choice);
        }
    }

}
