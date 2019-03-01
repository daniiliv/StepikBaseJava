import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 Метод, читающий входной поток и
 вычисляющий контрольную сумму прочитанных данных.

 Контрольная сумма данных вычисляется по следующему
 алгоритму:

 Контрольная сумма представляет собой число типа int.
 Контрольная сумма пустого набора данных равна нулю.
 Контрольная сумма непустого набора данных вычисляется
 по следующей рекуррентной формуле:
 Cn+1=rotateLeft(Cn) xor bn+1, где Cn — контрольная сумма
 первых n байт данных, rotateLeft — циклический сдвиг
 бит числа на один бит влево (чтобы не изобретать
 велосипед, используйте Integer.rotateLeft),

 bn — n-ный байт данных.
 Поскольку метод не открывал данный InputStream, то и
 закрывать его он не должен. Выброшенное из методов
 InputStream исключение должно выбрасываться из метода.

 Пример
 На вход подан InputStream, последовательно
 возвращающий три байта: 0x33 0x45 0x01. Вкачестве
 контрольной суммы должно быть возвращено число 71.

 */
class Main {
    //Stepik code: start
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        Logger logger = Logger.getLogger(Main.class.getName());
        int val;
        int result = 0;
        while ((val = inputStream.read()) != -1) {
            result = Integer.rotateLeft(result, 1) ^ val;
            logger.log(Level.WARNING, "Number was read: {0}", val);
        }
        return result;
    }


//Stepik code: end


}
