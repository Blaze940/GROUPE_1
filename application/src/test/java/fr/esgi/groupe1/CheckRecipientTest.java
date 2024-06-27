package fr.esgi.groupe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckRecipientTest {

    private CheckRecipient checkRecipient;

    @BeforeEach
    void setUp() {
        checkRecipient = new CheckRecipient();
    }

    @Test
    void should_return_true_when_the_recipient_level_is_over_the_min_threshold() {
        // GIVEN
        Recipient recipient = new Recipient(0.06);

        // WHEN & THEN
        assertTrue(checkRecipient.isVerified(recipient));
    }

    @Test
    void should_return_false_when_the_recipient_level_is_under_the_min_threshold() {
        // GIVEN
        Recipient recipient = new Recipient(0.04);

        // WHEN & THEN
        assertFalse(checkRecipient.isVerified(recipient));
    }
}