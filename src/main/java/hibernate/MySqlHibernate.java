package hibernate;

import hibernate.model.City;
import hibernate.model.Country;
import hibernate.repository.CityRepository;
import hibernate.repository.CountryRepository;
import util.CityUtil;
import util.CountryUtil;

import java.util.ArrayList;
import java.util.List;

public class MySqlHibernate {
    public static void main(String[] args) {
        CityRepository cityRepository = new CityRepository();

        //City city = cityRepository.getCityById(250);
        //CityUtil.printCity(city);
        //cityRepository.updateCityName();
//        cityRepository.updateCityName(4104, "TEST CITY");
        CountryRepository countryRepository = new CountryRepository();
        //CountryUtil.printCountries(countryRepository.getCountries());

        Country country = countryRepository.getCountryByCode("ABW");
        country.setCode("AAA");
        countryRepository.addCountry(country);
        CountryUtil.printCountry(countryRepository.getCountryByCode("AAA"));


//        City city = new City();
//        city.setName("North Tallinn");
//        city.setCountryCode("EST");
//        city.setDistrict("Harju");
//        city.setPopulation(250);
//        cityRepository.addCity(city);
//
//        CityUtil.printCities(cityRepository.getCities());
//        cityRepository.deleteCity(4107);
        //cityRepository.updateCityName(4104, "North");
    }
}
