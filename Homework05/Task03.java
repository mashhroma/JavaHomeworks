// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

package Homework05;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class Task03 {
    private static int solution = 0;
    private static int boardSize = 8;
    private static LinkedHashMap<Integer, int[][]> solutionOptions = new LinkedHashMap<>();

    public static void main(String[] args) {
        int[][] queens = new int[boardSize][boardSize];
        solutionOptions = eightQueens(0, queens);

        System.out.print("Варианты решения задачи с расстановкой ферзей на доске. \n1 - Распечатать рандомное решение \n2 - Распечатать все решения \nВыбор: ");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.close();

        switch (choice) {
            case 1: // Распечатать рандомное решение
                int random = new Random().nextInt(0, solutionOptions.keySet().size());
                System.out.println("Решение №" + random);
                for (int i = 0; i < solutionOptions.get(random).length; i++) {
                    for (int j = 0; j < solutionOptions.get(random)[i].length; j++) {
                        if (solutionOptions.get(random)[i][j] == 1)
                            System.out.print("X ");
                        else
                            System.out.print(solutionOptions.get(random)[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 2: // Распечатать все решения
                for (var option : solutionOptions.entrySet()) {
                    System.out.println("Решение №" + option.getKey());
                    for (int i = 0; i < option.getValue().length; i++) {
                        for (int j = 0; j < option.getValue()[i].length; j++) {
                            if (option.getValue()[i][j] == 1)
                                System.out.print("X ");
                            else
                                System.out.print(option.getValue()[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
                break;
            default:
                System.out.println("Такой цифры в выборе нет.");
                break;
        }
    }

    private static LinkedHashMap<Integer, int[][]> eightQueens(int row, int[][] queens) {

        if (row == boardSize) {
            solution++;
            solutionOptions.put(solution, queens);
        } else {
            int[][] copyQueens = new int[boardSize][boardSize];
            for (int i = 0; i < queens.length; i++) {
                for (int j = 0; j < queens[i].length; j++) {
                    copyQueens[i][j] = queens[i][j];
                }
            }
            for (int col = 0; col < boardSize; col++) {
                if (checkRisk(row, col, copyQueens)) {
                    for (int c = 0; c < boardSize; c++) {
                        copyQueens[row][c] = 0; // Устанавливаем ферзя в других позициях текущей строки на 0
                    }
                    copyQueens[row][col] = 1;
                    eightQueens(row + 1, copyQueens);
                }
            }
        }
        return solutionOptions;
    }

    private static boolean checkRisk(int row, int col, int[][] copyQueens) {
        for (int r = row - 1; r >= 0; r--) { // Наверху
            if (copyQueens[r][col] == 1) {
                return false;
            }
        }
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) { // Верхний левый
            if (copyQueens[r][c] == 1) {
                return false;
            }
        }
        for (int r = row - 1, c = col + 1; r >= 0 && c < boardSize; r--, c++) { // В правом верхнем углу
            if (copyQueens[r][c] == 1) {
                return false;
            }
        }
        return true;
    }
}
