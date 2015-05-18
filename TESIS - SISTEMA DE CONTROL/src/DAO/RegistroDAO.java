/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empleado;
import Modelo.Registro;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tesis.sistema.de.control.HibernateUtil;

/**
 *
 * @author Ezequiel
 */
public class RegistroDAO {

    private Session sesion;
    private Transaction tx;
    private final Map<String, Object> param = new HashMap<>();
    private SimpleDateFormat sf = new SimpleDateFormat("dd-M-yyyy - HH:mm:ss");
    private Date date = new Date();

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
    public void guardaRegistro(Registro registro) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(registro);
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
    public void actualizaRegistro(Registro registro) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(registro);
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
    public void eliminaRegistro(Registro registro) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(registro);
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
    public Registro obtenRegistro(long idRegistro) throws HibernateException {
        Registro registro = null;

        try {
            iniciaOperacion();
            registro = (Registro) sesion.get(Registro.class, idRegistro);
        } finally {
            sesion.close();
        }
        return registro;
    }

    /**
     * Este metodo obtiene un empleado segun su dni.
     *
     * @param dni de Empleado a buscar.
     * @return Un empleado si este se encuentra disponible, sino NULL.
     * @throws HibernateException
     */
    /**
     * Este metodo obtiene una lista de todos los empleados en la BD.
     *
     * @return todas los empleados que hay en la BD en un List, sino hay ninguno
     * devuelve NULL
     *
     * @throws HibernateException
     */
    public List<Registro> obtenListaRegistro() throws HibernateException {
        List<Registro> listaRegistros = null;

        try {
            iniciaOperacion();
            listaRegistros = sesion.createQuery("from Modelo.Registro").list();
        } finally {
            sesion.close();
        }

        return listaRegistros;
    }

    /**
     * Este metodo obtiene una lista de todos los empleados segun su nombre.
     *
     * @return todas los empleados que hay en la BD en un List, sino hay ninguno
     * devuelve NULL
     * @param nombre de Empleado a buscar.
     * @throws HibernateException
     */
    public List<Registro> obtenListaRegistrosNombre(int mes, int ano, Empleado e) throws HibernateException {
        List<Registro> listaRegistros = null;
        String hql = "from Modelo.Registro where month(STR_TO_DATE(dia, '%m/%d/%Y')) = '"+mes+"' and year(STR_TO_DATE(dia, '%m/%d/%Y')) = '"+ano+"' and idempleados = '"+e.getIdempleados()+"'";
        try {
            iniciaOperacion();
            Query query = sesion.createQuery(hql);
            listaRegistros = query.list();
        } finally {
            sesion.close();
        }
        return listaRegistros;
    }
        public void report(String path, String fileName, int mes, int ano, Empleado e) {
        try {
            iniciaOperacion();
            param.put("mes", mes);
            param.put("ano", ano);
            param.put("ide", e.getIdempleados());
            param.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, sesion);
            String file = "pdf\\" + fileName + sf.format(date.getTime()) + ".pdf";
            JasperReport jRpt = JasperCompileManager.compileReport(path);
            JasperPrint jPrint = JasperFillManager.fillReport(jRpt, param);
            if (!jPrint.getPages().isEmpty()) {
                JasperViewer.viewReport(jPrint, false);
                JasperExportManager.exportReportToPdfFile(jPrint, file);
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentran movimientos en ese periodo");
            }
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } finally {
            sesion.close();
        }
    }
}
