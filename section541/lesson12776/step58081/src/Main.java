import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Реализуйте метод, вычисляющий симметрическую разность двух множеств.
 * <p>
 * Метод должен возвращать результат в виде нового множества.
 * Изменять переданные в него множества не допускается.
 * <p>
 * Пример
 * <p>
 * Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */
class Main {
    //Stepik code: start
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> resultSet = new LinkedHashSet<>(set1);

        set2.forEach(
                item -> {
                    if (resultSet.contains(item)) resultSet.remove(item);
                    else resultSet.add(item);
                }
        );

        return resultSet;
    }
//Stepik code: end
}
