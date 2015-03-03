/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empleado;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tesis.sistema.de.fichaje.HibernateUtil;

/**
 *
 * @author Ezequiel
 */
public class EmpleadoDAO {

    private Session sesion;
    private Transaction tx;

    /**
     * Este metodo se encarga de abrir la session y comenzar una nueva
     * transaccion
     *
     * @throws HibernateException
     */
    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    /**
     * Este metodo hace rollback a la transaccion en caso de excepcion.
     *
     * @param he excepcion capturada
     * @throws HibernateException
     */
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    /**
     * Este metodo guarda un empleado recibido por parametro
     *
     * @param empleado un objeto Empleado
     * @throws HibernateException
     */
    public void guardaEmpleado(Empleado empleado) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(empleado);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

    }

    /**
     * Este metodo actualiza un empleado recibido por parametro.
     *
     * @param empleado un obejeto Empleado
     * @throws HibernateException
     */
    public void actualizaEmpleado(Empleado empleado) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(empleado);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    /**
     * Este metodo elimina un empleado recibido por parametro.
     *
     * @param empleado un objeto Empleado
     * @throws HibernateException
     */
    public void eliminaEmpleado(Empleado empleado) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(empleado);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    /**
     * Este metodo obtiene un empleado segun su id.
     *
     * @param idEmpleado de Empleado a buscar.
     * @return Un empleado si este se encuentra disponible, sino NULL.
     * @throws HibernateException
     */
    public Empleado obtenEmpleado(long idEmpleado) throws HibernateException {
        Empleado empleado = null;

        try {
            iniciaOperacion();
            empleado = (Empleado) sesion.get(Empleado.class, idEmpleado);            
        } finally {
            sesion.close();
        }
        return empleado;
    }

    /**
     * Este metodo obtiene un empleado segun su dni.
     *
     * @param dni de Empleado a buscar.
     * @return Un empleado si este se encuentra disponible, sino NULL.
     * @throws HibernateException
     */
    public Empleado obtenEmpleadoDNI(long documento) throws HibernateException {
        Empleado empleado = null;
        List<Empleado> listaEmpleados = null;
        try {
            iniciaOperacion();
            listaEmpleados = sesion.createQuery("from Modelo.Empleado where DOCUMENTO='" + documento + "'").list();
            empleado = listaEmpleados.get(0);
        } finally {
            sesion.close();
        }
        return empleado;
    }

    /**
     * Este metodo obtiene una lista de todos los empleados en la BD.
     *
     * @return todas los empleados que hay en la BD en un List, sino hay ninguno
     * devuelve NULL
     *
     * @throws HibernateException
     */
    public List<Empleado> obtenListaEmpleados() throws HibernateException {
        List<Empleado> listaEmpleados = null;

        try {
            iniciaOperacion();
            listaEmpleados = sesion.createQuery("from Modelo.Empleado").list();
        } finally {
            sesion.close();
        }

        return listaEmpleados;
    }

    /**
     * Este metodo obtiene una lista de todos los empleados segun su nombre.
     *
     * @return todas los empleados que hay en la BD en un List, sino hay ninguno
     * devuelve NULL
     * @param nombre de Empleado a buscar.
     * @throws HibernateException
     */
    public List<Empleado> obtenListaEmpleadosNombre(String nombre) throws HibernateException {
        List<Empleado> listaEmpleados = null;
        String hql = "from Modelo.Empleado where NOMBRE='" + nombre + "'";
        try {
            iniciaOperacion();
            Query query = sesion.createQuery(hql);
            listaEmpleados = query.list();
        } finally {
            sesion.close();
        }
        return listaEmpleados;
    }
}
