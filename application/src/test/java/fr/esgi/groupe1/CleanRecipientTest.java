package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.NoRecipientToClean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CleanRecipientTest {

    private CleanRecipient cleanRecipient;
    private Karcher karcher;
    private Recipient recipient;

    @BeforeEach
    void setUp() {
        cleanRecipient = new CleanRecipient();
        karcher = mock(Karcher.class);
        recipient = mock(Recipient.class);
        Karcher.setInstance(karcher);
    }

    @Test
    void should_clean_recipient_when_execute_is_called() {
        cleanRecipient.execute(recipient);
        verify(karcher, times(1)).cleanRecipient(recipient);
    }

    @Test
    void should_not_clean_recipient_when_recipient_is_null() {
        cleanRecipient.execute(null);
        verify(karcher, times(0)).cleanRecipient(any());
    }

    @Test
    void should_throw_exception_when_null_recipient_provided() {
        doThrow(NoRecipientToClean.class).when(karcher).cleanRecipient(null);
        assertThrows(NoRecipientToClean.class, () -> cleanRecipient.execute(null));
    }
}