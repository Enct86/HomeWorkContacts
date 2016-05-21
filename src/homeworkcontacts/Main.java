/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkcontacts;

import java.util.Scanner;

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
                    long namelong = System.currentTimeMillis();
                    String namestring = Long.toString(namelong);
                    File filecontact = new File("./" + contactdir + "./" + namestring + ".txt");
                    filecontact.createNewFile();
                    Scanner scandata = new Scanner(System.in);
                    FileOutputStream fos = new FileOutputStream(filecontact, true);
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
                    fos.close();
                case 2:
                    try {
                        FileInputStream fis = new FileInputStream(contactdir);
                        File[] listFiles = contactdir.listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (file.isFile()) {
                                    System.out.printf(file.getName());
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("Error" + e);
                    }
            }

        } while (i != 5);
    }

}
