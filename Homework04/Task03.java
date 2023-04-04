import java.util.Scanner;
import java.util.Stack;

// 3) В калькулятор добавьте возможность отменить последнюю операцию.

public class Task03 {
    public static void main(String[] args) {
        System.out.println("\nКалькулятор открыт.\n");
        Scanner choice = new Scanner(System.in, "windows-1251");
        Scanner input = new Scanner(System.in);
        
        Stack<Integer> results = new Stack<>();

        System.out.print("Введите первое число: ");
        int firstNumber = input.nextInt();
        results.push(firstNumber);

        int number;
        String operation = "";

        while (!operation.equals("exit")) {
            System.out.print("\nВведите операцию ( +, -, *, / , cancel, exit): ");
            operation = choice.nextLine();

            switch (operation) {
                case "+":
                    System.out.print("Введите число: ");
                    number = input.nextInt();
                    results.push(results.lastElement() + number);
                    System.out.printf("Сумма чисел равна: %d", results.lastElement());
                    break;
                case "-":
                    System.out.print("Введите число: ");
                    number = input.nextInt();
                    results.push(results.lastElement() - number);
                    System.out.printf("Разность чисел равна: %d", results.lastElement());
                    break;
                case "*":
                    System.out.print("Введите число: ");
                    number = input.nextInt();
                    results.push(results.lastElement() * number);
                    System.out.printf("Произведение чисел равно: %d", results.lastElement());
                    break;
                case "/":
                    System.out.print("Введите число: ");
                    number = input.nextInt();
                    results.push(results.lastElement() / number);
                    System.out.printf("Частное чисел равно: %d", results.lastElement());
                    break;
                case "cancel":
                    results.pop();
                    System.out.printf("Отмена последней операции, текущее значение: %d", results.lastElement());
                    break;
                case "exit":
                    System.out.printf("Калькулятор закрыт.");
                    break;
                default:
                    System.out.println("Такой операции не существует.");
                    break;
            }
        }
        choice.close();
        input.close();
    }
}
