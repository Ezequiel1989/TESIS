/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author matias
 */
public class Localidad {

    private long idlocalidad;
    private String localidad;
    private Empleado oempleado;

    /**
     * @return the idlocalidad
     */
    public long getIdlocalidad() {
        return idlocalidad;
    }

    /**
     * @param idlocalidad the idlocalidad to set
     */
    public void setIdlocalidad(long idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the oempleado
     */
    public Empleado getOempleado() {
        return oempleado;
    }

    /**
     * @param oempleado the oempleado to set
     */
    public void setOempleado(Empleado oempleado) {
        this.oempleado = oempleado;
    }
}
