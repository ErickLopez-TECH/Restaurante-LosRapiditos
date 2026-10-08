/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.Date;

/**
 *
 * @author triamus
 */
public class ObjOpCajas {
    
    private int idProceso;//
    private int idCaja;//
    private Date fechApertura;//
    private Double montoApetura;//Con cuanta plata inicie
    private Date fechCierre;
    private Double montoCierre;//Con cuanta plata cierre
    private int estado;

    public ObjOpCajas() {
    }
    
    
    

    public ObjOpCajas(int idProceso, int idCaja, Date fechApertura, Double montoApetura, Date fechCierre, Double montoCierre, int estado) {
        this.idProceso = idProceso;
        this.idCaja = idCaja;
        this.fechApertura = fechApertura;
        this.montoApetura = montoApetura;
        this.fechCierre = fechCierre;
        this.montoCierre = montoCierre;
        this.estado = estado;
    }
    
   //getters

    public int getEstado() {
        return estado;
    }

    public Date getFechApertura() {
        return fechApertura;
    }

    public Date getFechCierre() {
        return fechCierre;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public Double getMontoApetura() {
        return montoApetura;
    }

    public Double getMontoCierre() {
        return montoCierre;
    }
    
    //setters

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFechApertura(Date fechApertura) {
        this.fechApertura = fechApertura;
    }

    public void setFechCierre(Date fechCierre) {
        this.fechCierre = fechCierre;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public void setMontoApetura(Double montoApetura) {
        this.montoApetura = montoApetura;
    }

    public void setMontoCierre(Double montoCierre) {
        this.montoCierre = montoCierre;
    }
    
    
}
