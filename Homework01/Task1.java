package Homework01;

// Вывести все простые числа от 1 до 1000

public class Task1 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i%j == 0) flag = false;
            }
            if (flag == true) System.out.printf("%d, ", i);
        }
    }
}
