package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.NoRecipientToClean;

public class Karcher {
    //Singleton
    private static Karcher instance = null;

    private Karcher() {
    }

    public static Karcher getInstance() {
        if(instance == null) {
            instance = new Karcher();
        }
        return instance;
    }

    //pattern : Command


    public static void cleanRecipient(Recipient recipient) {
        if(recipient == null) {
            throw new NoRecipientToClean();
        }
            recipient.drain();
            washWater(recipient);
    }

    private static void washWater(Recipient recipient) {
        //System.out.println("Test Washing water");
    }

    public static void setInstance(Karcher karcher) {
        instance = karcher;
    }

}
