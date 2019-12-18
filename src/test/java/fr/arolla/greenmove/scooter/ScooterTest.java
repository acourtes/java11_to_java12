package fr.arolla.greenmove.scooter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScooterTest {

    @Test
    public void must_display_nicely_scooter_properties() {
        final Scooter scooter = new Scooter(1, Provider.BOLT, Country.FR, 0);
        final String lineFeed = "\n";

        final String expectedInfos = "Scooter properties : " + lineFeed
                + " * Id : 1" + lineFeed
                + "  * Provider : BOLT" + lineFeed
                + "   * Operating country : France" + lineFeed;

        final String scooterInfo = scooter.displayScooterInfo();

        assertThat(scooterInfo).isEqualTo(expectedInfos);
    }

    @Test
    public void must_display_alert() {
        final Scooter scooter = new Scooter(1, Provider.BIRD, Country.CH, 0);
        final String message = "Be careful, you're approaching the lake";
        final String expectedAlert = "Alert from your bird scooter : " + message + "!";

        final String alert = scooter.displayAlert(message);

        assertThat(alert).isEqualTo(expectedAlert);
    }

}