import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Пусть дан произвольный список целых чисел, удалить из него чётные числа

public class Task02 {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(20, 30); i++) {
            numbersList.add(new Random().nextInt(100));
        }
        System.out.println(numbersList);
        
        Iterator<Integer> col = numbersList.iterator();
        while (col.hasNext()) {
            if (col.next()%2 == 0)
                col.remove();
        }
        System.out.println(numbersList);
    }
}
