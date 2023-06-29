package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Введите фамилию, имя, отчество, дату рождения, номер телефона," +
//                " пол через пробел");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        System.out.println(data);
        String input = "Вацек Павел Александрович 24.03.1988 +79265974869 m";


        ArrayList<String> data = new ArrayList<String>(Arrays.asList(input.split(" ")));
//        for (int i = 0; i < myList.size(); i++) {
//            System.out.println(myList.get(i));
        if (data.size() == 6) {
            System.out.println("ок");
        } else {
                System.out.println("Введены не все данные");
            }

    }
}
