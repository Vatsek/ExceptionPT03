package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите фамилию, имя, отчество - (текст через пробел), " +
                    "дату рождения (в формате dd.mm.yyyy), номер телефона(в формате целого беззнакового числа)," +
                    " пол (f ли m)");

            System.out.println("Что бы закончить, наберите exit");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            StringBuilder result = new StringBuilder();
            ArrayList<String> data = new ArrayList<String>(Arrays.asList(input.split(" ")));

            try {
                checkSize(data);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                result.append(checkName(data));
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            try {
                result.append(checkDate(data));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            try {
                result.append((checkPhoneNum(data)));
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            try {
                result.append((checkGender(data)));
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }


            ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(result.toString().split(">")));
            if (tmp.size() == 6) {
                String fileName = tmp.get(0);
                fileName = fileName.substring(1, fileName.length());
                try {
                    writeToFile(result, fileName);
                } catch (IOException e) {
                    e.getMessage();
                }
                }
            }
        }



    public static boolean checkSize(ArrayList<String> data) throws RuntimeException {
        if (data.size() == 6) {
            return true;
        } else throw new RuntimeException("Введено не верное количество параметров");
    }

    public static StringBuilder checkGender(ArrayList<String> data) throws InputMismatchException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).matches("[m,f]")) {
                result.append('<' + data.get(i) + '>');
                data.remove(i);
            }
        }
        if (result.length() == 0) {
            throw new InputMismatchException("Не верно введён гендер");
        }
        return result;
    }

    public static StringBuilder checkPhoneNum(ArrayList<String> data) throws InputMismatchException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            if (Pattern.matches("^[0-9]+[0-9]*$", data.get(i))) {
                result.append('<' + data.get(i) + '>');
                data.remove(i);
            }
        }
        if (result.length() == 0) {
            throw new InputMismatchException("Не верно введён номер телефона");
        }
        return result;
    }

    public static StringBuilder checkDate(ArrayList<String> data) throws ParseException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")) {
                result.append('<' + data.get(i) + '>');
                data.remove(i);
            }
        }
        if (result.length() == 0) {
            throw new ParseException("Ошибка ввода даты", 1);
        }
        return result;
    }

    public static StringBuilder checkName(ArrayList<String> data) throws InputMismatchException {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int j = 0; j < data.size(); ) {
            if (Pattern.matches("[а-яА-Я]+", data.get(j))) {
                result.append('<' + data.get(j) + '>');
                data.remove(j);
                j = 0;
                count++;
            } else {
                j++;
            }
        }
        if (count < 3) {
            throw new InputMismatchException("Не корректно введены ФИО");
        } else {
        return result; }
    }

    public static void writeToFile(StringBuilder text, String name) throws IOException {
        File file = new File(name);
        PrintWriter pw = new PrintWriter(new FileWriter(file, true));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            pw.append(text + "\n");

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        }
        finally {
            pw.close();
        }
    }
}
