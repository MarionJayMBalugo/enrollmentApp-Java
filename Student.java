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
public class Student {
    private Name name;
    private Course course;
    private Account account;

    public Student(String fname,String lname,int age,String sub,String sched,int unit,String acc,String pass) {
        this.name = new Name(fname,lname,age);
        this.course = new Course(sub,sched,unit);
        this.account = new Account(acc,pass);
    }

    public Student() {
    }
    
// //name getters
    public Name getName(){
        return name;
    }
    public Course getCourse(){
        return course;
    }
    public Account getAccount(){
        return account;
    }
//    public String getFname(){
//        return name.getFname();
//    }
//    public String getLname(){
//        return name.getLname();
//    }
//    public int getAge(){
//        return name.getAge();
//    }
////course  getters
//    public Course getCourse(){
//        return course;
//    }
//    public String getSubject(){
//        return course.getSubject();
//    }
//    public String getSchedule(){
//        return course.getSchedule();
//    }
//    public int getLoadUnit(){
//        return course.getLoadUnit();
//    }
////account getters
//    public Account getAccount(){
//        return account;
//    }
//    public String getBaseAccount(){
//        return account.getAccount();
//    }
//    public String getPassword(){
//        return account.getPassword();
//    }
////name setters
//    
//    public void setName(String fname,String lname,int age){
//        this.name=new Name(fname,lname,age);
//    }
//    public void setFname(String fname){
//        this.name.setFname(fname);
//    }
////    public String getLname(){
////        return name.getLname();
////    }
////    public int getAge(){
////        return name.getAge();
////    }
}


