package org.example;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyTest {
    public static void main(String[] args) {


    }

    public static void writeToFile(StringBuilder text, String name) {
        PrintWriter pw = null;
        try {
            File file = new File(name);

            if (!file.exists()) {
                file.createNewFile();
            }
            pw = new PrintWriter(new FileWriter(file, true));

            pw.append("text" + "\n");
            pw.close();
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        } finally {
            pw.close();
        }
    }

}