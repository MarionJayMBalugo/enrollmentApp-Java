
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author 2ndyrGroupA
 */
public class File {

    private BufferedWriter accFile = null;
    private BufferedWriter courseFile = null;
    private BufferedWriter infoFile = null;

    public File() {
    }

    public File(BufferedWriter accF, BufferedWriter courseFile, BufferedWriter infoFile) {
        this.accFile = accF;
        this.courseFile = courseFile;
        this.infoFile = infoFile;
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
            String send = String.format("%d %s %s \n", id, user, password);
            accFile.write(send);
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("connection closed!");
            accFile.close();
        }
    }
    public void sendPersonalInfo(int id,int accId, String fname, String lname,int age) throws IOException {
        try {
            String send = String.format("%d %d %s %s %d\n", id,accId,fname,lname,age);
            accFile.write(send);
            System.out.println("Data send");
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            System.out.println("connection closed!");
            accFile.close();
        }
    }

}
