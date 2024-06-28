package fr.esgi.groupe1;

import java.util.List;

public class FillFood {

    private final Recipients recipients;
    private final Foods foods;

    public FillFood(Recipients recipients, Foods foods) {
        this.recipients = recipients;
        this.foods = foods;
    }

    public List<Recipient> fill() {
        var recipientList = recipients.findAll();

        var recipientsToClean =
                recipientList.stream().filter(recipient -> !recipient.isCleaned()).toList();

        Karcher karcher = Karcher.getINSTANCE();
        var recipientsCleaned = recipientsToClean.stream().map(karcher::cleanRecipient).toList();

        Food food = foods.find();

        recipientsCleaned.forEach(
                recipient -> {
                    recipient.fill(food);
                }
        );
        return recipientsCleaned;
    }
}
