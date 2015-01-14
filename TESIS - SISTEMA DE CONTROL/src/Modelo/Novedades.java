/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author matias
 */
public class Novedades
{
    
    private Date fechainicio;
    private Date fechafin;
    private String Observaciones;
    private Empleado oempleado;
    private long idnovedades;

    /**
     * @return the fechainicio
     */
    public Date getFechainicio() {
        return fechainicio;
    }

    /**
     * @param fechainicio the fechainicio to set
     */
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * @return the fechafin
     */
    public Date getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    /**
     * @return the Observaciones
     */
    public String getObservaciones() {
        return Observaciones;
    }

    /**
     * @param Observaciones the Observaciones to set
     */
    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    /**
     * @return the ousuario
     */


    /**
     * @return the idnovedades
     */
    public long getIdnovedades() {
        return idnovedades;
    }

    /**
     * @param idnovedades the idnovedades to set
     */
    public void setIdnovedades(long idnovedades) {
        this.idnovedades = idnovedades;
    }

    public Empleado getOempleado() {
        return oempleado;
    }

    public void setOempleado(Empleado oempleado) {
        this.oempleado = oempleado;
    }
    
    
            
    
}
