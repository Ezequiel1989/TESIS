package DAO;

import Modelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tesis.sistema.de.control.HibernateUtil;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JRException;
/**
 *
 * @author Ezequiel
 */
/**
 */
public class UsuarioDAO {

    private Session sesion;
    private Transaction tx;
    private final Map<String, Object> param = new HashMap<>();
    private SimpleDateFormat sf = new SimpleDateFormat("dd-M-yyyy@HH.mm.ss");
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

    public void report(String path, String fileName) {
        try {
            iniciaOperacion();
            param.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, sesion);
            String file = "pdf\\" + fileName + sf.format(date.getTime()) + ".pdf";            
            JasperReport jRpt = JasperCompileManager.compileReport(path);
            JasperPrint jPrint = JasperFillManager.fillReport(jRpt, param);
            JasperViewer.viewReport(jPrint, false);
            JasperExportManager.exportReportToPdfFile(jPrint, file);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        } finally {
            sesion.close();
        }
    }

    /**
     * Este metodo hace rollback a la transaccion en caso de excepcion.
     *
     * @param La excepcion capturada
     * @throws HibernateException
     */

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    /**
     * Este metodo se encarga de confirmar que el usuario sea valido.
     *
     * @param user
     * @param pass
     * @return Devuelve un usuario
     * @throws HibernateException
     */
    public Usuario confirmarUsuario(String user, String pass) throws HibernateException {
        Usuario usuario = null;
        String hql = "from Modelo.Usuario where USUARIO='" + user + "' AND PASSWORD='" + pass + "'";
        try {
            iniciaOperacion();
            Query query = sesion.createQuery(hql);
            usuario = (Usuario) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return usuario;
    }

}
