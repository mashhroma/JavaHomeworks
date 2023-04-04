import java.util.ArrayList;
import java.util.Random;

// (Дополнительное) Реализовать алгоритм сортировки слиянием

public class Task01 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add(new Random().nextInt(100));
        }
        System.out.println(numList);
        
        mergeSort(numList);
        System.out.println(numList);
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrList) {
        if (arrList.size() == 1) {
            return arrList;
        } else {
            int mid = arrList.size() / 2;
            ArrayList<Integer> left = new ArrayList<Integer>(mid);
            ArrayList<Integer> right = new ArrayList<Integer>(arrList.size() - mid);

            for (int i = 0; i < mid; i++) {
                left.add(arrList.get(i));
            }

            for (int i = mid; i < arrList.size(); i++) {
                right.add(arrList.get(i));
            }

            left = mergeSort(left);
            right = mergeSort(right);
            merge(left, right, arrList);
        }
        return arrList;
    }

    public static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> arrList) {
        int iLeft = 0;
        int iRight = 0;

        for (int i = 0; i < arrList.size(); i++) {
            if (iLeft == left.size()) {
                arrList.set(i, right.get(iRight));
                iRight++;
            } else {
                if (iRight == right.size()) {
                    arrList.set(i, left.get(iLeft));
                    iLeft++;
                } else {
                    if (left.get(iLeft) <= right.get(iRight)) {
                        arrList.set(i, left.get(iLeft));
                        iLeft++;
                    } else {
                        if (left.get(iLeft) >= right.get(iRight)) {
                            arrList.set(i, right.get(iRight));
                            iRight++;
                        }
                    }
                }
            }
        }
    }
}
