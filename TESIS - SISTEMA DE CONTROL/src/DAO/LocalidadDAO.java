/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Localidad;
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
public class LocalidadDAO {

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
     * Este metodo guarda una localidad recibido por parametro
     *
     * @param localidad un objeto localidad
     * @throws HibernateException
     */
    public void guardaLocalidad(Localidad localidad) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(localidad);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

    }

    /**
     * Este metodo actualiza una localidad recibido por parametro.
     *
     * @param localidad un obejeto localidad
     * @throws HibernateException
     */
    public void actualizaLocalidad(Localidad localidad) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(localidad);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    /**
     * Este metodo elimina una localidad recibido por parametro.
     *
     * @param localidad un objeto localidad
     * @throws HibernateException
     */
    public void eliminaLocalidad(Localidad localidad) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(localidad);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    /**
     * Este metodo obtiene una localidad segun su id.
     *
     * @param idlocalidad de localidad a buscar.
     * @return Una localidad si esta se encuentra disponible, sino NULL.
     * @throws HibernateException
     */
    public Localidad obtenLocalidad(long idLocalidad) throws HibernateException {
        Localidad localidad = null;

        try {
            iniciaOperacion();
            localidad = (Localidad) sesion.get(Localidad.class, idLocalidad);
        } finally {
            sesion.close();
        }
        return localidad;
    }

    /**
     * Este metodo obtiene una lista de todas las localidades en la BD.
     *
     * @return todas las localidades que hay en la BD en un List, sino hay
     * ninguna devuelve NULL
     *
     * @throws HibernateException
     */
    public List<Localidad> obtenListaLocalidades() throws HibernateException {
        List<Localidad> listaLocalidades = null;

        try {
            iniciaOperacion();
            listaLocalidades = sesion.createQuery("from Modelo.Localidad").list();
        } finally {
            sesion.close();
        }

        return listaLocalidades;
    }

    /**
     * Este metodo obtiene una lista de todos las localidades segun su nombre.
     *
     * @return todas las localidades que hay en la BD en un List, sino hay
     * ninguno devuelve NULL
     * @param nombre de Localidad a buscar.
     * @throws HibernateException
     */
    public List<Localidad> obtenListaLocalidadesNombre(String nombre) throws HibernateException {
        List<Localidad> listaLocalidades = null;
        String hql = "from Modelo.Localidad where localidad='" + nombre + "'";
        try {
            iniciaOperacion();
            Query query = sesion.createQuery(hql);
            listaLocalidades = query.list();
        } finally {
            sesion.close();
        }
        return listaLocalidades;
    }

    public Localidad obtenLocalidadNombre(String nombre) throws HibernateException {
        Localidad localidad = null;
        String hql = "from Modelo.Localidad where localidad='" + nombre + "'";
        try {
            iniciaOperacion();
            Query query = sesion.createQuery(hql);
            localidad = (Localidad) query.uniqueResult();
        } finally {
            sesion.close();
        }
        return localidad;
    }
}
