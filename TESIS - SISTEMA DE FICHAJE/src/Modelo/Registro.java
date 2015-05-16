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
public class Registro {

    private long idregistros;
    private String dia;
    private String hora;
    private Empleado empleado;

    public long getIdregistros() {
        return idregistros;
    }

    public void setIdregistros(long idregistro) {
        this.idregistros = idregistro;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Registro() {

    }

    ;
    
    public Registro(String dia, String hora, Empleado emp) {
        this.setDia(dia);
        this.setHora(hora);
        this.setEmpleado(emp);
    }

    ;
    
    public Registro(String dia, String hora) {
        this.setDia(dia);
        this.setHora(hora);

    }

    ;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
