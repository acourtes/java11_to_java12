package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.AmountToPay;
import fr.arolla.greenmove.scooter.Scooter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class User {

    private int id;

    // First way to write switch
    AmountToPay getAmountToTakeScooter(final Scooter scooter) {
        var amount = switch (scooter.getOperatingCountry()) {
            case FR, CH: break 1;
            case GB: break 2;
            case US, SG: break 3;
        };

        return new AmountToPay().setAmount(amount).setCurrency(scooter.getCurrency());
    }

    // Second way to write in more functional style the switch
    AmountToPay getAmountToTakeScooter2(final Scooter scooter) {
        var amount = switch (scooter.getOperatingCountry()) {
            case FR, CH -> 1;
            case GB -> 2;
            case US, SG -> 3;
        };

        return new AmountToPay().setAmount(amount).setCurrency(scooter.getCurrency());
    }

}
