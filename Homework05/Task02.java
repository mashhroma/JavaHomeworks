// 2. Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

package Homework05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Task02 {
    public static void main(String[] args) throws IOException {
        try {
            String path = "staffList.txt";
            String data = Files.readString(Path.of(path));
            
            String[] dataArray = data.split("\n");
            
            HashMap<String, Integer> repeatNameCounter = new HashMap<>();
            for (String fullName : dataArray) {
                String name = fullName.split(" ")[0];
                if (repeatNameCounter.containsKey(name)) {
                    repeatNameCounter.put(name, repeatNameCounter.get(name) + 1);
                } else {
                    repeatNameCounter.put(name, 1);
                }
            }

            LinkedList<String> sortedData = new LinkedList<>();
            for (var itemMap : repeatNameCounter.entrySet()) {
                sortedData.add(itemMap.getValue()+" "+itemMap.getKey());
            }
            Collections.sort(sortedData, Collections.reverseOrder());
            
            System.out.println("Топ имен сотрудников (по количеству повторений):");
            for (String string : sortedData) {
                System.out.println(string);
            }
        
        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
        }
    }
}
