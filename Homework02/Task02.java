/*
 * Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода в консоль:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

package Homework02;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task02 {
    public static void main(String[] args) throws IOException {
        try {
            String path = "students.txt";
            String data = Files.readString(Path.of(path));            
            System.out.println(DataParseToMessage(data));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так.");
        }
    }
    static StringBuilder DataParseToMessage (String data) {
        String[] students = data.replaceAll("\"", "").split("\n");
        StringBuilder finalMessage = new StringBuilder();
        for (String string : students) {
            String[] student = string.split("[:,]");
            finalMessage.append("Студент " + student[1] + " получил " + student[3] + " по предмету " +  student[5] + "\n");
        }
        return finalMessage;
    }
}
