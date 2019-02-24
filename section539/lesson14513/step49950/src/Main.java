import java.math.BigInteger;
import java.util.function.DoubleUnaryOperator;

class Main {
    //Stepik code: start

    /**
      * Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле левых прямоугольников.
     *  Шаг сетки не больше 10^-6.
     *  Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator. Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.
      */
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = 1e-6;
        double res = 0;
        for (; a <= b; a += step) {
            res += f.applyAsDouble(a);
        }

        return res * step;
    }
//Stepik code: end
}
