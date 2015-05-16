/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.EmpleadoDAO;
import Modelo.Empleado;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Ezequiel
 */
public class EmpleadoControladora {

    EmpleadoDAO emp = new EmpleadoDAO();

    public void guardaEmpleado(Empleado empleado) throws HibernateException {
        emp.guardaEmpleado(empleado);
    }

    public void actualizaEmpleado(Empleado empleado) throws HibernateException {
        emp.actualizaEmpleado(empleado);
    }

    public void eliminaEmpleado(Empleado empleado) throws HibernateException {
        emp.eliminaEmpleado(empleado);
    }

    public Empleado obtenEmpleado(long idEmpleado) throws HibernateException {
        return emp.obtenEmpleado(idEmpleado);
    }

    public Empleado obtenEmpleadoDNI(long documento) throws HibernateException {
        return emp.obtenEmpleado(documento);
    }

    public List<Empleado> obtenListaEmpleados() throws HibernateException {
        return emp.obtenListaEmpleados();
    }

    public List<Empleado> obtenListaEmpleadosNombre(String nombre) throws HibernateException {
        return emp.obtenListaEmpleadosNombre(nombre);
    }

    public void report(String path, String fileName) {
        emp.report(path, fileName);
    }
}
