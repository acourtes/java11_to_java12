package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.AmountToPay;
import fr.arolla.greenmove.scooter.Scooter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class User {

    private int id;

    // TODO by using the new switch enhancement in Java 12
    // You will have to activate experimental preview feature to use it !
    // You can use 2 different ways to rewrite this method
    AmountToPay getAmountToTakeScooter(final Scooter scooter) {
        Integer amount = null;
        switch (scooter.getOperatingCountry()) {
            case FR:
            case CH:
                amount = 1;
                break;
            case GB:
                amount = 2;
                break;
            case US:
            case SG:
                amount = 3;
                break;
        }

        return new AmountToPay().setAmount(amount).setCurrency(scooter.getCurrency());
    }

}
