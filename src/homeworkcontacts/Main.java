/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkcontacts;

import java.util.*;

import java.io.*;

/**
 *
 * @author Max Savchenko
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner scr1 = new Scanner(System.in);
        int i = 0;
        File contactdir = new File("contacts");
        if (!contactdir.exists()) {
            contactdir.mkdir();
        }
        do {
            System.out.printf("1 - Add new contact, \n2 - View all contacts\n3 - Show contact \n4 - Delete contact\n5 - Exit\n");
            String input1 = scr1.nextLine();
            i = Integer.parseInt(input1);
            switch (i) {
                case 1:
                    try {
                        long namelong = System.currentTimeMillis();
                        String namestring = Long.toString(namelong);
                        File filecontact = new File("./" + contactdir + "./" + namestring + ".txt");
                        Scanner scandata = new Scanner(System.in);
                        FileOutputStream fos = new FileOutputStream(filecontact, true);
                        filecontact.createNewFile();
                        System.out.printf("Enter - NAME\nTelephone number\nEmail\nSkype\nAt When finish type end\n");
                        while (true) {
                            String line = scandata.nextLine();
                            if ("end".equals(line)) {
                                break;
                            }
                            byte[] bytes = line.getBytes();
                            fos.write(bytes);
                            fos.write('\n');
                            
                        }
                    } catch (Exception e) {
                        System.err.println("Error" + e);
                    }

                    break;
                case 2:
                    try {
                        File[] listFiles = contactdir.listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                BufferedReader br = new BufferedReader(new FileReader(file));
                                String name = br.readLine();
                                if (file.isFile()) {

                                    System.out.println(file.getName() + "    " + name);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error" + e);
                    }

                    break;
                case 3:
                    System.out.println("");
                    Scanner scan3  = new Scanner(System.in);
                    String input3 = scan3.nextLine();
                    try {
                        File[] listFiles = contactdir.listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (file.getName().equals(input3)) {
                                    
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error" + e);
                    }
            }

        } while (i != 5);

    }

}
