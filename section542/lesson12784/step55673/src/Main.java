import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Метод, который зачитает данные из InputStream и преобразует их в строку,
 * используя заданную кодировку.
 *
 * Пример
 * InputStream последовательно возвращает четыре байта: 48 49 50 51.
 *
 * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть
 * строку "0123".
 */
class Main {
    //Stepik code: start
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder string = new StringBuilder();
        int receivedByte;
//        String line = "";



        while ((receivedByte = (reader.read())) != -1) {
            string.append((char) receivedByte);
        }

//        try (BufferedReader rdr = new BufferedReader(reader)) {
//            while ((line = rdr.readLine()) != null) {
//                string.append(line);
//            }
//        }  почему так не работает? :\\\

        return string.toString();
    }
//Stepik code: end
}
