/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author triamus
 */
public class Estructuras {
    //--Arrar list almacenamiento
    static ArrayList<ObjCaja> listaCajas = new ArrayList<>();
    static ArrayList<ObjOpCajas> listaOpCajas = new ArrayList<>();
    static ArrayList<ObjUsuario> listaUsuarios = new ArrayList<>();
    //constructores
    public Estructuras() {
    }
    
    //mmetodos de trabajo-> Insertar,Modificar,Eliminar,Consultar
    
    /*----------------------------------------------------------
    |              Metodos de trabajo de usuario              |
    |                                                         |
    ----------------------------------------------------------*/
    //agregar user
    public void agregarUsuario(ObjUsuario miUsuario){
        listaUsuarios.add(miUsuario);
    }
    
    //modificar user
    public void editarUsuario(int indice, ObjUsuario miUsuario){
        listaUsuarios.set(indice, miUsuario);
    }
    
    //eliminar
    public void quitarUsuario(int indece){
        listaUsuarios.remove(indece);
    }
    
    
    //devilver lista
    public static ArrayList<ObjUsuario> listarUsuarios() {
        return new ArrayList<>(listaUsuarios);
    }
    
    
    /*----------------------------------------------------------
    |              Metodos de trabajo de Cajas              |
    |                                                         |
    ----------------------------------------------------------*/

    //Metodos de trabajo de Cajas
    //agregar
    // 1. AGREGAR CAJA
    public void agregarCaja(ObjCaja miCaja) {
        String sql = "INSERT INTO Caja(nombre, ubicacion) VALUES(?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, miCaja.getNombre());
            pstmt.setString(2, miCaja.getUbicacion());
            pstmt.executeUpdate();
            System.out.println("Caja guardada en SQLite con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al guardar caja: " + e.getMessage());
        }
    }
    
    //modificar
    // Modificar caja en SQLite usando su ID
public void editarCaja(ObjCaja miCaja) {
    String sql = "UPDATE Caja SET nombre = ?, ubicacion = ? WHERE id = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, miCaja.getNombre());
        pstmt.setString(2, miCaja.getUbicacion());
        pstmt.setInt(3, miCaja.getId());

        int filas = pstmt.executeUpdate();
        if (filas > 0) {
            System.out.println("Caja actualizada con éxito.");
        }

    } catch (SQLException e) {
        System.err.println("Error al editar caja: " + e.getMessage());
    }
}
    
    //borraar
    public void quitarCaja(int id) {
    String sql = "DELETE FROM Caja WHERE id = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Error al borrar caja: " + e.getMessage());
    }
}
    
    //Devolver lista
    public static ArrayList<ObjCaja> listarCajas() {
        ArrayList Lista = new ArrayList();
        
        //pasar lo que queremos extraer
        String sql = "SELECT id,nombre,ubicacion FROM Caja";
        
        try(Connection conn = Conexion.conectar(); 
                Statement mensajero = conn.createStatement();
                ResultSet resultado = mensajero.executeQuery(sql)) {
            
            //recorremos fila por fila de la tabal sql
            while (resultado.next()) {                
                ObjCaja miCaja = new ObjCaja(
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("ubicacion")
                );
                //lo agregamos a la array
                Lista.add(miCaja);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar cajas: " + e.getMessage());
        }
        //devolvemos la lista con el objeto de la base sql
        return Lista;
    }
    

    public DefaultListModel mostrarCajas() {
    DefaultListModel miModelo = new DefaultListModel();
    String sql = "SELECT id, nombre, ubicacion FROM Caja";

    try (Connection conn = Conexion.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            String fila = rs.getInt("id") + " - " + 
                          rs.getString("nombre") + " - " + 
                          rs.getString("ubicacion");
            miModelo.addElement(fila);
        }

    } catch (SQLException e) {
        System.err.println("Error al cargar modelo de cajas: " + e.getMessage());
    }

    return miModelo;
}
    
    /*----------------------------------------------------------
    |       Metodos de trabajo de Operacion Cajas             |
    |                                                         |
    ----------------------------------------------------------*/
    

    
    
}
