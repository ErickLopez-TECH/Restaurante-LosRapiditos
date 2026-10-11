/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Datos.Estructuras;
import Datos.ObjCaja;
import Datos.Conexion;
import Datos.ObjOpCajas;
import Datos.ObjUsuario;
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
    
    //para ops cajas
    public int existeOpCaja(int id){
        int resultado = -1;
        
        String sql = "SELECT id FROM OpCaja WHERE id = ?";
        
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
    
    
    public ObjOpCajas buscarOpPorId(int id) {
    // 1. Apuntar a la tabla OpCaja y seleccionar todos sus campos
    String sql = "SELECT id, idCaja, fechaApertura, montoApertura, fechaCierre, montoCierre, estado FROM OpCaja WHERE id = ?";
    ObjOpCajas opCaja = null;

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, id);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                // Si guardaste las fechas como texto (String), puedes parsearlas o manejarlas acorde.
                // Aquí asumimos el mapeo de los tipos que definiste en ObjOpCajas:
                
                int idProceso = rs.getInt("id");
                int idCaja = rs.getInt("idCaja");
                
                // Conversión segura de fecha desde el texto almacenado en SQLite
                java.util.Date fechaApertura = null;
                String fAperStr = rs.getString("fechaApertura");
                if (fAperStr != null && !fAperStr.isEmpty()) {
                    fechaApertura = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(fAperStr);
                }
                
                Double montoApertura = rs.getDouble("montoApertura");
                
                java.util.Date fechaCierre = null;
                String fCierStr = rs.getString("fechaCierre");
                if (fCierStr != null && !fCierStr.isEmpty()) {
                    fechaCierre = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(fCierStr);
                }
                
                Double montoCierre = rs.getDouble("montoCierre");
                int estado = rs.getInt("estado");

                // Creamos el objeto con el constructor completo
                opCaja = new ObjOpCajas(idProceso, idCaja, fechaApertura, montoApertura, fechaCierre, montoCierre, estado);
            }
        }
    } catch (SQLException | java.text.ParseException e) {
        System.err.println("Error al buscar operación de caja por ID: " + e.getMessage());
    }

    return opCaja;
}
    
    
    
    //user
    public ObjUsuario buscarUserPorId(int id) {
    String sql = "SELECT id, cedula, nombre, apellido, direccion, telefono, correo, nombreUser, clave, estado, rol FROM Usuario WHERE id = ?";
        ObjUsuario user = null;

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, id);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                user = new ObjUsuario(
                    rs.getInt("id"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("nombreUser"),
                    rs.getString("clave"),
                    rs.getInt("estado"),
                    rs.getInt("rol")
                );
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar caja por ID: " + e.getMessage());
    }

    return user;
}
    
    //logeo 
    public ObjUsuario validarLogin(String nombreUser, String clave) {
    String sql = "SELECT rol, estado, nombre FROM Usuario WHERE nombreUser = ? AND clave = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, nombreUser);
        pstmt.setString(2, clave);
        
        try (ResultSet resultado = pstmt.executeQuery()) {
            if (resultado.next()) {
                // Encontró al usuario: devolvemos un objeto ligero solo con lo indispensable
                ObjUsuario sesion = new ObjUsuario();
                sesion.setRol(resultado.getInt("rol"));
                sesion.setEstado(resultado.getInt("estado"));
                sesion.setNombre(resultado.getString("nombre"));
                return sesion;
            }
        }
    } catch (SQLException e) {
        System.err.println("Error en login: " + e.getMessage());
    }
    
    return null; // Credenciales inválidas
}
    
}
