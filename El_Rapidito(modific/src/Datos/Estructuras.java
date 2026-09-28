/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
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
    public void agregarCaja(ObjCaja miCaja){
        listaCajas.add(miCaja);
    }
    
    //modificar
    public void editarCaja(int indice, ObjCaja miCaja){
        listaCajas.set(indice, miCaja);
    }
    
    //borraar
    public void quitarCaja(int indice){
        listaCajas.remove(indice);
    }
    
    //Devolver lista
    public static ArrayList<ObjCaja> listarCajas() {
        return new ArrayList<>(listaCajas);
    }
    
    
    public void mostrarCajas(){
        System.out.println("-------------------------------");
        for (int i = 0; i <listaCajas.size(); i++) {
            System.out.println(listaCajas.get(i).getNombre());
        }
    }
    
    /*----------------------------------------------------------
    |       Metodos de trabajo de Operacion Cajas             |
    |                                                         |
    ----------------------------------------------------------*/
    

    
    
}
