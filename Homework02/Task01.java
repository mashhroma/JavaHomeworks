/*
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл.
 */

package Homework02;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task01 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите числа через запятую: ");
        String numbers = input.nextLine();
        input.close();

        int[] numsArray = Stream.of(numbers.split("[,]")).mapToInt(Integer::parseInt).toArray();

        File log = new File("logTask01.txt");

        try {
            FileWriter writer = new FileWriter(log);
            int temp;
            for (int i = 0; i < numsArray.length-1; i++) {
                for (int j = 0; j < numsArray.length-1-i; j++) {
                    if (numsArray[j]>numsArray[j+1]){
                        temp = numsArray[j+1];
                        numsArray[j+1] = numsArray[j];
                        numsArray[j] = temp;
                        }
                        writer.write("Итерация i=" + i + ", j=" + j + ": ");
                        for (int k = 0; k < numsArray.length; k++) {
                            writer.write(Integer.toString(numsArray[k]) + " ");
                            };
                        writer.write("\n");
                    }
                writer.write("\n");
                }     
            Date date = new Date();
            writer.write("Лог сформирован.\n" + date);
            writer.close();
            System.out.println("Лог-файл сформирован.");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
        }
        
        System.out.print("Упорядоченный массив: ");
        for (int item : numsArray) {
            System.out.printf("%d ", item);
            }
    }
}
