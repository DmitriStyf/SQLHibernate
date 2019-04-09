package jdbc.repository;

import jdbc.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private String connectionString = "jdbc:mysql://localhost:3306/world";
    private String userName = "root";
    private String passWord = "Daywalker1";

    public List<City> getCities() {

        List<City> cities = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString, userName, passWord);
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM City LIMIT 50"))
        {
            // System.out.println("Connected to DB");
            // step 2 create statement using the connection
            // step 3. Execute SQL statement
            // step 4. Loop through the result and print
            cities = parseResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
    public void addCity(City city) {
        String sqlCity = "INSERT INTO city (name, countryCode, district, population) VALUES(?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, passWord);
             PreparedStatement prepStmt = conn.prepareStatement(sqlCity))
        {
            prepStmt.setString(1, city.getName());
            prepStmt.setString(2, city.getCountryCode());
            prepStmt.setString(3, city.getDistrict());
            prepStmt.setInt(4, city.getPopulation());

            int rowsAffected = prepStmt.executeUpdate();
            System.out.println("We inserted " + rowsAffected + " rows.");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCity(City city) {
        try (Connection conn = DriverManager.getConnection(connectionString, userName, passWord);
             Statement stmt = conn.createStatement())
        {
            String deleteString = "DELETE FROM city WHERE name = 'TESTCITY'";
            int rowsAffected = stmt.executeUpdate(deleteString);
            System.out.println("We deleted " + rowsAffected + " rows.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<City> getByCityName(String name) {
        List<City> cities = new ArrayList<>();
        String sqlQuery = "SELECT * FROM city WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, passWord);
             PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            cities = parseResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public List<City> parseResultSetToList(ResultSet resultSet) throws SQLException {
        List<City> cities = new ArrayList<>();
        while (resultSet.next()) {
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountryCode(resultSet.getString("countryCode"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getInt("population"));

            cities.add(city);
        }
        return cities;
    }
}