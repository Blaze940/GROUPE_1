package fr.esgi.groupe1;

public class CleanRecipient {
    public void execute(Recipient recipient) {
        Karcher karcher = Karcher.getInstance();
        karcher.cleanRecipient(recipient);
    }

}
