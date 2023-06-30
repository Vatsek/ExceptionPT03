package org.example;

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
        String input = "Вацек Павел Александрович 24.03.1988 79265974869 M";
        ArrayList<String> data = new ArrayList<String>(Arrays.asList(input.split(" ")));
        try {
            checkSize(data);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy"); // создаем формат даты
        Date birthdate;
        birthdate = format.parse(data.get(3)); // парсим дату в переменную
        System.out.println(birthdate);


    }

    public static boolean checkSize(ArrayList<String> data) throws RuntimeException {
        if (data.size() == 6) {
            return true;
        } else throw new RuntimeException("Введено не верное количество параметров");
    }
}
