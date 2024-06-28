package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.CannotCleanAlreadyCleanedRecipientException;
import fr.esgi.groupe1.exception.CannotCleanFilledRecipientException;
import fr.esgi.groupe1.exception.NegativeLevelException;

import java.util.Objects;

public class Recipient {
    private final static double MIN_THRESHOLD_LIQUID = 0.05;
    private final static double MIN_THRESHOLD_SOLID = 0.1;
    private final static double MAX_THRESHOLD_LIQUID = 0.9;
    private final static double MAX_THRESHOLD_SOLID = 1;

    private RecipientId recipientId;
    private Food food;
    private double currentLevel;
    private boolean isCleaned;

    public Recipient(double currentLevel, Food food, RecipientId recipientId) {
        if (currentLevel < 0) {
            throw new NegativeLevelException();
        }

        this.currentLevel = currentLevel;
        this.food = food;
        this.recipientId = recipientId;
        this.isCleaned = false;
    }

    public void drain() {
        this.currentLevel = 0;
        this.food = null;
    }

    public boolean isFilled() {
        if (hasNoAliment()) {
            return false;
        }
        if (alimentIsLiquid()) {
            return currentLevel >= MIN_THRESHOLD_LIQUID;
        }
        return currentLevel >= MIN_THRESHOLD_SOLID;
    }

    public void fill(Food food) {
        if (isFilled()) {
            return;
        }
        this.food = food;
        if (alimentIsLiquid()) {
            currentLevel = MAX_THRESHOLD_LIQUID;
        } else {
            currentLevel = MAX_THRESHOLD_SOLID;
        }
    }

    public boolean alimentIsLiquid() {
        return food.isLiquid();
    }

    public boolean hasNoAliment() {
        return food == null;
    }

    public void clean() {
        if (isFilled()) {
            throw new CannotCleanFilledRecipientException();
        }
        if (this.isCleaned) {
            throw new CannotCleanAlreadyCleanedRecipientException();
        }

        this.isCleaned = true;
    }

    public boolean isCleaned() {
        return isCleaned;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipient recipient = (Recipient) o;

        return Objects.equals(recipientId, recipient.recipientId);
    }

    @Override
    public int hashCode() {
        return recipientId != null ? recipientId.hashCode() : 0;
    }
}
