import java.util.*;

/**
 * Напишите программу, которая прочитает из System.in последовательность
 * целых чисел, разделенных пробелами, затем удалит из них все числа,
 * стоящие на четных позициях, и затем выведет получившуюся
 * последовательность в обратном порядке в System.out.
 * Все числа влезают в int. Позиции чисел в последовательности
 * нумеруются с нуля.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int value;

        while (scanner.hasNextInt()) {

            value = scanner.nextInt();

            if (i++ % 2 != 0) {
                list.add(value);
            }
        }

        Collections.reverse(list);

        list.forEach(item -> System.out.print(item + " "));
    }
}