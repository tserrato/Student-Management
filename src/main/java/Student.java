
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjser
 */
public class Student {
    
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private int costOfCourse = 600;
    private static int id = 1000;
    
    
    // constructor for name and year
    
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name:");
        this.firstName = in.nextLine();
        
        System.out.println("Enter last name:");
        this.lastName = in.nextLine();
        
        System.out.println(" 1- Freshamn\n 2- Sophomore\n 3- Junior\n 4- Senior\n Enter class level:");
        this.gradeYear = in.nextInt();
        setStudentID();
        
        
        
        
    }
    
    // unique id
    private void setStudentID(){
        //Grade Level + ID
        id++;
        this.studentID = gradeYear+""+id;
    }
    
    //enroll courses
    public void enroll(){
        //loop , user hits 0
            do{
            System.out.println("Enter course to enroll(Q to quit)");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if(!course.equals("Q")){
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else{
                break;
            }
            }while(1!=0);
    }
    
    //balance
    public void viewBalance(){
        System.out.println("Your balance is $"+ tuitionBalance);
        
    }
    
    // tutition
    public void payTuition(){
        System.out.println("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thankyou for you payment of $" + payment);
        viewBalance();
    }
    
    //student status
    public String toString(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level-" + gradeYear + 
                "\nStudent ID-" + studentID +
                "\nCourses Enrolled-" + courses + 
                "\nBalance-" + tuitionBalance;
    }
    
}
