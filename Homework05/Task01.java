// 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

package Homework05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner choice = new Scanner(System.in, "UTF-8");
        Scanner input = new Scanner(System.in, "UTF-8");
        String action = "";

        while (!action.equals("stop")) {
            System.out.println("\n1. - Добавить контакт\n" +
                    "2. - Вывести контакты\n" +
                    "stop - Закончить работу\n");
            System.out.print("Введите действие: ");
            action = choice.nextLine().toLowerCase();

            switch (action) {
                case "1": // Добавить контакт
                    System.out.print("Введите имя: ");
                    String name = input.nextLine();

                    System.out.print("Введите номер телефона: ");
                    String phone = input.nextLine();
                    if (phoneBook.containsKey(name)) {
                        phoneBook.get(name).add(phone);
                    }else {
                        ArrayList<String> phones = new ArrayList<>(Arrays.asList(phone));
                        phoneBook.put(name, phones);
                    }
                    break;

                case "2": // Вывести контакты
                    // System.out.println(phoneBook);
                    for (var contact: phoneBook.entrySet()) {
                        System.out.printf("%s: %s \n", contact.getKey().toString(), String.join(", ", contact.getValue()));
                    }
                    break;

                case "stop": // Закончить работу
                    System.out.println("Работа завершена");
                    break;
            }
        }
        choice.close();
        input.close();
    }
}
