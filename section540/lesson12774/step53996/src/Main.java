import stepikClasses.*;
import stepikClasses.Package;

import java.util.logging.*;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("main");

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(100);
        MailService variousWorkers[] = {
                thief,
                spy,
                inspector
        };

        /*
          Передаём плохому сотруднику почты сторонних лиц, которым он будет сливать письма.
          Эти люди в свою очередь будут обрабатывать письма в зависимости от реализации метода proccessMail().
         */
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable correspondence[] = {
                new MailMessage("dog", "cat", "Hi!"),
                new MailMessage("cat", "dog", "Hi! What do you want?"),
                new MailMessage("cat", ConstNames.AUSTIN_POWERS, "Dog is writing me again. Can you do something?"),
                new MailMessage(ConstNames.AUSTIN_POWERS, "cat", "I'll do my best."),
                new MailPackage(ConstNames.AUSTIN_POWERS, "dog", new Package("bomb", 300)),
                new MailMessage("dog", ConstNames.AUSTIN_POWERS, "Why do you send me stones?"),
                new MailPackage(ConstNames.AUSTIN_POWERS, "dog", new Package("banned substance", 99)),
                new MailPackage(ConstNames.AUSTIN_POWERS, "dog", new Package("tiny bomb", 90)),
                new MailMessage(ConstNames.AUSTIN_POWERS, "cat", "Done."),
        };
        for (AbstractSendable sendable : correspondence) {
            try {

                /* здесь сотрудник почты сливает корреспонденцию третьим лицам */
                worker.processMail(sendable);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        }
    }
}