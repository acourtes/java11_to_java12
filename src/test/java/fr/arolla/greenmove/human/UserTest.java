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

public class UserTest {

    private SoftAssertions should;

    @Before
    public void setUp() {
        should = new SoftAssertions();
    }

    @After
    public void finalizeTest() {
        should.assertAll();
    }

    @Test
    public void take_a_scooter_in_France_should_cost_1_EUR() {
        final Scooter frenchScooter = new Scooter(1, Provider.BIRD, Country.FR, Currency.EUR);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter(frenchScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(1);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.EUR);
    }

    @Test
    public void take_a_scooter_in_Switzerland_should_cost_1_CHF() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.CH, Currency.CHF);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(1);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.CHF);
    }

    @Test
    public void take_a_scooter_in_Great_Britain_should_cost_2_GBP() {
        final Scooter britishScooter = new Scooter(1, Provider.BIRD, Country.GB, Currency.GBP);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter(britishScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(2);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.GBP);
    }

    @Test
    public void take_a_scooter_in_the_USA_should_cost_3_USD() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.US, Currency.USD);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(3);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.USD);
    }

    @Test
    public void take_a_scooter_in_Singapore_should_cost_3_SGD() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.SG, Currency.SGD);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(3);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.SGD);
    }

    @Test
    public void take_a_scooter_in_France_should_cost_1_EUR_with_second_method() {
        final Scooter frenchScooter = new Scooter(1, Provider.BIRD, Country.FR, Currency.EUR);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter2(frenchScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(1);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.EUR);
    }

    @Test
    public void take_a_scooter_in_Switzerland_should_cost_1_CHF_with_second_method() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.CH, Currency.CHF);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter2(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(1);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.CHF);
    }

    @Test
    public void take_a_scooter_in_Great_Britain_should_cost_2_GBP_with_second_method() {
        final Scooter britishScooter = new Scooter(1, Provider.BIRD, Country.GB, Currency.GBP);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter2(britishScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(2);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.GBP);
    }

    @Test
    public void take_a_scooter_in_the_USA_should_cost_3_USD_with_second_method() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.US, Currency.USD);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter2(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(3);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.USD);
    }

    @Test
    public void take_a_scooter_in_Singapore_should_cost_3_SGD_with_second_method() {
        final Scooter swissScooter = new Scooter(1, Provider.BIRD, Country.SG, Currency.SGD);
        final User user = new User(1);

        final AmountToPay amount = user.getAmountToTakeScooter2(swissScooter);

        Assertions.assertThat(amount).isNotNull();
        should.assertThat(amount.getAmount()).isEqualTo(3);
        should.assertThat(amount.getCurrency()).isEqualByComparingTo(Currency.SGD);
    }

}