/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author triamus
 */
public class ObjUsuario {
    
    //El nombre se realizara una modificacion de nombre + Apellido
    private int id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private int estado; //0(inactivo) y 1(Activo)
    private int rol; //0(Admin), 1(Mesero), 3(Otro)
    private String clave;
    
    
    //contructores

    public ObjUsuario() {
    }

    public ObjUsuario(int id, String cedula, String nombre, String apellidos, String direccion, String telefono, String correo, String nomUsuario, String clave, int estado, int rol) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
    }
    
    //getters

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    

    public String getNombre() {
        return nombre;
    }

    public int getRol() {
        return rol;
    }

    public String getTelefono() {
        return telefono;
    }
    
    
    //Setters

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
