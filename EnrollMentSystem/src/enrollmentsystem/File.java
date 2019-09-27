
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

import java.io.BufferedWriter;

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
    public File(BufferedWriter accF,BufferedWriter courseFile,BufferedWriter infoFile){
        this.accFile=accF;
        this.courseFile=courseFile;
        this.infoFile=infoFile;
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
    
    

}


