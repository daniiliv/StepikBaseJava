class Main {
    //Stepik code: start

    /**
     * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
     *
     * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
     *
     * Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
     * @return
     */
    public static String getCallerClassAndMethodName() {
        Throwable thr = new Throwable("error");
        StackTraceElement[] elements = thr.getStackTrace();
        if (elements.length >= 3) {
            return elements[2].getClassName() + "#" + elements[2].getMethodName();
        }



        return null; // your implementation here
    }
//Stepik code: end
}
