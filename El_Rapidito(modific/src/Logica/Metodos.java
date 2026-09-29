/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Datos.Estructuras;
import Datos.ObjCaja;
import Datos.Conexion;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author triamus
 */
public class Metodos {
    
    //almacen de datos
    Estructuras almacen = new Estructuras();
    
    
    
    public int existeCaja(int id){
        int resultado = -1;
        
        String sql = "SELECT id FROM Caja WHERE id = ?";
        
        try(Connection conn = Conexion.conectar(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            
            try(ResultSet rs =  pstmt.executeQuery()) {
                if(rs.next()){
                    
                    resultado = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar caja: " + e.getMessage());
        }
        
       
        return resultado;
    }
    
    
    public ObjCaja buscarCajaPorId(int id) {
    String sql = "SELECT id, nombre, ubicacion FROM Caja WHERE id = ?";
    ObjCaja caja = null;

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, id);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                caja = new ObjCaja(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("ubicacion")
                );
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar caja por ID: " + e.getMessage());
    }

    return caja;
}
    
    
}
