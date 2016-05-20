/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkcontacts;

import java.util.Scanner;

/**
 *
 * @author Max Savchenko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scr1 = new Scanner(System.in);
        int i = 0;
        do { 
            System.out.printf("1 - Add new contact, \n2 - View all contacts\n3 - Edit contact \n4 - Delete contact\n5 - Exit");
            String input1 = scr1.nextLine();
            i = Integer.parseInt(input1);
            switch(i){
                case 1:
                    
            }
            
        } while (i != 5);
    }
    
}
