class Main {
    //Stepik code: start

    /**
     * Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().
     *
     * Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет
     */
    public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object obj) {
            /**
             * Cравниваем ссылки объектов.
             */
            if (this == obj) {
                return true;
            }
            /**
             * Является ли переданный объект экземпляром необходимого класса.
             */
            if (obj instanceof ComplexNumber) {
                ComplexNumber other = (ComplexNumber) obj;

                //Сравниваем содержимое объектов.
                return this.re == other.getRe() && this.im == other.getIm();
            }
            return false;
        }

        @Override
        public int hashCode() {
            final int prime = 19;
            int result;
            Double res = 1d;

            res = prime * res + re;
            res = prime * res + im;
            result = res.hashCode();
            return result;
        }
    }
//Stepik code: end
}
