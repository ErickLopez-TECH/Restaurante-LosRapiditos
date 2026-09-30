/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    // 1. URL con configuración WAL y timeout para evitar SQLITE_BUSY
    private static final String URL = "jdbc:sqlite:sqlLite.db?busy_timeout=5000&journal_mode=WAL";
    
    // Variable para controlar que las tablas se creen solo una vez al iniciar
    private static boolean tablasCreadas = false;

    public static Connection conectar() {
        Connection conn = null;
        try {
            // 2. REGISTRO DEL DRIVER: Fuerza a Java a cargar la librería en memoria
            Class.forName("org.sqlite.JDBC");

            // Intenta conectar o crear el archivo sqlLite.db
            conn = DriverManager.getConnection(URL);
            
            // Solo verifica las tablas la primera vez que se abre la app
            if (!tablasCreadas) {
                crearTablasSiNoExisten(conn);
                tablasCreadas = true;
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el archivo JAR de SQLite en las Librerías: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con SQLite: " + e.getMessage());
        }
        return conn;
    }

    private static void crearTablasSiNoExisten(Connection conn) {
        String sqlCaja = "CREATE TABLE IF NOT EXISTS Caja ("
                       + "  id INTEGER PRIMARY KEY AUTOINCREMENT,"
                       + "  nombre TEXT NOT NULL,"
                       + "  ubicacion TEXT NOT NULL"
                       + ");";

        String sqlUsuario = "CREATE TABLE IF NOT EXISTS Usuario ("
                          + "  id INTEGER PRIMARY KEY AUTOINCREMENT,"
                          + "  nombre TEXT NOT NULL,"
                          + "  apellido TEXT NOT NULL,"
                          + "  cedula TEXT NOT NULL,"
                          + "  correo TEXT NOT NULL,"
                          + "  telefono TEXT NOT NULL,"
                          + "  direccion TEXT NOT NULL,"
                          + "  estado TEXT NOT NULL,"
                          + "  rol TEXT NOT NULL,"
                          + "  clave TEXT NOT NULL"
                          + ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCaja);
            stmt.execute(sqlUsuario);
        } catch (SQLException e) {
            System.err.println("Error al crear tablas: " + e.getMessage());
        }
    }
}