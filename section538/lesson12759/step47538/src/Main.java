class Main {
    //Stepik code: start

    /**
     * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
     * Допустимая погрешность – 0.0001 (1E-4)
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean doubleExpression(double a, double b, double c) {

        return Math.abs(a + b - c) < 1E-4;
    }
//Stepik code: end
}
