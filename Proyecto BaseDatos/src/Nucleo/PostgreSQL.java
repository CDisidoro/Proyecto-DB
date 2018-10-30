package Nucleo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQL {

    static Connection conexion = null;
    static Statement stmt = null;
    String driver = "org.postgresql.Driver";
    String usuario = "postgres";                                                            //USUARIO GLOBAL
    String clave = "1234";                                                                       //CLAVE DE PRUEBA LOCAL
    String direccion = "jdbc:postgresql://localhost:5432/";             //DIRECCION DE PRUEBA LOCAL
    String nombreDB = "Proyecto DB";                                                //DB DE PRUEBA LOCAL
    //String direccion = "jdbc:postgresql://25.63.154.16:5432/";  //DIRECCION HOST (RONALD) - ENCENDER HAMACHI O SINO NO SERVIRA
    //String nombreDB = "";                                                                  //DB HOST (RONALD)
    //String clave = "1234567899";                                                      //CLAVE HOST (RONALD)

    public int open() {
        int conexito = 0;
        //IMPORTA EL DRIVER POSTGRESQL
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        //CONECTAR A LA BASE DE DATOS
        try {
            conexion = DriverManager.getConnection(direccion + nombreDB, usuario, clave);
            conexito = 1;
            stmt = (Statement) conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Conexion con la base de datos fallida: " + ex);
        }
        return conexito;
    }

    public static void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int actualizar(String sql) {
        int exito = 0;
        if (open() == 1) {
            try {
                stmt.executeUpdate(sql);
                exito = 1;
            } catch (SQLException e) {
                System.out.println(e);
            }
            close();
        }
        return exito;
    }

    public ResultSet consultar(String sql) {
        ResultSet resultado = null;
        if (open() == 1) {
            try {
                resultado = stmt.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println(e);
            }
            close();
        }
        return resultado;
    }
}
