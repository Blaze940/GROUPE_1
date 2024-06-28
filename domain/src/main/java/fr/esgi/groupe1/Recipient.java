package fr.esgi.groupe1;

import fr.esgi.groupe1.exception.NegativeLevelException;
import fr.esgi.groupe1.exception.NegativeWeightException;

public class Recipient {
    private final static  double MIN_THREESHOLD_lIQUID = 0.05;
    private final static double MIN_THREESHOLD_SOLID = 0.1;
    private RecipientId recipientId;
    private double currentLevel;
    private Nourriture nourriture;
    private double poids;

    public Recipient(double currentLevel, double poids, Nourriture nourriture, RecipientId recipientId) {
        if (currentLevel < 0) {
            throw new NegativeLevelException();
        }
        if (poids < 0) {
            throw new NegativeWeightException();
        }

        this.poids = poids;
        this.currentLevel = currentLevel;
        this.nourriture = nourriture;
        this.recipientId = recipientId;
    }
    public void drain() {
        this.currentLevel = 0;
        this.poids = 0;
        this.nourriture = null;
    }

    public boolean isFilled() {
        if(hasNoAliment()) {
            return false;
        }
        if(alimentIsLiquid()){
            return currentLevel >= MIN_THREESHOLD_lIQUID;
        }
        return currentLevel >= MIN_THREESHOLD_SOLID;
    }

    public boolean alimentIsLiquid() { return nourriture.isLiquid();}

    public boolean hasNoAliment() {
        return nourriture == null;
    }

    public RecipientId getRecipientId() {
        return recipientId;
    }

    private void setRecipientId(RecipientId recipientId) {
        this.recipientId = recipientId;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    private void setCurrentLevel(double currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Nourriture getNourriture() {
        return nourriture;
    }

    public void setNourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }

    public double getPoids() {
        return poids;
    }

    private void setPoids(double poids) {
        this.poids = poids;
    }


}
