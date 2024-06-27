package fr.esgi.groupe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerifierRecipientTest {

    @Test
    void should_return_true_when_the_recipient_level_is_over_the_min_threshold() {
        Recipient recipient = new Recipient(0.04);
        VerifierRecipient verifierRecipient = getVerifierRecipient();
        assertFalse(verifierRecipient.isVerified(recipient));
    }

    @Test
    void should_return_false_when_the_recipient_level_is_under_the_min_threshold() {
        Recipient recipient = new Recipient(0.06);
        VerifierRecipient verifierRecipient = getVerifierRecipient();
        assertTrue(verifierRecipient.isVerified(recipient));
    }

    private VerifierRecipient getVerifierRecipient() {
        return new VerifierRecipient();
    }
}