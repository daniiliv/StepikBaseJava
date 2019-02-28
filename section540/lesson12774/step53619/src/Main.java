import java.util.logging.*;

class Main {
    //Stepik code: start

    /**
     * В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.
     *
     * Требуется выставить такие настройки, чтобы:
     *
     * Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
     * Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
     * Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
     */
    public static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        Logger loggerJ = Logger.getLogger("org.stepic.java");

        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);

        Handler handler = new ConsoleHandler();
        Formatter formatter = new XMLFormatter();

        handler.setFormatter(formatter);
        handler.setLevel(Level.ALL);

        loggerJ.setUseParentHandlers(false);
        loggerJ.addHandler(handler);
    }
//Stepik code: end
}
