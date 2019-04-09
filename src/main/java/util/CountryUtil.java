package util;

import hibernate.model.Country;

import java.util.List;

public class CountryUtil {
    public static void printCountries(List<Country> countries) {
        countries.forEach(CountryUtil::printCountry);
    }
    public static void printCountry(Country country) {
        System.out.printf("%-6s | ",country.getCode());
        System.out.printf("%-50s | ",country.getName());
        System.out.printf("%-20s | ",country.getContinent());
        System.out.printf("%-26s | ",country.getRegion());
        System.out.printf("%-6s | ",country.getIndepYear());
        System.out.printf("%-45s | ",country.getGovernmentForm());
        System.out.printf("%-4s ",country.getLifeExpectancy());
        System.out.println(country.getPopulation());

        CityUtil.printCities(country.getCities());

    }
}
