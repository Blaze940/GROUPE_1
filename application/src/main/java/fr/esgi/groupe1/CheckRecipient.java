package fr.esgi.groupe1;

public class CheckRecipient {

    public boolean isVerified(Recipient recipient) {
        return recipient.isFill();
    }
}
