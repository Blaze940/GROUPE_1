package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.NoRecipientToClean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KarcherTest {

    @Test
    void should_clean_recipient_when_not_null() {
        // Given
        Karcher karcher = Karcher.getINSTANCE();
        Recipient recipient = new Recipient(0.5, new Food(true, "water"), new RecipientId());

        // When
        Recipient cleanedRecipient = karcher.cleanRecipient(recipient);

        // Then
        assertTrue(cleanedRecipient.isCleaned());
        assertEquals(0, cleanedRecipient.getCurrentLevel());
    }

    @Test
    void should_throw_exception_when_recipient_is_null() {
        // Given
        Karcher karcher = Karcher.getINSTANCE();

        // When
        Exception exception = assertThrows(NoRecipientToClean.class, () -> karcher.cleanRecipient(null));

        // Then
        assertNotNull(exception);
    }
}