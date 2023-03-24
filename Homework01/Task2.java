package Homework01;

import java.util.Scanner;

/*
 * Реализовать простой калькулятор (+ - / *)
Ввод числа ->
Ввод знака ->
Ввод числа ->
 */

public class Task2 {
    public static void main(String[] args) {
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
                break;
            case "-":
                System.out.printf("Разность чисел равна: %d", num1-num2);
                break;
            case "*":
                System.out.printf("Произведение чисел равно: %d", num1*num2);
                break;
            case "/":
                System.out.printf("Частное чисел равно: %d", num1/num2);
                break;
            default:
                System.out.println("Такой операции не существует.");
                break;
        }
    }
}
