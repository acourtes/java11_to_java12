package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.Country;
import fr.arolla.greenmove.scooter.Provider;
import fr.arolla.greenmove.scooter.Scooter;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JuicerTest {

    @Test
    public void should_group_scooters_in_a_list_of_2_elements_when_there_are_2_providers() {
        final var allowedProviders = List.of(Provider.BIRD, Provider.LIME);
        final var scooter = new Scooter(1, Provider.BIRD, Country.FR, 0);
        final var scooter2 = new Scooter(2, Provider.BIRD, Country.FR, 0);
        final var scooter3 = new Scooter(3, Provider.LIME, Country.FR, 0);

        final var rawScooters = List.of(scooter, scooter2, scooter3);

        final var juicer = new Juicer().setAllowedProviders(allowedProviders);

        final var sortedScootersByProvider = juicer.sortRawScootersByProvider(rawScooters);

        assertThat(sortedScootersByProvider).isNotNull();
        assertThat(sortedScootersByProvider).hasSize(2);
        assertThat(sortedScootersByProvider.get(0)).hasSize(2);
        assertThat(sortedScootersByProvider.get(0).stream()
                .allMatch(s -> s.getProvider() == Provider.BIRD)).isTrue();
        assertThat(sortedScootersByProvider.get(1)).hasSize(1);
        assertThat(sortedScootersByProvider.get(1).stream()
                .allMatch(s -> s.getProvider() == Provider.LIME)).isTrue();
    }

    @Test
    public void should_group_scooters_in_a_list_when_there_is_only_1_provider() {
        final var allowedProviders = Collections.singletonList(Provider.BIRD);
        final var scooter = new Scooter(1, Provider.BIRD, Country.FR, 0);
        final var scooter2 = new Scooter(2, Provider.BIRD, Country.FR, 0);

        final var rawScooters = List.of(scooter, scooter2);

        final var juicer = new Juicer().setAllowedProviders(allowedProviders);

        final var sortedScootersByProvider = juicer.sortRawScootersByProvider(rawScooters);

        assertThat(sortedScootersByProvider).isNotNull();
        assertThat(sortedScootersByProvider).hasSize(1);
        assertThat(sortedScootersByProvider.get(0)).hasSize(2);
        assertThat(sortedScootersByProvider.get(0).stream()
                .allMatch(s -> s.getProvider() == Provider.BIRD)).isTrue();
    }
}