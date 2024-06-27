package fr.esgi.groupe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class RecipientTest {

    @Test
    void should_throw_recipient_is_empty_exception_when_the_recipient_is_instantiate_with_negative_value() {
        assertThrowsExactly(RecipientIsEmptyExecption.class, () -> new Recipient(-1));
    }

}