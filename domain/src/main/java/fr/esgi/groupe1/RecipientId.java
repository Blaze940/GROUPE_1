package fr.esgi.groupe1;

import java.util.Objects;
import java.util.UUID;

public class RecipientId {

    private final UUID value;

    public RecipientId() {
        this.value = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipientId that = (RecipientId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
