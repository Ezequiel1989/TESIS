/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ezequiel
 */
public class Localidad {

    private long idlocalidades;
    private String localidad;

    /**
     * @return the idlocalidad
     */
    public long getIdlocalidades() {
        return idlocalidades;
    }

    /**
     * @param idlocalidad the idlocalidad to set
     */
    public void setIdlocalidades(long idlocalidad) {
        this.idlocalidades = idlocalidad;
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

    // CONSTRUCTORES
    public Localidad() {

    }

    ;
    
    public Localidad(long i, String loc) {
        this.setIdlocalidades(i);
        this.setLocalidad(loc);
    }

    ;
        public Localidad(String loc) {
        this.setLocalidad(loc);
    }
;

}
