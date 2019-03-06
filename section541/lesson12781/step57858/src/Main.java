import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * Напишите программу, читающую из System.in текст в кодировке UTF-8,
 * подсчитывающую в нем частоту появления слов, и в конце выводящую 10
 * наиболее часто встречающихся слов.
 *
 * Словом будем считать любую непрерывную последовательность символов,
 * состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 *
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама"
 * и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
 *
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 *
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя
 * однозначно упорядочить только по частоте, то дополнительно упорядочите
 * слова с одинаковой частотой в лексикографическом порядке.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8))
                .useDelimiter("[^\\p{L}\\p{Digit}]+"); //всё, что не буквы и цифры является разделителем

        //в хэш мапе храним слово и его частоту появления
        Map<String, Integer> hashMap = new HashMap<>();

        scanner.forEachRemaining(
                n -> hashMap.put(
                        n.toLowerCase(),
                        hashMap.get(
                                n.toLowerCase()) == null ? 1 : hashMap.get(n.toLowerCase()) + 1)
        );

        //создаём стрим из хэш мапы
        Stream<Map.Entry<String, Integer>> stringStream = hashMap.entrySet().stream();

        stringStream.sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue) //сортировка по частоте появления
                        .reversed()
                        .thenComparing(Map.Entry::getKey))//сортировка в лексикографическом порядке
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);

    }


}