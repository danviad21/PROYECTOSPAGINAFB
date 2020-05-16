package com.alan.carritosuplementos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection con;

    private Conexion() {
    }

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/bd_carrito?serverTimezone=UTC";
        String user = "root";
        String pass = "odavid";

        if (con == null || con.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
                if (con != null) {
                    System.out.println(con.getCatalog());
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error en conexion" + e.getMessage());
            }
        }
        return con;
    }

    public static void cerrarConexion() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
