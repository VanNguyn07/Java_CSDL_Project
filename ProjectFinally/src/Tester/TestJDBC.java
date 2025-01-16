package Tester;

import Database.ConnectionJDBC;

import java.sql.Connection;

public class TestJDBC {
    public static void main(String[] args) {
        Connection connection = ConnectionJDBC.getConnection();
    }
}
