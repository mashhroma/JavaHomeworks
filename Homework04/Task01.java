package Homework04;

import java.util.LinkedList;
import java.util.Random;

// 1) Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

class Task01 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(new Random().nextInt(0, 100));
        }
        System.out.println(myList);

        System.out.println(turnOverList(myList));
    }

    static LinkedList<Integer> turnOverList(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>();
        for (Integer elem : list) {
            newList.addFirst(elem);
        }
        return newList;
    }
}