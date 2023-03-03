package org.moviecharactersapi;

import org.moviecharactersapi.Models.Character;
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

    //private String sql = "SELECT * FROM character;";

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
    public List<Character> findAll() {
        String sql = "SELECT * FROM character;";
        List<Character> characters = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {

                Character character = new Character(
                );
                characters.add(character);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public Character findById(Integer id) {
        String sql = "SELECT * FROM character WHERE character_id = ? ";
        Character character = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            // Execute statement

            ResultSet result = statement.executeQuery();
            // Handle result
            while (result.next()) {

                character = new Character(

                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return character;
    }

    @Override
    public List<Character>  findByName(String name) {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT * FROM character WHERE first_name ~* ? OR last_name ~* ? ";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, name);
            // Execute statement

            ResultSet result = statement.executeQuery();
            // Handle result
            while (result.next()) {

                Character character = new Character(

                );
                characters.add(character);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<Character>  findAllPage(int limit, int offset) {
        //sql += limit;
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT * FROM character WHERE first_name ~* ? OR last_name ~* ? ";
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            // Execute statement
            ResultSet result = statement.executeQuery();
            // Handle result
            while(result.next()) {

                Character character = new Character(

                );
                characters.add(character);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }



    @Override
    public int insert(Character  object) {
        return 0;
    }

    @Override
    public int update(Character  object) {
        return 0;
    }

    @Override
    public int delete(Character  object) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    public void printNice(Character object) {
        StringBuilder str = new StringBuilder();
        str.append(object.getClass().getSimpleName()+": ");
        str.append("\n\tDatabase id: "+object.getId());

        System.out.println(str);
    }

    public void printNice(List<Character> characters) {
        characters.forEach(this::printNice);

    }
}
