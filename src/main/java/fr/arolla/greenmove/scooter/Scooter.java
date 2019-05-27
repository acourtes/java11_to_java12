package fr.arolla.greenmove.scooter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Scooter {

    // Why using Unix end of line here ?
    // => Because the indent method uses \n by default...
    private final static String lineFeed = "\n";

    private int id;
    private Provider provider;
    private Country operatingCountry;
    private int mileage;

    // We use here indent new method in String class from Java 12
    String displayScooterInfo() {
        final var firstLine = "Scooter properties : " + lineFeed;
        final var secondLine = "* Id : " + this.getId();
        final var thirdLine = "* Provider : " + this.getProvider();
        final var lastLine = "* Operating country : " + this.getOperatingCountry().getCountryName();

        return firstLine +
                secondLine.indent(1) +
                thirdLine.indent(2) +
                lastLine.indent(3);
    }

    // We use here transform new method in String class from Java 12
    // The case is very simple here but you can chain calls
    String displayAlert(String message) {
        final var genericMessage = "Alert from your %s scooter : ";
        final var providerName = this.getProvider().toString().toLowerCase();

        return message.transform(m -> String.format(genericMessage, providerName) + m + "!");
    }
}
