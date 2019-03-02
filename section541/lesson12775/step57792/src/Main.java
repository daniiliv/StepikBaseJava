/**
 * Реализуйте generic-класс Pair, похожий на Optional,
 * но содержащий пару элементов разных типов и не запрещающий
 * элементам принимать значение null.
 *
 * Реализуйте методы getFirst(), getSecond(), equals()
 * и hashCode(), а также статический фабричный метод of().
 * Конструктор должен быть закрытым (private).
 */

import java.util.Objects;

class Pair<T, K> {
    private final T value1;
    private final K value2;

    private Pair(T value1, K value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getFirst() {
        return value1;
    }

    public K getSecond() {
        return value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(value1, pair.value1) &&
                Objects.equals(value2, pair.value2);
    }

    @Override
    public int hashCode() {
        if (value1 == null && value2 == null) return 0;
        else if (value1 == null) return value2.hashCode();
        else if (value2 == null) return value1.hashCode();
        else return value1.hashCode() * value2.hashCode();
        //return Objects.hash(value1, value2);
    }

    public static <T, K> Pair<T, K> of(T val1, K val2) {
        return new Pair<>(val1, val2);
    }
}
