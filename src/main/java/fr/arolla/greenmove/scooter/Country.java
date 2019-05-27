package fr.arolla.greenmove.scooter;

public enum Country {
    FR("France", Currency.EUR), CH("Switzerland", Currency.CHF),
    GB("Great Britain", Currency.GBP), US("United States", Currency.USD),
    SG("Singapore", Currency.SGD);

    private String countryName;
    private Currency currency;

    Country(String countryName, Currency currency) {
        this.countryName = countryName;
        this.currency = currency;
    }

    public String getCountryName() {
        return countryName;
    }

    public Currency getCurrency() {
        return currency;
    }
}
