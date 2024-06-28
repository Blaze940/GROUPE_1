package fr.esgi.groupe1;

import java.util.List;

public class FakeRecipients implements Recipients {
    @Override
    public List<Recipient> findAll() {
        return List.of(
                new Recipient(0, new Food(false, "Bissap"), new RecipientId()),
                new Recipient(1, new Food(true, "Water"), new RecipientId())
        );
    }
}
