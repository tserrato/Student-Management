
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjser
 */
public class StudentDatabaseApp {
       
        
        public static void main(String[] args) throws IOException{


    Scanner in = new Scanner(System.in);
    while(true){
            System.out.println("1-Enroll Students" + 
                    "\n2-Enrolled Students" +
                    "\n3-Clear Storage" +
                    "\n4-Quit");
 
            int response = in.nextInt();
            
            if(response == 1){
                studentAdd();
            }
            else if(response == 2){
                studentList();
            }
            else if(response == 3){
                clearStorage();
            }
            else if(response == 4){
               System.exit(0);
               
            }
            else{
                System.out.println("Invalid Response");
            }
            
            
    }
            }
            
    
        public static void studentAdd(){
        encryption enc = new encryption();    
            
                        System.out.println("\nEnter number of new students to enroll: ");
            Scanner in = new Scanner(System.in);
            int numOfStudents = in.nextInt();
            Student[] students = new Student[numOfStudents];
            
            
            for( int n = 0; n<numOfStudents; n++){
                students[n] = new Student();
                students[n].enroll();
                students[n].payTuition();
                
                
                
                
            try{
                File myStudents = new File("output\\enrolledStudents.txt");
                FileWriter myWriter = new FileWriter(myStudents.getAbsoluteFile(), true);
                myWriter.write(enc.encrypt(Arrays.toString(students))+ "\n");
                
                
                myWriter.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
               
                
            }
                

            
        }
        }
        
        public static void studentList() throws IOException{
            encryption enc = new encryption();
            FileReader in = new FileReader("output\\enrolledStudents.txt");

            char[] chars = new char[256];
            int n = in.read(chars, 0, chars.length);

            String contents = new String(chars);
            
            
            
            
            System.out.print(enc.decrypt(contents));
            System.out.println("\n");

         
            
        }
        
        public static void clearStorage(){
            try{
                File myStudents = new File("output\\enrolledStudents.txt");
                FileWriter myWriter = new FileWriter(myStudents.getAbsoluteFile(), false);
                myWriter.write("");
                myWriter.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
               
                
            }

        }
}

    
   
