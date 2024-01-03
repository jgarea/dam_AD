package Ejercicio3;

import java.sql.*;
/**
 *
 * @author Juan
 */
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String user = "root";
        String password = "admin";

        String sqlCrearCliente = "INSERT INTO cliente (dni, nombre) VALUES (?,?)";
        try(Connection con = DriverManager.getConnection(url,user,password);
        PreparedStatement ps = con.prepareStatement(sqlCrearCliente);) {
            System.out.println("Conexion exitosa");    
            ps.setString(1, "12345678A");
            ps.setString(2, "Juan");
            ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
