package fr.esgi.groupe1;

public class Recipient {

    private static final double MIN_THREESHOLD = 0.05;
    private final double currentLevel;

    public Recipient(double currentLevel) {
        this.currentLevel = currentLevel;
    }

    public boolean isFill() {
        if (currentLevel == 0) {
            throw new RecipientIsEmptyExecption();
        }

        return currentLevel >= MIN_THREESHOLD;
    }
}
