package util;

import hibernate.model.City;

import java.util.List;

public class CityUtil {
    public static void printCities(List<City> cities) {
        printCityHeader();
        for(City city : cities) {
            printCity(city);
        }
    }

    public static void printCityHeader() {
        System.out.printf("%-20s %-20s %-20s %-20s \n","Name", "Country Code", "District", "Population");
    }

    public static void printCity(City city) {
        System.out.printf("%-20s ",city.getName());
        System.out.printf("%-20s ",city.getCountryCode());
        System.out.printf("%-20s ",city.getDistrict());
        System.out.println(city.getPopulation());
    }
}
