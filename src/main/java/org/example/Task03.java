package org.example;

import java.util.Scanner;

//3.Напишите программу, которая запрашивает у пользователя ввод некоторых данных, например, возраст,
// имя или адрес электронной почты. Проверьте ввод пользователя на соответствие определенным
// критериям (например, возраст должен быть положительным числом, имя не должно содержать цифр и т.д.).
// В случае некорректного ввода, обработайте исключение и выведите сообщение об ошибке.
public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес электронной почты: ");
        String input = scanner.nextLine();
        if (input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            System.out.println("Адрес корректный");
        } else {
            throw new RuntimeException("Адрес не корректный");
        }
    }
}
