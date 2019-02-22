import java.math.BigInteger;

class Main {
//Stepik code: start

    /**
     * Реализуйте метод, вычисляющий факториал заданного натурального числа.
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger res = BigInteger.ONE;
        if (value == 0 || value == 1) {
            return BigInteger.ONE;
        }
        for (int i = 1; i <= value; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
//Stepik code: end
}
