package fr.arolla.greenmove.scooter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScooterTest {

    @Test
    public void must_display_nicely_scooter_properties() {
        final Scooter scooter = new Scooter(1, Provider.BOLT, Country.FR, Currency.EUR);
        final String lineFeed = System.getProperty("line.separator");

        final String expectedInfos = "Scooter properties : " + lineFeed
                + " * Id : 1" + lineFeed
                + "  * Provider : BOLT" + lineFeed
                + "   * Operating country : France" + lineFeed;

        final String scooterInfo = scooter.displayScooterInfo();

        assertThat(scooterInfo).isEqualTo(expectedInfos);
    }

    @Test
    public void must_display_alert() {
        final Scooter scooter = new Scooter(1, Provider.BIRD, Country.CH, Currency.CHF);
        final String message = "Be careful, you're approaching the lake";
        final String expectedAlert = "Alert from your bird scooter : " + message + "!";

        final String alert = scooter.displayAlert(message);

        assertThat(alert).isEqualTo(expectedAlert);
    }

}