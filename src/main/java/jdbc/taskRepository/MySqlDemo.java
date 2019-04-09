package jdbc.taskRepository;

import jdbc.model.City;
import jdbc.repository.CityRepository;
import jdbc.taskRepository.ownRep.OwnCityRep;

import java.util.List;
import java.util.Scanner;

public class MySqlDemo {
    public static void main(String[] args) {
        CityRepository cityRepository = new CityRepository();
        OwnCityRep ownCityRep = new OwnCityRep();
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = true;
        City city = new City();

        while (isLoggedIn) {
            System.out.println("Hello User, please advise what you want to do:\n" +
                    "1.Add City \n" +
                    "2.Delete City\n" +
                    "3.View City\n" +
                    "4.Exit");
            int customerInput = scanner.nextInt();
            if (customerInput == 1) {
                System.out.println("Please enter City to add, we need CityName, CountryCode, District and Population ");
                String inputCity = scanner.next();
                System.out.println("Please enter CountryCode");
                String inputCountry = scanner.next();
                System.out.println("Please enter District");
                String inputDistrict = scanner.next();
                System.out.println("Please enter Population");
                int inputPopulation = scanner.nextInt();
                city.setName(inputCity);
                city.setCountryCode(inputCountry);
                city.setDistrict(inputDistrict);
                city.setPopulation(inputPopulation);
                ownCityRep.addCity(city);
            } else if (customerInput == 2) {
                System.out.println("please enter city name to delete");
                String deleteCityInput = scanner.next();
                ownCityRep.deleteCityByName(deleteCityInput);
                System.out.println("City deleted");
            } else if (customerInput == 3) {
                List<City> cities = ownCityRep.viewCity();
                printCities(cities);
            } else {
                isLoggedIn = false;
                System.out.println("Have a nice day");
            }
        }
    }

    private static void printCities(List<City> cities) {
        System.out.println("Name \t  Country Code \t District \t Population");
        for (City city : cities) {
            System.out.print(city.getName() + "\t\t");
            System.out.print(city.getCountryCode() + "\t\t");
            System.out.print(city.getDistrict() + "\t\t");
            System.out.println(city.getPopulation());
        }
    }
}