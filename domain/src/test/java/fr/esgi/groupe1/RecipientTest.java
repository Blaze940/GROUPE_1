package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.CannotCleanAlreadyCleanedRecipientException;
import fr.esgi.groupe1.exception.CannotCleanFilledRecipientException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipientTest {

    @Test
    void should_drain() {
        // Given
        Recipient recipient = new Recipient(0.5, new Food(false, "food"), new RecipientId());

        // When
        recipient.drain();

        // Then
        assertEquals(0, recipient.getCurrentLevel());
    }

    // isFilled method tests with liquid food
    @Test
    void should_be_filled_with_liquid_threshold_level() {
        // Given
        Recipient recipient = new Recipient(0.1, new Food(true, "water"), new RecipientId());

        // When
        boolean result = recipient.isFilled();

        // Then
        assertTrue(result);
    }

    @Test
    void should_not_be_filled_with_liquid_threshold_level() {
        // Given
        Recipient recipient = new Recipient(0.049, new Food(true, "water"), new RecipientId());

        // When
        boolean result = recipient.isFilled();

        // Then
        assertFalse(result);
    }

    // isFilled method tests with solid food
    @Test
    void should_be_filled_with_solid_threshold_level() {
        // Given
        Recipient recipient = new Recipient(0.15, new Food(false, "Seeds"), new RecipientId());

        // When
        boolean result = recipient.isFilled();

        // Then
        assertTrue(result);
    }

    @Test
    void should_not_be_filled_with_solid_threshold_level() {
        // Given
        Recipient recipient = new Recipient(0.09, new Food(false, "Seeds"), new RecipientId());

        // When
        boolean result = recipient.isFilled();

        // Then
        assertFalse(result);
    }

    // fill method tests with liquid food
    @Test
    void should_fill_with_liquid_when_not_filled() {
        // Given
        Recipient recipient = new Recipient(0.04, new Food(true, "water"), new RecipientId());

        // When
        recipient.fill(new Food(true, "water"));

        // Then
        assertTrue(recipient.isFilled());
    }

    @Test
    void should_not_fill_with_liquid_when_already_filled() {
        // Given
        Recipient recipient = new Recipient(0.9, new Food(true, "water"), new RecipientId());

        // When
        recipient.fill(new Food(true, "water"));

        // Then
        assertEquals(0.9, recipient.getCurrentLevel());
        assertTrue(recipient.isFilled());
    }

    // fill method tests with solid food
    @Test
    void should_fill_with_solid_when_not_filled() {
        // Given
        Recipient recipient = new Recipient(0.09, new Food(false, "Seeds"), new RecipientId());

        // When
        recipient.fill(new Food(false, "Seeds"));

        // Then
        assertTrue(recipient.isFilled());
    }

    @Test
    void should_not_fill_with_solid_when_already_filled() {
        // Given
        Recipient recipient = new Recipient(1, new Food(false, "Seeds"), new RecipientId());

        // When
        recipient.fill(new Food(false, "Seeds"));

        // Then
        assertEquals(1, recipient.getCurrentLevel());
        assertTrue(recipient.isFilled());
    }

    // alimentIsLiquid method tests
    @Test
    void should_aliment_be_liquid() {
        // Given
        Recipient recipient = new Recipient(0.5, new Food(true, "water"), new RecipientId());

        // When
        boolean result = recipient.alimentIsLiquid();

        // Then
        assertTrue(result);
    }

    @Test
    void should_not_aliment_be_liquid() {
        // Given
        Recipient recipient = new Recipient(0.5, new Food(false, "Seeds"), new RecipientId());

        // When
        boolean result = recipient.alimentIsLiquid();

        // Then
        assertFalse(result);
    }

    // hasNoAliment method tests
    @Test
    void should_be_recipient_without_aliment() {
        // Given
        Recipient recipient = new Recipient(0.5, null, new RecipientId());

        // When
        boolean result = recipient.hasNoAliment();

        // Then
        assertTrue(result);
    }

    @Test
    void should_not_be_recipient_without_aliment() {
        // Given
        Recipient recipient = new Recipient(0.5, new Food(false, "Seeds"), new RecipientId());

        // When
        boolean result = recipient.hasNoAliment();

        // Then
        assertFalse(result);
    }

    // clean method tests
    @Test
    void should_clean_when_not_filled_recipient() {
        // Given
        Recipient recipient = new Recipient(0, new Food(true, "water"), new RecipientId());

        // When
        recipient.clean();

        // Then
        assertTrue(recipient.isCleaned());
    }

    @Test
    void should_not_clean_when_filled_recipient() {
        // Given
        Recipient recipient = new Recipient(0.9, new Food(true, "water"), new RecipientId());

        // When
        Exception exception = assertThrows(CannotCleanFilledRecipientException.class, recipient::clean);

        // Then
        assertNotNull(exception);
        assertFalse(recipient.isCleaned());
    }

    @Test
    void should_not_clean_when_already_cleaned() {
        // Given
        Recipient recipient = new Recipient(0, new Food(true, "water"), new RecipientId());
        recipient.clean(); // recipient is now cleaned

        // When
        Exception exception = assertThrows(CannotCleanAlreadyCleanedRecipientException.class, recipient::clean);

        // Then
        assertNotNull(exception);
        assertTrue(recipient.isCleaned());
    }
}