/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ezequiel
 */
public class Empleado {
    private long idempleados;
    private String nombre;
    private String apellido;
    private String domicilio;
    private List<Registro> reg = new ArrayList<Registro>();
    private long telefono;
    private Localidad olocalidad;

    public long getIdempleados() {
        return idempleados;
    }

    public void setIdempleados(long idempleado) {
        this.idempleados = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Registro> getReg() {
        return reg;
    }

    public void setReg(List<Registro> reg) {
        this.reg = reg;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Localidad getOlocalidad() {
        return olocalidad;
    }

    public void setOlocalidad(Localidad olocalidad) {
        this.olocalidad = olocalidad;
    }
}
