/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Novedad;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tesis.sistema.de.control.HibernateUtil;
/**
 *
 * @author Ezequiel
 */
public class NovedadDAO {
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
    public void guardaNovedad(Novedad novedad) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(novedad);
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
    public void actualizaNovedad(Novedad novedad) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(novedad);
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
    public void eliminaNovedad(Novedad novedad) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(novedad);
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
    public Novedad obtenNovedad(long idNovedad) throws HibernateException {
        Novedad novedad = null;

        try {
            iniciaOperacion();
            novedad = (Novedad) sesion.get(Novedad.class, idNovedad);
        } finally {
            sesion.close();
        }
        return novedad;
    }


    /**
     * Este metodo obtiene una lista de todos los empleados en la BD.
     *
     * @return todas los empleados que hay en la BD en un List, sino hay ninguno
     * devuelve NULL
     *
     * @throws HibernateException
     */
    public List<Novedad> obtenListaNovedades() throws HibernateException {
        List<Novedad> listaNovedades = null;

        try {
            iniciaOperacion();
            listaNovedades = sesion.createQuery("from Modelo.Novedad").list();
        } finally {
            sesion.close();
        }

        return listaNovedades;
    }
 
}
