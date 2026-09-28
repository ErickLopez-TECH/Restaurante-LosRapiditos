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
    
    private int idProceso;
    private int idCaja;
    private int tipoProceso; //--Combo Box-->Apertura o Cierre
    private Date fecha;
    private Double monto;//Con cuanta plata inicie

    public ObjOpCajas() {
    }

    public ObjOpCajas(int idProceso, int idCaja, int tipoProceso, Date fecha, Double monto) {
        this.idProceso = idProceso;
        this.idCaja = idCaja;
        this.tipoProceso = tipoProceso;
        this.fecha = fecha;
        this.monto = monto;
    }
    
    //getters

    public Date getFecha() {
        return fecha;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public Double getMonto() {
        return monto;
    }

    public int getTipoProceso() {
        return tipoProceso;
    }
    
    //setters

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setTipoProceso(int tipoProceso) {
        this.tipoProceso = tipoProceso;
    }
    
}
