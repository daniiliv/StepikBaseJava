import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Реализуйте метод, который из переданного массива байт
 * восстановит массив объектов Animal. Массив байт устроен
 * следующим образом. Сначала идет число типа int, записанное
 * при помощи ObjectOutputStream.writeInt(size). Далее подряд
 * записано указанное количество объектов типа Animal,
 * сериализованных при помощи
 * ObjectOutputStream.writeObject(animal).
 *
 * Если вдруг массив байт не является корректным
 * представлением массива экземпляров Animal, то метод
 * должен бросить исключение java.lang.IllegalArgumentException.
 *
 */
class Main {
    //Stepik code: start
    public static Animal[] deserializeAnimalArray(byte[] data) {
        // your implementation here
        InputStream inputStream = new ByteArrayInputStream(data);
        int amount;
        Animal animal;
        Animal [] animals;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            amount = objectInputStream.readInt();
            animals = new Animal[amount];

            for (int i = 0; i < amount; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }


        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return animals;
    }
//Stepik code: end
}
