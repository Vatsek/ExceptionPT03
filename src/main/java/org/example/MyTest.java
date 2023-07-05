package org.example;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyTest {
    public static void main(String[] args) {
        try {
            File file = new File("testF.txt");

            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new FileWriter(file,true));

            pw.append("test6\n");
//            pw.append("\n");
            pw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}