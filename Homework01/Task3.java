package Homework01;

import java.util.Scanner;

/* * 
*(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет.
под знаками вопроса - одинаковые цифра
Ввод: 2? + ?5 = 69
Вывод: 24 + 45 = 69
 */

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите уравнение (маска ввода 00+00=00), заменив некоторые цифры знаком вопроса : ");
        String task = input.nextLine();
        input.close();

        int number1;
        int number2;
        int sum;
        String answers = "";

        for (Integer i = 0; i < 10; i++) {
            String changedTask = task.replace("?", i.toString());
            String [] array_task = changedTask.split("[+=]");
            number1 = Integer.parseInt(array_task[0]);
            number2 = Integer.parseInt(array_task[1]);
            sum = Integer.parseInt(array_task[2]);
            if (number1+number2==sum) answers += changedTask + "\n";
            // System.out.println(number1 + "+" + number2 + "=" + sum);
        }
        
        if (answers.length()>0) System.out.printf("Варианты решения уравнения:\n%s", answers);
        else System.out.println("Решения нет.");
    }
}
