import stepikClasses.MailPackage;
import stepikClasses.MailService;
import stepikClasses.Sendable;

/**
 * Inspector – Инспектор, который следит за запрещенными и
 * украденными посылками и бьет тревогу в виде исключения,
 * если была обнаружена подобная посылка. Если он заметил
 * запрещенную посылку с одним из запрещенных содержимым
 * ("weapons" и "banned substance"), то он бросает
 * IllegalPackageException. Если он находит посылку,
 * состоящую из камней (содержит слово "stones"), то
 * тревога прозвучит в виде StolenPackageException.
 * Оба исключения вы должны объявить самостоятельно в
 * виде непроверяемых исключений.
 */
public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;

            String packageContent = mailPackage.getContent().getContent();

            if (packageContent.contains("stones")) {
                throw new StolenPackageException();
            }
            if (packageContent.contains(ConstNames.BANNED_SUBSTANCE) || packageContent.contains(ConstNames.WEAPONS)) {
                throw new IllegalPackageException();
            }
        }
        return mail;
    }
}