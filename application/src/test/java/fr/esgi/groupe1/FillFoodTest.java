package fr.esgi.groupe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FillFoodTest {

    private FillFood fillFood;
    private FakeFoods fakeFoods;

    private FakeRecipients fakeRecipients;

    @BeforeEach
    void setUp() {
        fakeFoods = new FakeFoods();
        fakeRecipients = new FakeRecipients();
        fillFood = new FillFood(fakeRecipients, fakeFoods);
    }


    @Test
    void should_fill_recipients_with_food() {
        // GIVEN
        List<Recipient> recipientList = fakeRecipients.findAll();

        // WHEN
        fillFood.fill();


        for (Recipient recipient : recipientList) {
            assertFalse(recipient.isFilled());
        }
    }
}