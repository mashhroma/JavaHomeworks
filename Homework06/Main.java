/*
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
NoteBook notebook1 = new NoteBook
NoteBook notebook2 = new NoteBook
NoteBook notebook3 = new NoteBook
NoteBook notebook4 = new NoteBook
NoteBook notebook5 = new NoteBook
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
Класс сделать в отдельном файле

приветствие
Выбор параметра
выбор конкретнее
вывод подходящих
 */

package Homework06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main (String[] args) throws IOException {

        ArrayList<Notebook> notebooks = new ArrayList<Notebook>();

        try {
            String path = "JavaHomeworks\\Homework06\\laptopBase.csv";
            String data = Files.readString(Path.of(path));
            String[] dataArray = data.substring(data.indexOf("\n") + 1).split("\n");

            for (String string : dataArray) {
                String[] values = string.split(";");
                Notebook notebook = new Notebook(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                        values[3], Integer.parseInt(values[4]), values[5], values[6]);
                notebooks.add(notebook);
            }

            System.out.println("Данная программа выводит ноутбуки, которые удовлетворяют условиям поиска. \nВначале, выберите параметры для фильтрации: \n"+
                        " 1 - Оперативная память \n"+
                        " 2 - Жесткий диск \n"+
                        " 3 - Операционная система \n"+
                        " 4 - Размер экрана \n"+
                        " 5 - Производитель \n"+
                        " 6 - Цвет \n" +
                        "Напишите ОК после выбора параметров для поиска.");
            
            Scanner input = new Scanner(System.in);

            TreeSet<Integer> params = new TreeSet<>();
            boolean flag = true;
            while (flag) {
                System.out.print("Выбор параметра (напишите ОК, если все параметры выбраны): ");
                String choiceParam = input.nextLine().toLowerCase();
                if (choiceParam.equals("ok")) flag = false;
                else params.add(Integer.parseInt(choiceParam));
            }
            
            TreeMap<Integer, String> filter = new TreeMap<>();
            for (int param : params) {
                if (param == 1) System.out.print("Введите минимальное значение оперативной памяти: ");
                else if (param == 2) System.out.print("Введите минимальный размер жесткого диска: ");
                else if (param == 3) System.out.print("Введите операционную систему: ");
                else if (param == 4) System.out.print("Введите минимальный размер диагонали экрана: ");
                else if (param == 5) System.out.print("Введите производителя: ");
                else if (param == 6) System.out.print("Введите цвет: ");
                else System.out.println("");
                String find = input.nextLine().toLowerCase();
                filter.put(param, find);
            }
            
            input.close();

            System.out.println("\nРезультаты поиска:\n");
            int count = 0;
            for (Notebook notebook: notebooks) {
                if ((!filter.containsKey(1) || notebook.getRAM() >= Integer.parseInt(filter.get(1))) &&
                    (!filter.containsKey(2) || notebook.getHard() >= Integer.parseInt(filter.get(2))) &&
                    (!filter.containsKey(3) || notebook.getOS().toLowerCase().contains(filter.get(3))) &&
                    (!filter.containsKey(4) || notebook.getScreenSize() >= Integer.parseInt(filter.get(4))) &&
                    (!filter.containsKey(5) || notebook.getBrand().toLowerCase().contains(filter.get(5))) &&
                    (!filter.containsKey(6) || notebook.getColor().toLowerCase().contains(filter.get(6)))) {
                    System.out.println(notebook);
                    count++;
                }
            }
            
            if (count==0) System.out.println("Нет ноутбуков, удовлетворяющих фильтру.");
            else System.out.printf("Всего найдено ноутбуков: %d", count);

        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
        }
    }
}