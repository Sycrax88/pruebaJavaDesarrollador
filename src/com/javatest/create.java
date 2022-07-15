package com.javatest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://@localhost/new_schema1", "root", "root");
             Statement st = con.createStatement();) {
            String query = "INSERT INTO PROGRAMAS(ID,Name,Facultad,Sede) values(2,'Ingenieria Electronica','Ingenieria','Principal')";
            int count = st.executeUpdate(query);
            if (count == 0) {
                System.out.println("No se insertó.");
            } else {
                System.out.println("Se insertó exitosamente.");
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
    }
}
