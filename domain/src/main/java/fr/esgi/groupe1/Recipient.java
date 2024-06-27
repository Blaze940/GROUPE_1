package fr.esgi.groupe1;

public class Recipient {

    private static final double MIN_THREESHOLD = 0.05;
    private final double currentLevel;

    public Recipient(double currentLevel) {
        if (currentLevel < 0) {
            throw new RecipientIsEmptyExecption();
        }
        this.currentLevel = currentLevel;
    }

    public boolean isFill() {
        return currentLevel >= MIN_THREESHOLD;
    }
}
