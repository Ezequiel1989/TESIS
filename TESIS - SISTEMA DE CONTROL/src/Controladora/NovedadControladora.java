/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.NovedadDAO;
import Modelo.Novedad;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Ezequiel
 */
public class NovedadControladora {

    NovedadDAO nov = new NovedadDAO();

    public void guardaNovedad(Novedad novedad) throws HibernateException {
        nov.guardaNovedad(novedad);
    }

    /**
     * Este metodo actualiza un empleado recibido por parametro.
     *
     * @param empleado un obejeto Empleado
     * @throws HibernateException
     */
    public void actualizaNovedad(Novedad novedad) throws HibernateException {
        nov.actualizaNovedad(novedad);
    }

    /**
     * Este metodo elimina un empleado recibido por parametro.
     *
     * @param empleado un objeto Empleado
     * @throws HibernateException
     */
    public void eliminaNovedad(Novedad novedad) throws HibernateException {
        nov.eliminaNovedad(novedad);
    }

    /**
     * Este metodo obtiene un empleado segun su id.
     *
     * @param idEmpleado de Empleado a buscar.
     * @return Un empleado si este se encuentra disponible, sino NULL.
     * @throws HibernateException
     */
    public Novedad obtenNovedad(long idNovedad) throws HibernateException {
        return nov.obtenNovedad(idNovedad);
    }

    /**
     * Este metodo obtiene una lista de todos los empleados en la BD.
     *
     * @return todas los empleados que hay en la BD en un List, sino hay ninguno
     * devuelve NULL
     *
     * @throws HibernateException
     */
    public List<Novedad> obtenListaNovedades(int mes, int ano) throws HibernateException {
        return nov.obtenListaNovedades(mes, ano);
    }
}
