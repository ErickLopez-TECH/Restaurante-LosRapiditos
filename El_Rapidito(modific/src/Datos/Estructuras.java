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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
    public void agregarUser(ObjUsuario miuser) {
        String sql = "INSERT INTO Usuario(nombre, apellido,cedula,correo,nombreUser,telefono,direccion,estado,rol,clave) "
                + "VALUES(?, ?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, miuser.getNombre());
            pstmt.setString(2, miuser.getApellidos());
            pstmt.setString(3, miuser.getCedula());
            pstmt.setString(4, miuser.getCorreo());
            pstmt.setString(5, miuser.getNombreUser());
            pstmt.setString(6, miuser.getTelefono());
            pstmt.setString(7, miuser.getDireccion());
            pstmt.setInt(8, miuser.getEstado());
            pstmt.setInt(9, miuser.getRol());
            pstmt.setString(10, miuser.getClave());
            pstmt.executeUpdate();
            System.out.println("Usuario guardada en SQLite con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al guardar user: " + e.getMessage());
        }
    }
    
    //modificar user
    public void editarUser(ObjUsuario miUser) {
    String sql = "UPDATE Usuario SET nombre = ?, apellido = ?,cedula = ?,correo = ?,nombreUser = ?,telefono = ?,"
            + "direccion = ?, estado = ?, rol = ?,clave = ? WHERE id = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, miUser.getNombre());
            pstmt.setString(2, miUser.getApellidos());
            pstmt.setString(3, miUser.getCedula());
            pstmt.setString(4, miUser.getCorreo());
            pstmt.setString(5, miUser.getNombreUser());
            pstmt.setString(6, miUser.getTelefono());
            pstmt.setString(7, miUser.getDireccion());
            pstmt.setInt(8, miUser.getEstado());
            pstmt.setInt(9, miUser.getRol());
            pstmt.setString(10, miUser.getClave());
            pstmt.setInt(11, miUser.getId());
            
        int filas = pstmt.executeUpdate();
        if (filas > 0) {
            System.out.println("User actualizada con éxito.");
        }

    } catch (SQLException e) {
        System.err.println("Error al editar User: " + e.getMessage());
    }
}
    
    //eliminar
    public void quitarUser(int id) {
    String sql = "DELETE FROM Usuario WHERE id = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Error al borrar usuario: " + e.getMessage());
    }
}
    
    
    //devilver lista
    public static ArrayList<ObjUsuario> listarUser() {
    ArrayList<ObjUsuario> listaUsuarios = new ArrayList<>();
    String sql = "SELECT id, cedula, nombre, apellido, direccion, telefono, correo, nombreUser, clave, estado, rol FROM Usuario";
    
    // Usar try-with-resources asegura que Connection, Statement y ResultSet se cierren solos al terminar
    try (Connection conn = Conexion.conectar(); 
         Statement mensajero = conn.createStatement();
         ResultSet resultado = mensajero.executeQuery(sql)) {
        
        while (resultado.next()) {                
            ObjUsuario miUser = new ObjUsuario(
                resultado.getInt("id"),
                resultado.getString("cedula"),
                resultado.getString("nombre"),
                resultado.getString("apellido"),
                resultado.getString("direccion"),
                resultado.getString("telefono"),
                resultado.getString("correo"),
                resultado.getString("nombreUser"),
                resultado.getString("clave"),
                resultado.getInt("estado"),
                resultado.getInt("rol")
                
                    
            );
            listaUsuarios.add(miUser);
        }
        
    } catch (SQLException e) {
        System.err.println("Error al listar cajas: " + e.getMessage());
    }
    return listaUsuarios;
}
    
    public DefaultTableModel mostrarUser() {
    // 1. Definir los títulos de las columnas que coincidan con los datos de ObjCaja
    String[] titulo = {"ID", "Nombre", "Usuario","Cedula","Telefono","Correo","Rol","Estado"};
    
    // 2. Crear el modelo de la tabla pasando null para las filas iniciales y los títulos
    DefaultTableModel modelo = new DefaultTableModel(null, titulo);
    
    // 3. Obtener la lista llamando al método que consulta SQLite
    ArrayList<ObjUsuario> listaUserTemporal = listarUser();
    
    // 4. Recorrer la lista para extraer los datos y agregarlos como filas
    for (int i = 0; i < listaUserTemporal.size(); i++) {
        
        String rol = "";
        if (listaUserTemporal.get(i).getRol() == 0) {
            rol = "Admin";
        }else if(listaUserTemporal.get(i).getRol() == 1){
            rol = "Mesero";
        }else{
            rol = "Cocina";
        }
        
        String estado = "";
        if (listaUserTemporal.get(i).getEstado()== 0) {
            estado = "Activo";
        }else{
            estado = "Inactivo";
        }
        String[] fila = {
            String.valueOf(listaUserTemporal.get(i).getId()),
            listaUserTemporal.get(i).getNombre() + " "+ listaUserTemporal.get(i).getApellidos(),
            listaUserTemporal.get(i).getNombreUser(),
            listaUserTemporal.get(i).getCedula(),
            listaUserTemporal.get(i).getTelefono(),
            listaUserTemporal.get(i).getCorreo(),
            rol,
            estado
        };
        modelo.addRow(fila);
    }
    
    // 5. Retornar el modelo lleno
    return modelo;
    
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
    ArrayList<ObjCaja> Lista = new ArrayList<>();
    String sql = "SELECT id, nombre, ubicacion FROM Caja";
    
    // Usar try-with-resources asegura que Connection, Statement y ResultSet se cierren solos al terminar
    try (Connection conn = Conexion.conectar(); 
         Statement mensajero = conn.createStatement();
         ResultSet resultado = mensajero.executeQuery(sql)) {
        
        while (resultado.next()) {                
            ObjCaja miCaja = new ObjCaja(
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("ubicacion")
            );
            Lista.add(miCaja);
        }
        
    } catch (SQLException e) {
        System.err.println("Error al listar cajas: " + e.getMessage());
    }
    return Lista;
}
    
    public DefaultTableModel mostrarCajas() {
    // 1. Definir los títulos de las columnas que coincidan con los datos de ObjCaja
    String[] titulo = {"ID", "Nombre", "Ubicacion"};
    
    // 2. Crear el modelo de la tabla pasando null para las filas iniciales y los títulos
    DefaultTableModel modelo = new DefaultTableModel(null, titulo);
    
    // 3. Obtener la lista llamando al método que consulta SQLite
    ArrayList<ObjCaja> listaCajasTemporal = listarCajas();
    
    // 4. Recorrer la lista para extraer los datos y agregarlos como filas
    for (int i = 0; i < listaCajasTemporal.size(); i++) {
        String[] fila = {
            String.valueOf(listaCajasTemporal.get(i).getId()),
            listaCajasTemporal.get(i).getNombre(),
            listaCajasTemporal.get(i).getUbicacion()
        };
        modelo.addRow(fila);
    }
    
    // 5. Retornar el modelo lleno
    return modelo;
}
    
    

    
    
    /*----------------------------------------------------------
    |       Metodos de trabajo de Operacion Cajas             |
    |                                                         |
    ----------------------------------------------------------*/
    
    
    public void agregarOpCaja(ObjOpCajas miOpCaja) {
    String sql = "INSERT INTO OpCaja(idCaja, fechaApertura, montoApertura, fechaCierre, montoCierre, estado) VALUES(?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, miOpCaja.getIdCaja());
        
        // Formatear fechas como texto ya que en tu tabla las creaste como TEXT
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        pstmt.setString(2, sdf.format(miOpCaja.getFechApertura()));
        
        pstmt.setDouble(3, miOpCaja.getMontoApetura());
        
        // Validar si la fecha de cierre no es nula
        if (miOpCaja.getFechCierre() != null) {
            pstmt.setString(4, sdf.format(miOpCaja.getFechCierre()));
        } else {
            pstmt.setNull(4, java.sql.Types.VARCHAR);
        }
        
        pstmt.setDouble(5, miOpCaja.getMontoCierre());
        pstmt.setInt(6, miOpCaja.getEstado());

        pstmt.executeUpdate();
        System.out.println("Operación de caja guardada en SQLite con éxito.");

    } catch (SQLException e) {
        System.err.println("Error al guardar operación de caja: " + e.getMessage());
    }
}
    
    
    public void editarOpCaja(ObjOpCajas miOp) {
    String sql = "UPDATE OpCaja SET idCaja = ?, fechaApertura = ?, montoApertura = ?, fechaCierre = ?,"
            + "montoCierre = ?, estado = ? WHERE id = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        
        pstmt.setInt(1, miOp.getIdCaja());
        pstmt.setString(2, sdf.format(miOp.getFechApertura()));
        pstmt.setDouble(3,miOp.getMontoApetura());
        pstmt.setString(4,sdf.format(miOp.getFechCierre()));
        pstmt.setDouble(5, miOp.getMontoCierre());
        pstmt.setInt(6, miOp.getEstado());
        pstmt.setInt(7, miOp.getIdProceso());

        int filas = pstmt.executeUpdate();
        if (filas > 0) {
            System.out.println("Caja actualizada con éxito.");
        }

    } catch (SQLException e) {
        System.err.println("Error al editar caja: " + e.getMessage());
    }
}
    
    public void quitarOpCaja(int id) {
    String sql = "DELETE FROM OpCaja WHERE id = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Error al borrar la operacion caja: " + e.getMessage());
    }
}
    
    public static ArrayList<ObjOpCajas> listarOpCajas() {
    ArrayList<ObjOpCajas> Lista = new ArrayList<>();
    String sql = "SELECT id,idCaja, fechaApertura, montoApertura, fechaCierre,"
            + "montoCierre, estado FROM OpCaja";
    
    // Usar try-with-resources asegura que Connection, Statement y ResultSet se cierren solos al terminar
    try (Connection conn = Conexion.conectar(); 
         Statement mensajero = conn.createStatement();
         ResultSet resultado = mensajero.executeQuery(sql)) {
        
        while (resultado.next()) {
    // 1. Leer las fechas como String
    String fechaAperStr = resultado.getString("fechaApertura");
    String fechaCierStr = resultado.getString("fechaCierre");
    
    java.util.Date fechaApertura = null;
    java.util.Date fechaCierre = null;
    
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    
    try {
        if (fechaAperStr != null && !fechaAperStr.isEmpty()) {
            fechaApertura = sdf.parse(fechaAperStr);
        }
        if (fechaCierStr != null && !fechaCierStr.isEmpty()) {
            fechaCierre = sdf.parse(fechaCierStr);
        }
    } catch (java.text.ParseException e) {
        System.err.println("Error al parsear fechas: " + e.getMessage());
    }

    // 2. Construir el objeto con los tipos correctos
    ObjOpCajas miCaja = new ObjOpCajas(
        resultado.getInt("id"),
        resultado.getInt("idCaja"),
        fechaApertura, // ya convertido a java.util.Date
        resultado.getDouble("montoApertura"),
        fechaCierre,  // ya convertido a java.util.Date
        resultado.getDouble("montoCierre"),
        resultado.getInt("estado")
    );
    
    Lista.add(miCaja);
}
        
    } catch (SQLException e) {
        System.err.println("Error al listar cajas: " + e.getMessage());
    }
    return Lista;
}
    
    public DefaultTableModel mostrarOpCajas() {
    // 1. Definir los títulos de las columnas que coincidan con los datos de ObjCaja
    String[] titulo = {"ID", "Caja", "Fecha Apertura","Monto","Fecha Cierre","Monto","Estado"};
    
    // 2. Crear el modelo de la tabla pasando null para las filas iniciales y los títulos
    DefaultTableModel modelo = new DefaultTableModel(null, titulo);
    
    // 3. Obtener la lista llamando al método que consulta SQLite
    ArrayList<ObjOpCajas> listaOpCajasTemporal = listarOpCajas();
    
    // 4. Recorrer la lista para extraer los datos y agregarlos como filas
    for (int i = 0; i < listaOpCajasTemporal.size(); i++) {
    ObjOpCajas op = listaOpCajasTemporal.get(i);
    
    // Formateador para mostrar la fecha bonita en la tabla
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    
    String fechaAper = (op.getFechApertura() != null) ? sdf.format(op.getFechApertura()) : "";
    String fechaCier = (op.getFechCierre() != null) ? sdf.format(op.getFechCierre()) : "";
    
    // El orden debe coincidir exactamente con los 7 títulos de tus columnas
    String[] fila = {
        String.valueOf(op.getIdProceso()),     // 1. ID de la operación
        String.valueOf(op.getIdCaja()),        // 2. ID o número de la Caja
        fechaAper,                             // 3. Fecha Apertura
        String.valueOf(op.getMontoApetura()),  // 4. Monto Apertura
        fechaCier,                             // 5. Fecha Cierre
        String.valueOf(op.getMontoCierre()),   // 6. Monto Cierre
        String.valueOf(op.getEstado())         // 7. Estado (Abierta/Cerrada)
    };
    
    modelo.addRow(fila);
}
    
    // 5. Retornar el modelo lleno
    return modelo;
}
}
