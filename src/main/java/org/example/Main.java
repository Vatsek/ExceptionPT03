package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static javax.swing.UIManager.get;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("Введите фамилию, имя, отчество, дату рождения, номер телефона," +
//                " пол через пробел");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        System.out.println(data);


        String input = "Вацек Павел Александрович 24.03.88 79265974869 F";
        StringBuilder result = new StringBuilder();
        ArrayList<String> data = new ArrayList<String>(Arrays.asList(input.split(" ")));
        try {
            checkSize(data);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            checkDate(data.get(3));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(data.get(5));
            checkGender(data.get(5));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }















    }

    public static boolean checkSize(ArrayList<String> data) throws RuntimeException {
        if (data.size() == 6) {
            return true;
        } else throw new RuntimeException("Введено не верное количество параметров");
    }

    public static String checkDate(String dateStr) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);
        try {
            formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new ParseException("Не верный формат даты", e.getErrorOffset());
        }
        return dateStr;
    }

    public static String checkGender(String gender) {
        if (gender == "M" || gender == "F") {
            return gender;
        } else
            throw new RuntimeException("Не верный формат гендера");
    }




}
