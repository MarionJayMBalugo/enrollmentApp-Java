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

    public static void displayAccList() {
        for (ArrayList x : accList) {
            System.out.printf("%s\t%10s\t%10s\n",x.get(0),x.get(1),x.get(2));
        }
    }
    public static void displayInfoList() {
        for (ArrayList x : infoList) {
            System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n",x.get(0),x.get(1),x.get(2),x.get(3),x.get(4));
        }
    }
    public static void displayCourseList() {
        for (ArrayList x : courseList) {
            System.out.printf("%s\t%10s\t%10s\t%10s\t%10s\n",x.get(0),x.get(1),x.get(2),x.get(3),x.get(4));
        }
    }

}
