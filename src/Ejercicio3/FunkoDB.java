package Ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class FunkoDB {

    public static String[] loadDatabaseProperties(){

        Properties properties = new Properties();
        String[] credentials = new String[3];

        try (InputStream input = Files.newInputStream(Paths.get("credenciales.txt"))) {

            properties.load(input);

            credentials[0] = properties.getProperty("db.url");
            credentials[1] = properties.getProperty("db.user");
            credentials[2] = properties.getProperty("db.password");

        } catch (IOException e) {

            System.out.println("Error.");

        }

        return credentials;

    }

    public static void demostracion(String[] credentials, String sentencia) {

        try(Connection con = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
            PreparedStatement statement = con.prepareStatement(sentencia)){

            ResultSet resultados = statement.executeQuery();

            while (resultados.next()){

                String nombre = resultados.getString("nombre");

                System.out.println(nombre);

            }

            resultados.close();

        } catch (SQLException e) {

            System.out.println("Error.");

        }

    }

    public static void showFunkosFrom2010(String[] credentials, String sentencia) {

        System.out.println("Funkos de 2010:");

        try(Connection con = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
            PreparedStatement statement = con.prepareStatement(sentencia)){

            ResultSet resultados = statement.executeQuery();

            while (resultados.next()){

                String nombre = resultados.getString("nombre");

                System.out.println(nombre);

            }

            resultados.close();

        } catch (SQLException e) {

            System.out.println("Error.");

        }

    }

    public static void showFunkosWithA(String[] credentials, String sentencia){

        System.out.println("Funkos que empiezan por A:");

        try(Connection con = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
            PreparedStatement statement = con.prepareStatement(sentencia)){

            ResultSet resultados = statement.executeQuery();

            while (resultados.next()){

                String nombre = resultados.getString("nombre");

                char[] letters = nombre.toCharArray();

                if (letters[0] == 'A'){

                    System.out.println(nombre);

                }

            }

            resultados.close();

        } catch (SQLException e) {

            System.out.println("Error.");

        }

    }

    public static void showOriginalPackage(String[] credentials, String sentencia) {

        System.out.println("Funkos de 2010:");

        try(Connection con = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
            PreparedStatement statement = con.prepareStatement(sentencia)){

            ResultSet resultados = statement.executeQuery();

            while (resultados.next()){

                String nombre = resultados.getString("nombre");

                System.out.println(nombre);

            }

            resultados.close();

        } catch (SQLException e) {

            System.out.println("Error.");

        }

    }

}
