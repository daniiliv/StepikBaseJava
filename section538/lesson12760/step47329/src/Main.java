class Main {
//Stepik code: start

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        int absValue = Math.abs(value);

        return Integer.bitCount(absValue) == 1;
        /**
         * Можно решить с помощью побитовой операции И:
         *
         * return (absValue & (absValue - 1) == 0) & (absValue != 0);
         */
    }
//Stepik code: end
}
