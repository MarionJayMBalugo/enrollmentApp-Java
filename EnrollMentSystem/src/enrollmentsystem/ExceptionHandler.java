/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

/**
 *
 * @author 2ndyrGroupA
 */
public class ExceptionHandler {

    public static boolean charIsDigit(String word) {
        boolean ans = false;
        for (int x = 0; x < word.length(); x++) {
            char y = word.charAt(x);
            if (Character.isDigit(y)) {
                ans = true;
            }
        }
        return ans;
    }

    public static boolean charIsNotString(String word) {
        boolean ans = false;
        for (int x = 0; x < word.length(); x++) {
            char y = word.charAt(x);
            if (Character.isLetter(y) == false) {
                ans = true;
            }
        }
        return ans;

    }
    public static void charShouldNotBeNumber(String word) {
        if (charIsNotString(word) || charIsDigit(word)) {
            throw new ArithmeticException("opps!numbers are not allowed");
        }
    }
//level one Checker
    public static boolean level_One(String user, String password, String verifyPass, int count) {
        boolean ans = false;
        charShouldNotBeNumber(user);
        if (password.length() < 8) {
            throw new ArithmeticException("password must be more than 8 characters in length");
        } else {
            if (password.equals(verifyPass)) {
                ans = true;
                count++;
            } else {
                System.out.println("password not match");
            }
        }
        return ans;
    }
//level two
    public static boolean level_two(String fname, String lname, String age,int count) {
        boolean ans = false;
        String name = fname + lname;
        charShouldNotBeNumber(name); 
        if (charIsDigit(age) == false) {
            throw new NumberFormatException("opps! letters are not allowed");
        }
        int agee = Integer.valueOf(age);
        if (agee < 18 || agee >= 100) {
            throw new ArithmeticException("dapat sakto ra ang idad please");
        } else {
            ans = true;
            count++;
        }
        return ans;

    }
//level three
    public static boolean level_Three(String course, String sched, String unit, int count) {
        boolean ans = false;
        charShouldNotBeNumber(course);
        charShouldNotBeNumber(sched);

        if (charIsDigit(unit) == false) {
            throw new NumberFormatException("opps! letters are not allowed");
        }
        int units = Integer.valueOf(unit);
        if (units < 0 || units > 50) {
            ans = false;
            throw new ArithmeticException("invalid number of load");

        } else {
            ans = true;
            count++;
        }

        return ans;
    }
    
}






