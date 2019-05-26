package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.Provider;
import fr.arolla.greenmove.scooter.Scooter;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
class Juicer {
    // A juicer can just work for 2 providers max at the same time
    private List<Provider> allowedProviders;

    // TODO use new Java 12 feature to return in a single instruction the sorted scooter by provider
    // when there are 2 providers
    List<List<Scooter>> sortRawScootersByProvider(List<Scooter> rawScooters) {
        if (allowedProviders.size() == 2) {
            final var firstProviderScooters = rawScooters.stream()
                    .collect(
                            Collectors.filtering(scooter -> scooter.getProvider() == allowedProviders.get(0), Collectors.toList()));

            final var secondProviderScooters = rawScooters.stream()
                    .collect(
                            Collectors.filtering(scooter -> scooter.getProvider() == allowedProviders.get(1), Collectors.toList()));

            return List.of(firstProviderScooters, secondProviderScooters);
        }

        return List.of(rawScooters);
    }
}
