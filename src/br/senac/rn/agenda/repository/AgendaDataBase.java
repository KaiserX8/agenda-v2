package br.senac.rn.agenda.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgendaDataBase {


    private final String DRIVER = "org.mariadb.jdbc.driver";
    private final String DATASBASE = "db_agenda-v2";
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mariadb://localhost:3306/" + DATASBASE;

    private Connection connection = null;

    public Boolean openConnection() {
        try {
            Class.forName(DRIVER); //dusca o driver de conexao
            connection = DriverManager.getConnection(URL, USER, PASSWORD); //busca uma conexao valida
            return true;
        } catch (ClassNotFoundException error) {
            System.out.println("Erro: " + error);
        } catch (SQLException error) {
            System.out.println("Erro: " + error);
        }
        return false;
    }

    public Boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (SQLException error) {
            System.out.println("Erro: " + error);
        }
        return false;
    }

    public Connection getConnection() {
        return connection;
    }

}