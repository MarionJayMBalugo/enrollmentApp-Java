/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 2ndyrGroupC
 */
public class Array {

    private static ArrayList<ArrayList> accList = new ArrayList();
    private static ArrayList<ArrayList> infoList = new ArrayList();
    private static ArrayList<ArrayList> courseList = new ArrayList();

    public Array() {
    }

    public static void setAccList(ArrayList list) {
        accList = list;
    }

    public static void setInfoList(ArrayList list) {
        infoList = list;
    }

    public static void setCourseList(ArrayList list) {
        courseList = list;
    }

    public static void addAccList(ArrayList list) {
        accList.add(list);
    }

    public static void addInfoList(ArrayList list) {
        infoList.add(list);
    }

    public static void addCourseList(ArrayList list) {
        courseList.add(list);
    }

    public static ArrayList<ArrayList> getAccList() {
        return accList;
    }

    public static ArrayList<ArrayList> getInfoList() {
        return infoList;
    }

    public static ArrayList<ArrayList> getCourseList() {
        return courseList;
    }

    public static void displayAccList() {

        for (ArrayList x : accList) {
            System.out.printf("%s\t%10s\t%10s\n", x.get(0), x.get(1), x.get(2));
        }
    }

    public static void displayInfoList() {

        for (ArrayList x : infoList) {
            System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", x.get(0), x.get(1), x.get(2), x.get(3), x.get(4));
        }
    }

    public static void displayCourseList() {

        for (ArrayList x : courseList) {
            System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n", x.get(0), x.get(1), x.get(2), x.get(3), x.get(4));
        }
    }

    public static void searchAcc(int index) {
        for (ArrayList a : accList) {
            if (((String) a.get(0)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2));
            }

        }
    }

    public static void searchInfo(int index) {
        for (ArrayList a : infoList) {
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2));
            }

        }
    }

    public static void searchCourses(int index) {
        for (ArrayList a : courseList) {
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2));
            }

        }
    }

    public static void deleteInfo(int index) {
        for (ArrayList a : infoList) {
            if (((String) a.get(0)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2));
                infoList.remove(infoList.indexOf(a));
                System.out.println(accList.toString());

            }

        }
    }

    public static void deleteCourse(int index) {
        for (ArrayList a : courseList) {
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                System.out.printf("%s\t%10s\t%10s\n", a.get(0), a.get(1), a.get(2));
                courseList.remove(courseList.indexOf(a));
                System.out.println(courseList.toString());
            }

        }
    }

    public static void updateInfo(int index, ArrayList<String> list) {
        for (ArrayList a : infoList) {
            if (((String) a.get(0)).equals(String.valueOf(index))) {
                infoList.set(infoList.indexOf(a), list);
            }

        }
    }

    public static void updateCourse(int index, ArrayList<String> list) {
        for (ArrayList a : courseList) {
            if (((String) a.get(1)).equals(String.valueOf(index))) {
                courseList.set(courseList.indexOf(a), list);

            }

        }
    }

}
