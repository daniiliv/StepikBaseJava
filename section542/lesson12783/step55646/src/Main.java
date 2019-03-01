import java.io.IOException;

/**
 * По историческим причинам на разных платформах принят разный способ
 * обозначения конца строки в текстовом файле. На Unix-системах конец
 * строки обозначается символом с кодом 10 ('\n'), на Windows — двумя
 * последовательными символами с кодами 13 и 10 ('\r' '\n').
 *
 * Напишите программу, которая будет преобразовывать переводы строк из
 * формата Windows в формат Unix. Данные в формате Windows подаются
 * программе в System.in, преобразованные данные должны выводиться в
 * System.out. На этот раз вам надо написать программу полностью, т.е.
 * объявить класс (с именем Main — таково ограничение проверяющей системы),
 * метод main, прописать все import'ы.
 *
 * Из-за буферизации данных в System.out в конце вашей программы надо
 * явно вызвать System.out.flush(). Иначе часть выведенных вами данных
 * не будет видна проверяющей системе.
 *
 */
public class Main {
    public final static byte CAR_RET = 13;
    public final static byte NEW_LINE= 10;

    public static void main(String... args) throws IOException {
        int prev, next;

        prev = System.in.read();
        while (prev != -1) {
            next = System.in.read();
            if (prev != CAR_RET || next != NEW_LINE) {
                System.out.write(prev);
            }
            prev = next;
        }
        System.out.flush();
    }
}