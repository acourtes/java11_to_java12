package fr.arolla.greenmove.human;

import fr.arolla.greenmove.scooter.AmountToPay;
import fr.arolla.greenmove.scooter.Country;
import fr.arolla.greenmove.scooter.Currency;
import fr.arolla.greenmove.scooter.Provider;
import fr.arolla.greenmove.scooter.Scooter;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserTest {

    private SoftAssertions should;
    private User user;

    @Before
    public void setUp() {
        should = new SoftAssertions();
        user = new User(1);
    }

    @After
    public void finalizeTest() {
        should.assertAll();
    }

    @Test
    public void take_a_scooter_in_France_should_cost_1_EUR() {
        final Scooter frenchScooter = new Scooter(1, Provider.BIRD, Country.FR, 0);

        final AmountToPay amount = user.getAmountToTakeScooter(frenchScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(1);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.EUR);
    }

    @Test
    public void take_a_scooter_in_Switzerland_should_cost_1_CHF() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.CH, 0);

        final AmountToPay amount = user.getAmountToTakeScooter(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(1);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.CHF);
    }

    @Test
    public void take_a_scooter_in_Great_Britain_should_cost_2_GBP() {
        final Scooter britishScooter = new Scooter(1, Provider.BIRD, Country.GB, 0);

        final AmountToPay amount = user.getAmountToTakeScooter(britishScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(2);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.GBP);
    }

    @Test
    public void take_a_scooter_in_the_USA_should_cost_3_USD() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.US, 0);

        final AmountToPay amount = user.getAmountToTakeScooter(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(3);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.USD);
    }

    @Test
    public void take_a_scooter_in_Singapore_should_cost_3_SGD() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.SG, 0);

        final AmountToPay amount = user.getAmountToTakeScooter(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(3);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.SGD);
    }

    @Test
    public void should_compute_correctly_statistics_for_a_list_of_scooters() {
        final var scooter = new Scooter(1, Provider.BIRD, Country.FR, 5);
        final var scooter2 = new Scooter(1, Provider.BIRD, Country.FR, 10);
        final var scooter3 = new Scooter(1, Provider.BIRD, Country.FR, 15);

        final var mileageStatistics = user.getMileageStatics(List.of(scooter, scooter2, scooter3));

        should.assertThat(mileageStatistics.getAverage()).isEqualTo(10);
        should.assertThat(mileageStatistics.getSum()).isEqualTo(30);
    }

}