import java.util.ArrayList;
import java.util.Random;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.

public class Task03 {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbersList.add(new Random().nextInt(100));
        }

        System.out.println(numbersList);

        numbersList.sort(null);
        int min = numbersList.get(0);
        int max = numbersList.get(numbersList.size() - 1);
        
        int sum = 0;
        for (Integer value : numbersList) {
            sum += value;
        }        
        int average = sum / numbersList.size();

        System.out.printf(" Минимальное значение в списке: %d \n Максимальное значение в списке: %d \n Среднеарифметическое значение элементов списка: %d", min, max, average);
    }
}
