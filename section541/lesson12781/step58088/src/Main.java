import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Напишите метод, находящий в стриме минимальный и максимальный элементы в
 * соответствии порядком, заданным Comparator'ом.
 *
 * Найденные минимальный и максимальный элементы передайте в minMaxConsumer
 * следующим образом:
 *
 * minMaxConsumer.accept(min, max);
 * Если стрим не содержит элементов, то вызовите
 * minMaxConsumer.accept(null, null);
 */
class Main {
    //Stepik code: start
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);

        stream.forEach(minMaxFinder);

        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);

    }

    private static class MinMaxFinder<T> implements Consumer<T> {
        T min;
        T max;
        private final Comparator<? super T> order;

        public MinMaxFinder(Comparator<? super T> order) {
            this.order = order;
        }

        @Override
        public void accept(T t) {
            if (min == null || order.compare(t, min) < 0) {
                min = t;
            }
            if (max == null || order.compare(t, max) > 0) {
                max = t;
            }
        }
    }
//Stepik code: end
}
