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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnrollMentSystem {

    static int counter = 0;
    static int infoCount = 0;
    static int courCount = 0;

    public static void main(String[] args) throws IOException {
        boolean endAll = true;
        while (endAll) {
            File file
                    = new File(new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt", true)),
                            new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt", true)),
                            new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC"
                                    + "\\Desktop\\Courses.txt", true)));
            counter = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt")));
            courCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Courses.txt")));
            infoCount = Counter.count(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt")));
            File file1 = new File();
            file1.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Personal_Info.txt")));
            Array.setInfoList(file1.getList());
            file.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Accounts.txt")));
            Array.setAccList(file.getList());
            File file2 = new File();
            file2.sendArray(new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Desktop\\Courses.txt")));
            Array.setCourseList(file2.getList());
            Scanner write = new Scanner(System.in);

            boolean end = true;
            while (end) {
                //instantiates here

//scanner        
//instantiating account,course,name classes
                Account acc = new Account();
                Course course = new Course();
                Name name = new Name();
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
                                    Array.displayInfoList();
                                    System.out.println("display Personal Course");
                                    Array.displayCourseList();
                                    break;

                                case 2:

                                    Array.displayAccList();
                                    break;
                                case 3:

                                    Array.displayInfoList();
                                    break;
                                case 4:

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
                                    ArrayList<String> list = new ArrayList();
                                    list.add(String.valueOf(counter));
                                    list.add(user);
                                    list.add(password);
                                    Array.addAccList(list);
                                    System.out.println(Array.getAccList());

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
                                        ArrayList<String> list = new ArrayList();
                                        list.add(String.valueOf(infoCount));
                                        list.add(String.valueOf(counter));
                                        list.add(fname);
                                        Array.addInfoList(list);
                                        endPersonalInfoAdd = Choice.endChoice(write, "Personal Information Add");
                                        list.add(lname);
                                        list.add(String.valueOf(age));
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
                                        ArrayList<String> list = new ArrayList();
                                        list.add(String.valueOf(courCount));
                                        list.add(String.valueOf(counter));
                                        list.add(subject);
                                        list.add(sched);
                                        list.add(String.valueOf(unit));
                                        Array.addCourseList(list);
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

                            System.out.println("1 to delete personal info\n2 to delete courses");
                            int choiceDelete = Choice.ans(write);
                            if (transactionChoice == 0) {
                                continue;
                            }
                            switch (choiceDelete) {
                                case 1:
                                    System.out.println("deleting in personal Information");
                                    Array.deleteInfo(write.nextInt());
                                    break;

                                case 2:
                                    System.out.println("deleting in courses Information");
                                    Array.deleteCourse(write.nextInt());
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

                            System.out.println("1 to update personal info\n2 to update courses");
                            int choiceUpdate = Choice.ans(write);
                            if (transactionChoice == 0) {
                                continue;
                            }
                            switch (choiceUpdate) {
                                case 1:
                                    System.out.println("searching personal info");
                                    int updateHolder = write.nextInt();
                                    Array.searchInfo(updateHolder);
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
                                            ArrayList<String> list = new ArrayList();
                                            list.add(String.valueOf(infoCount));
                                            list.add(String.valueOf(counter));
                                            list.add(fname);
                                            Array.addInfoList(list);
                                            list.add(lname);
                                            list.add(String.valueOf(age));
                                            Array.updateInfo(updateHolder,list);
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                        continue;
                                    }

                                    break;

                                case 2:
                                    System.out.println("searching in course");
                                    int updateHolder2 = write.nextInt();
                                    Array.searchCourses(updateHolder2);
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
                                        ArrayList<String> list = new ArrayList();
                                        list.add(String.valueOf(courCount));
                                        list.add(String.valueOf(counter));
                                        list.add(subject);
                                        list.add(sched);
                                        list.add(String.valueOf(unit));
                                        
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                    continue;
                                }

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

                            System.out.println("1 to search account\n2 to search personal info\n3 to search courses");
                            int choiceSearch = Choice.ans(write);
                            if (transactionChoice == 0) {
                                continue;
                            }
                            switch (choiceSearch) {
                                case 1:
                                    System.out.println("searching in account");
                                    Array.searchAcc(write.nextInt());
                                    break;

                                case 2:
                                    System.out.println("searching in account");
                                    Array.searchInfo(write.nextInt());
                                    break;
                                case 3:
                                    System.out.println("searching in account");
                                    Array.searchCourses(write.nextInt());
                                    break;

                                default:
                                    System.out.println("idiot!!! only choose from the given!!");
                                    break;
                            }
                            endSearch= Choice.endChoice(write, "search");

                        }
                        break;
                    case 6:
                        System.out.println("all changes saved");
                        file.sendAccount(Array.getAccList());
                        file.sendPersonalInfo(Array.getInfoList());
                        file.sendCourse(Array.getCourseList());
                        end = false;
                        break;
                    default:
                        System.out.println("please you didn't choose properly!! idiot!");
                        break;
                }
            }
            endAll = Choice.endChoice(write, "transaction");
        }
    }

}
