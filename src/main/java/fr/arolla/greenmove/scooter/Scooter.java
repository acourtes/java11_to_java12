package fr.arolla.greenmove.scooter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Scooter {

    private final static String lineFeed = System.getProperty("line.separator");

    private int id;
    private Provider provider;
    private Country operatingCountry;
    private Currency currency;

    // TODO by using new method in String class from Java 12
    String displayScooterInfo() {
        final String space = " ";

        return "Scooter properties : " + lineFeed
                + space + "* Id : " + this.getId() + lineFeed +
                space.repeat(2) +
                "* Provider : " + this.getProvider() + lineFeed +
                space.repeat(3) +
                "* Operating country : " + this.getOperatingCountry().getCountryName() + lineFeed;
    }

    // TODO by using new method in String class from Java 12
    String displayAlert(String message) {
        final String genericMessage = "Alert from your %s scooter : ";
        final String providerName = this.getProvider().toString().toLowerCase();

        return String.format(genericMessage, providerName) + message + "!";
    }
}
