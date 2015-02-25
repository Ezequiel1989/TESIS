package DAO;

import Modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tesis.sistema.de.control.HibernateUtil;

/**
 *
 * @author Ezequiel
 */
/**
*/
public class UsuarioDAO {

    private Session sesion;
    private Transaction tx;

    /**
     * Este metodo se encarga de abrir la session y comenzar una nueva
     * transaccion
     *
     * @throws HibernateException
     */
    private void iniciaOperacion() throws HibernateException
    
    {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
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
    public Usuario confirmarUsuario(String user, String pass) throws HibernateException 
    
    {
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
