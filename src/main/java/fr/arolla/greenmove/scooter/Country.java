package fr.arolla.greenmove.scooter;

public enum Country {
    FR("France"), CH("Switzerland"),
    GB("Great Britain"), US("United States"),
    SG("Singapore");

    private String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
