package jdbc.taskRepository.ownRep;

import jdbc.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnCityRep {

    private String connectionString = "jdbc:mysql://localhost:3306/world";
    private String userName = "root";
    private String passWord = "Daywalker1";

    public void addCity(City city) {
        String sqlQuery = "INSERT INTO city (name, countryCode, district, population) VALUES(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, passWord);
             PreparedStatement prepStmt = conn.prepareStatement(sqlQuery)) {

            prepStmt.setString(1, city.getName());
            prepStmt.setString(2, city.getCountryCode());
            prepStmt.setString(3, city.getDistrict());
            prepStmt.setInt(4, city.getPopulation());
            int weTest = prepStmt.executeUpdate();
            System.out.println("City added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCityByName(String name) {
        String sqlQuery = "DELETE FROM city WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, passWord);
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, name);
            int weTest = stmt.executeUpdate();
            System.out.println("City deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<City> viewCity() {
        List<City> cities = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionString, userName, passWord);
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM city LIMIT 50")) {
            while (resultSet.next()) {
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountryCode(resultSet.getString("countryCode"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getInt("population"));

                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}