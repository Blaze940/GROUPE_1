package fr.esgi.groupe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class RecipientTest {

    @Test
    void should_throw_recipient_is_empty_execption_when_the_recipient_is_empty() {
        // GIVEN
        Recipient recipient = new Recipient(0);

        // WHEN & THEN
        assertThrowsExactly(RecipientIsEmptyExecption.class, recipient::isFill);
    }

}