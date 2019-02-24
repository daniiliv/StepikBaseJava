class Main {
    //Stepik code: start

    /**
     * Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.
     *
     * Класс AsciiCharSequence должен:
     *
     * реализовывать интерфейс java.lang.CharSequence;
     * иметь конструктор, принимающий массив байт;
     * определять методы length(), charAt(), subSequence() и toString()
     * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
     *
     * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
     */
    public class AsciiCharSequence implements CharSequence {
        private byte[] byteArray;

        public AsciiCharSequence(byte[] byteArray) {
            this.byteArray = byteArray;
        }

        @Override
        public int length() {
            return byteArray.length;
        }

        @Override
        public char charAt(int index) {
            return (char) byteArray[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            int len = end - start;
            byte[] subArray = new byte[len];
            for (int i = 0; i < len; i++) {
                subArray[i] = byteArray[start++];
            }
            return new AsciiCharSequence(subArray);

            //Или просто return new AsciiCharSequence(Arrays.copyOfRange(byteArray, start, end));
        }

        @Override
        public String toString() {
            return new String(byteArray);
        }
    }
//Stepik code: end
}
