/**
 * Thief – вор, который ворует самые ценные посылки и
 * игнорирует все остальное. Вор принимает в конструкторе
 * переменную int – минимальную стоимость посылки, которую
 * он будет воровать. Также, в данном классе должен
 * присутствовать метод getStolenValue, который возвращает
 * суммарную стоимость всех посылок, которые он своровал.
 * Воровство происходит следующим образом: вместо посылки,
 * которая пришла вору, он отдает новую, такую же, только с
 * нулевой ценностью и содержимым посылки "stones instead
 * of {content}".
 */
import stepikClasses.MailPackage;
import stepikClasses.MailService;
import stepikClasses.Package;
import stepikClasses.Sendable;

public class Thief implements MailService {
    private final int minPrice;
    private int stolenValue = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Package stolenPackage;
        int currPackagePrice;

        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            stolenPackage = mailPackage.getContent();
            currPackagePrice = stolenPackage.getPrice();

            if (currPackagePrice >= minPrice) {
                stolenValue += currPackagePrice;

                //стырили содержимое, возвращаем пустую посылку.
                return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), emptyPackage(stolenPackage));
            }
        }
        //если не письмо с посылкой, то возвращаем дальше.
        return mail;
    }

    /**
     * Возвращает пустую посылку вместо той, что стырили.
     * @param initPackage
     * @return
     */
    private Package emptyPackage(Package initPackage) {
        return new Package("stones instead of " + initPackage.getContent(), 0);
    }
}