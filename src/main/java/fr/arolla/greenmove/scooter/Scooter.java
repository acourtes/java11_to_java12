package fr.arolla.greenmove.scooter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Scooter {

    // Why using Unix end of line here ?
    private final static String lineFeed = "\n";

    private int id;
    private Provider provider;
    private Country operatingCountry;
    private int mileage;

    // TODO by using new method in String class from Java 12
    String displayScooterInfo() {
        final var space = " ";

        return "Scooter properties : " + lineFeed
                + space + "* Id : " + this.getId() + lineFeed +
                space.repeat(2) +
                "* Provider : " + this.getProvider() + lineFeed +
                space.repeat(3) +
                "* Operating country : " + this.getOperatingCountry().getCountryName() + lineFeed;
    }

    // TODO by using new method in String class from Java 12
    String displayAlert(String message) {
        final var genericMessage = "Alert from your %s scooter : ";
        final var providerName = this.getProvider().toString().toLowerCase();

        return String.format(genericMessage, providerName) + message + "!";
    }
}
