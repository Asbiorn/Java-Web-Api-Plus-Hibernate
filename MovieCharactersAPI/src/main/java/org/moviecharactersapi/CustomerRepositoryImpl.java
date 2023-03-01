package org.moviecharactersapi;

import org.retunes.Models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final String url;
    private final String username;
    private final String password;

    //private String sql = "SELECT * FROM customer;";

    public CustomerRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void test() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to Postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer;";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {

                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("country"),
                        result.getString("phone"),
                        result.getString("email")

                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(Integer id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ? ";
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            // Execute statement

            ResultSet result = statement.executeQuery();
            // Handle result
            while (result.next()) {

                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("country"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer>  findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer WHERE first_name ~* ? OR last_name ~* ? ";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, name);
            // Execute statement

            ResultSet result = statement.executeQuery();
            // Handle result
            while (result.next()) {

                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("country"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Customer>  findAllPage(int limit, int offset) {
        sql += limit;
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {

                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("country"),
                        result.getString("phone"),
                        result.getString("email")

                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }



    @Override
    public int insert(Customer  object) {
        return 0;
    }

    @Override
    public int update(Customer  object) {
        return 0;
    }

    @Override
    public int delete(Customer  object) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    public void printNice(Customer object) {
        StringBuilder str = new StringBuilder();
        str.append(object.getClass().getSimpleName()+": ");
        str.append("\n\tDatabase id: "+object.id());
        str.append("\n\t"+object.first_name());
        str.append(" "+object.last_name());
        str.append("\n\t"+""+object.country());
        str.append("\n\t"+""+object.postal_code());
        str.append("\n\t"+""+object.city());
        str.append("\n\t"+""+object.phone());
        str.append("\n\t"+""+object.email());
        System.out.println(str);
    }

    public void printNice(List<Customer> customers) {
        customers.forEach(this::printNice);

    }
}
