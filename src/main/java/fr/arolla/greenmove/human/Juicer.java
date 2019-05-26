package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.Provider;
import fr.arolla.greenmove.scooter.Scooter;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
class Juicer {
    // A juicer can just work for 2 providers at the same time
    private List<Provider> allowedProviders;

    // We use here the new Collectors teeing which merge 2 downstream collectors into one
    List<List<Scooter>> sortRawScootersByProvider(List<Scooter> rawScooters) {
        if (allowedProviders.size() == 2) {
            return rawScooters.stream()
                    .collect(Collectors.teeing(
                            Collectors.filtering(scooter -> scooter.getProvider() == allowedProviders.get(0), Collectors.toList()),
                            Collectors.filtering(scooter -> scooter.getProvider() == allowedProviders.get(1), Collectors.toList()),
                            (List<Scooter> list1, List<Scooter> list2) -> List.of(list1, list2)
                    ));
        }

        return List.of(rawScooters);
    }
}
