package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.AmountToPay;
import fr.arolla.greenmove.scooter.MileageStatistics;
import fr.arolla.greenmove.scooter.Scooter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

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

        return new AmountToPay().setAmount(amount).setCurrency(scooter.getOperatingCountry().getCurrency());
    }

    // TODO use new Java 12 feature to return in a single instruction the mileage statistics
    MileageStatistics getMileageStatics(List<Scooter> scooters) {
        final var totalMileage = scooters.stream().mapToInt(Scooter::getMileage).sum();
        final var averageMileage = scooters.stream().collect(Collectors.averagingInt(Scooter::getMileage));

        return new MileageStatistics(totalMileage, averageMileage);
    }

}
