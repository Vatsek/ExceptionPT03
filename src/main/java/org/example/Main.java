package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static javax.swing.UIManager.get;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("Введите фамилию, имя, отчество, дату рождения, номер телефона," +
//                " пол через пробел");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        System.out.println(data);


        String input = "Вацек Павел Александрович 24.03.88 79265974869 f";
        StringBuilder result = new StringBuilder();
        ArrayList<String> data = new ArrayList<String>(Arrays.asList(input.split(" ")));
        try {
            checkSize(data);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try { // проверияем Фамилию
            result.append(checkName(data.get(0)));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        try { // проверияем Имя
            result.append(checkName(data.get(1)));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        try { // проверияем Отчество
            result.append(checkName(data.get(2)));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        try {
            result.append('<'+(checkDate(data.get(3)))+ '>');
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            result.append(checkPhoneNum(data.get(4)));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        try {
            result.append(checkGender(data.get(5)));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);















    }

    public static boolean checkSize(ArrayList<String> data) throws RuntimeException {
        if (data.size() == 6) {
            return true;
        } else throw new RuntimeException("Введено не верное количество параметров");
    }

    public static String checkDate(String dateStr) throws ParseException {
        if (dateStr.matches("[0-9]{2}.[0-9]{2}.[0-9]{2}")) {
            return dateStr;
        } else throw new ParseException("Ошибка ввода даты", 1);
    }


    public static String checkGender(String gender) {
        if (gender.matches("[m,f]")) {
            return gender;
        } else throw new InputMismatchException("Не верно введён гендер");
    }

    public static String checkName(String name) {
        if (Pattern.matches("[а-яА-Я]+", name)) {
            return name;
        } else throw new InputMismatchException("Не верно введены ФИО");
    }

    public static String checkPhoneNum(String phone) {
        if (Pattern.matches("^[0-9]+[0-9]*$", phone)) {
            return phone;
        } else throw new InputMismatchException("Не верно введён номер телефона");
    }

}
