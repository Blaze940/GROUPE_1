package fr.esgi.groupe1;

import java.util.Objects;

public class Nourriture {
    private final boolean isLiquid;
    private final String name;

    public Nourriture(boolean isLiquid, String name) {
        this.isLiquid = isLiquid;
        this.name = name;
    }


    public boolean isLiquid() {
        return isLiquid;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nourriture that = (Nourriture) o;
        return isLiquid == that.isLiquid && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLiquid, name);
    }
}
