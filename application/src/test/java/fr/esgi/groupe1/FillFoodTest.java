package fr.esgi.groupe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FillFoodTest {

    private FakeFoods fakeFoods;

    private FakeRecipients fakeRecipients;

    private FillFood fillFood;

    @BeforeEach
    void setUp() {
        fakeFoods = mock(FakeFoods.class);
        fakeRecipients = mock(FakeRecipients.class);
        fillFood = new FillFood(fakeRecipients, fakeFoods);
    }

    @Test
    void should_fill_recipients_with_food() {
        // WHEN
        fillFood.fill();

        for (Recipient recipient : fakeRecipients.findAll()) {
            // THEN
            assertTrue(recipient.isFilled());
        }
    }
}