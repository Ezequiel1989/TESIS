/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Ezequiel
 */
public class Registro {
    private long idregistro;
    private Date registro;
    private String foto;
    private Empleado empleado;

    public long getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(long idregistro) {
        this.idregistro = idregistro;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
