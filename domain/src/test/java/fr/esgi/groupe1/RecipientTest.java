package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.NegativeLevelException;
import fr.esgi.groupe1.exception.NegativeWeightException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RecipientTest {

    @Test
    void should_drain_all_contents_when_drain_is_called() {
        // GIVEN
        Recipient recipient = new Recipient(10, 5, new Nourriture(true, "SomeFood"), new RecipientId(UUID.randomUUID()));

        // WHEN
        recipient.drain();

        // THEN
        assertEquals(0, recipient.getCurrentLevel());
        assertEquals(0, recipient.getPoids());
        assertNull(recipient.getNourriture());
    }

    @Test
    void should_return_true_when_isFilled_is_called_and_recipient_is_filled() {
        // GIVEN
        Recipient recipient = new Recipient(10, 5, new Nourriture(false, "Batbout"), new RecipientId(UUID.randomUUID()));

        // WHEN & THEN
        assertTrue(recipient.isFilled());
    }

    @Test
    void should_return_false_when_isFilled_is_called_and_recipient_is_empty() {
        // GIVEN
        Recipient recipient = new Recipient(0, 0, null, new RecipientId(UUID.randomUUID()));

        // WHEN & THEN
        assertFalse(recipient.isFilled());
    }

    @Test
    void should_throw_negativeLevelException_when_recipient_is_created_with_negative_level() {
        // GIVEN, WHEN & THEN
        assertThrows(NegativeLevelException.class, () -> new Recipient(-1, 5, new Nourriture(false, "Attiéké"), new RecipientId(UUID.randomUUID())));
    }

    @Test
    void should_throw_negativeWeightException_when_recipient_is_created_with_negative_weight() {
        // GIVEN, WHEN & THEN
        assertThrows(NegativeWeightException.class, () -> new Recipient(10, -1, new Nourriture(true, "Bissap"), new RecipientId(UUID.randomUUID())));
    }
}