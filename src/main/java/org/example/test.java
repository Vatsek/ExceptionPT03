package org.example;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {

            try {
        makeRecord();
        System.out.println("success");
    }catch (FileSystemException e){
        System.out.println(e.getMessage());
    }
        catch (Exception e){
        System.out.println(e.getStackTrace());
    }

}

    public static void makeRecord() throws Exception{
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");

        String text;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) { // считываем введенные данные из консоли
            text = bf.readLine(); // записываем данные в переменную
        }catch (IOException e){
            throw new Exception("Произошла ошибка при работе с консолью"); // выкидываем ошибку, если что то пошло не так
        }

        String[] array = text.split(" "); // задаем массив строк из сплита переменной текста
        if (array.length != 6){
            throw new Exception("Введено неверное количество параметров");
        }

        String surname = array[0]; // записываем в переменную фамилию
        String name = array[1]; // записываем в переменную имя
        String patronymic = array[2]; // записываем в переменную отчество

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy"); // создаем формат даты
        Date birthdate;
        try {
            birthdate = format.parse(array[3]); // парсим дату в переменную
        }catch (ParseException e){
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        int phone;
        try {
            phone = Integer.parseInt(array[4]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Неверный формат телефона");
        }

        String sex = array[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")){
            throw new RuntimeException("Неверно введен пол");
        }

        System.out.println(name);
        System.out.println(surname);
        System.out.println(patronymic);
        System.out.println(birthdate);
        System.out.println(phone);
        System.out.println(sex);


//        String fileName = "files\\" + surname.toLowerCase() + ".txt";
//        File file = new File(fileName);
//        try (FileWriter fileWriter = new FileWriter(file, true)){
//            if (file.length() > 0){
//                fileWriter.write('\n');
//            }
//            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, format.format(birthdate), phone, sex));
//        }catch (IOException e){
//            throw new FileSystemException("Возникла ошибка при работе с файлом");
//        }

    }
}
