package fr.esgi.groupe1;

import java.util.List;

public class FillFood {

    private final Recipients recipients;
    private final Foods foods;

    public FillFood(Recipients recipients, Foods foods) {
        this.recipients = recipients;
        this.foods = foods;
    }

    public void fill() {
        var recipientList = recipients.findAll();
        Food food = foods.find();
        Karcher karcher = Karcher.getINSTANCE();

        var recipientsToClean =
                recipientList.stream().filter(recipient -> !recipient.isCleaned()).toList();

        var recipientsCleaned = recipientsToClean.stream().map(karcher::cleanRecipient).toList();

        recipientsCleaned.forEach(
                recipient -> {
                    recipient.fill(food);
                }
        );
    }
}
