package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.NoRecipientToClean;

public class Karcher {
    private static Karcher INSTANCE;

    private Karcher() {
    }

    public static Karcher getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Karcher();
        }
        return INSTANCE;
    }

    public Recipient cleanRecipient(Recipient recipient) {
        if (recipient == null) {
            throw new NoRecipientToClean();
        }
        recipient.drain();
        recipient.clean();
        return recipient;
    }
}
