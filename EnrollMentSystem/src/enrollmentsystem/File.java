
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 2ndyrGroupA
 */
public class File {

    private ArrayList<ArrayList> list = new ArrayList();
    private BufferedWriter accFile = null;
    private BufferedWriter courseFile = null;
    private BufferedWriter infoFile = null;

    public File() {
    }

    public File(BufferedWriter accF, BufferedWriter infoFile, BufferedWriter courseFile) {
        this.accFile = accF;
        this.courseFile = courseFile;
        this.infoFile = infoFile;
    }

    public ArrayList getList() {
        return list;
    }

    public BufferedWriter getAccFile() {
        return accFile;
    }

    public void setAccFile(BufferedWriter accFile) {
        this.accFile = accFile;
    }

    public BufferedWriter getCourseFile() {
        return courseFile;
    }

    public void setCourseFile(BufferedWriter courseFile) {
        this.courseFile = courseFile;
    }

    public BufferedWriter getInfoFile() {
        return infoFile;
    }

    public void setInfoFile(BufferedWriter infoFile) {
        this.infoFile = infoFile;
    }

    @Override
    public String toString() {
        return "File{" + "accFile=" + accFile + ", courseFile=" + courseFile + ", infoFile=" + infoFile + '}';
    }

    public void sendAccount(int id, String user, String password) throws IOException {
        try {
            String send = String.format("%d %s %s ", id, user, password);
            accFile.write(send);
            accFile.newLine();
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("connection closed!");
            accFile.close();
        }
    }

    public void sendPersonalInfo(int id, int accId, String fname, String lname, int age) throws IOException {
        try {
            String send = String.format("%d %d %s %s %d", id, accId, fname, lname, age);
            infoFile.write(send);
            infoFile.newLine();
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("connection closed!");
            infoFile.close();
        }
    }

    public void sendCourse(int id, int accId, String subject, String sched, int unit) throws IOException {
        try {
            String send = String.format("%d %d %s %s %d", id, accId, subject, sched, unit);
            courseFile.write(send);
            courseFile.newLine();
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("connection closed!");
            courseFile.close();
        }
    }

    public void sendArray(BufferedReader reader) throws IOException {
        ArrayList<String> tempList = new ArrayList();
        try {
            String line = reader.readLine();
            while (line != null) {          
                for (String item : line.split(" ")) {
                    tempList.add(item);
                }
                list.add(tempList);
                tempList = new ArrayList();          
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
