package Homework04;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

// 2) Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

public class Task02 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(new Random().nextInt(0, 100));
        }

        Scanner choice = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        System.out.println("\nТекущая очередь: " + myList);
        String action = "";

        while (!action.equals("0")) {
            System.out.println(
                    "\nВыберите действие с очередью:\n 1 - помещает элемент в конец очереди,\n 2 - возвращает первый элемент из очереди и удаляет его,\n 3 - возвращает первый элемент из очереди, не удаляя,\n 0 - остановка работы с очередью.");
            action = choice.next();
            System.out.println(" ");
            switch (action) {
                case "1": // помещает элемент в конец очереди
                    System.out.print("Введите число, которое нужно поместить в конец очереди: ");
                    int num = input.nextInt();
                    System.out.println("Текущая очередь: " + enqueue(myList, num));
                    break;
                case "2": // возвращает первый элемент из очереди и удаляет его
                    System.out.println("Первый элемент (удален): " + dequeue(myList));
                    System.out.println("Текущая очередь: " + myList);
                    break;
                case "3": // возвращает первый элемент из очереди, не удаляя
                    System.out.println("Первый элемент (без удаления): " + first(myList));
                    System.out.println("Текущая очередь: " + myList);
                    break;
                case "0": // выход
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Такой команды нет.");
                    break;
            }
        }
        choice.close();
        input.close();
    }

    static LinkedList<Integer> enqueue(LinkedList<Integer> list, int addLastElem) { // помещает элемент в конец очереди
        list.add(addLastElem);
        return list;
    }

    static Integer dequeue(LinkedList<Integer> list) { // возвращает первый элемент из очереди и удаляет его
        int firstElem = list.getFirst();
        list.removeFirst();
        return firstElem;
    }

    static Integer first(LinkedList<Integer> list) { // возвращает первый элемент из очереди, не удаляя
        int firstElem = list.getFirst();
        return firstElem;
    }
}
