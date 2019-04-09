package jdbc;

import jdbc.model.City;
import jdbc.repository.CityRepository;


import java.util.List;

public class MySqlJDBC {
    public static void main(String[] args) {

        CityRepository cityRepository = new CityRepository();
       // List<City> cities = cityRepository.getByCityName("paris");
       // printCities(cities);
        City testNameCity = new City();
        testNameCity.setName("TESTCITY");
        testNameCity.setCountryCode("IND");
        testNameCity.setDistrict("COOOl");
        testNameCity.setPopulation(65);

        List<City> cities = cityRepository.getByCityName("TESTCITY");
        printCities(cities);
        cityRepository.addCity(testNameCity);

       // cityRepository.deleteCity(null);
        //cityRepository.getByCityName(null);
    }

    public static void printCities(List<City> cities) {
        System.out.println("Name \t  Country Code \t District \t Population");
        for(City city : cities) {
            System.out.print(city.getName() + "\t\t");
            System.out.print(city.getCountryCode() + "\t\t");
            System.out.print(city.getDistrict() + "\t\t");
            System.out.println(city.getPopulation());
        }
    }
}