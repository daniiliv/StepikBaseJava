import java.util.Locale;
import java.util.Scanner;

/**
 * Напишите программу, читающую текст из System.in и выводящую в
 * System.out сумму всех встреченных в тексте вещественных чисел
 * с точностью до шестого знака после запятой. Числом считается
 * последовательность символов, отделенная от окружающего текста
 * пробелами или переводами строк и успешно разбираемая
 * методом Double.parseDouble.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = 0d;
        double currDouble;

        while (scanner.hasNext()) {
            try {
                currDouble = Double.parseDouble(scanner.next());
                result += currDouble;
            } catch (Exception e) { }
        }
        System.out.format("%.6f", result);
    }




}