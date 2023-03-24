package Homework01;

import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
Ввод:5
Треугольное число 1 + 2 + 3 + 4 + 5 = 15
n! 1 * 2 * 3 * 4 * 5 = 120
 */

public class Task0 {
    public static void main(String[] args) {
        int triangleSum = 0;
        int factorial = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = input.nextInt();
        input.close();

        for (int i = 1; i <= num; i++) {
            triangleSum += i;
            factorial *= i;
        }

        System.out.printf("Треугольное число равно: %d \nФакториял равен: %d", triangleSum, factorial);
    }
}
