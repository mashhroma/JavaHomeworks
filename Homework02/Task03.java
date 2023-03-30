// 3*дополнительно. К калькулятору из предыдущего дз добавить логирование.
// 1 + 3 = 4
// 4 + 3 = 7

package Homework02;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task03 {
    public static void main(String[] args) throws IOException {
        File log = new File("logTask03.txt");
        try {
            FileWriter writer = new FileWriter(log, true);

            Scanner input = new Scanner(System.in);
            System.out.print("Введите первое целое число: ");
            int num1 = input.nextInt();
            System.out.print("Введите знак ( +, -, *, / ): ");
            String operation = input.next();
            System.out.print("Введите второе целое число: ");
            int num2 = input.nextInt();
            input.close();
            
            switch (operation){
                case "+":
                    System.out.printf("Сумма чисел равна: %d", num1+num2);
                    writer.write("Выбрана операция: " + operation + " | Введены числа: " + num1 + ", " + num2 + " | Результат: " + (num1+num2));
                    break;
                case "-":
                    System.out.printf("Разность чисел равна: %d", num1-num2);
                    writer.write("Выбрана операция: " + operation + " | Введены числа: " + num1 + ", " + num2 + " | Результат: " + (num1-num2));
                    break;
                case "*":
                    System.out.printf("Произведение чисел равно: %d", num1*num2);
                    writer.write("Выбрана операция: " + operation + " | Введены числа: " + num1 + ", " + num2 + " | Результат: " + (num1*num2));
                    break;
                case "/":
                    System.out.printf("Частное чисел равно: %d", num1/num2);
                    writer.write("Выбрана операция: " + operation + " | Введены числа: " + num1 + ", " + num2 + "| Результат: " + (num1/num2));
                    break;
                default:
                    System.out.println("Такой операции не существует.");
                    break;
            }
            Date date = new Date();
            writer.write("\nЛог сформирован.\n" + date + "\n\n");
            writer.close();
            System.out.printf("\nЛог сформирован.");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
        }
    }
}
