/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.fichaje;

/**
 *
 * @author Ezequiel
 */
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Esta clase representa el administrador de session de Hibernate
 *
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    /**
     * Crea el sessionFactory de la configuracion de hibernate
     * (hibernate.cfg.xml)
     *
     * @throws Lanza la excepcion en caso de falla al iniciar el sessionFactory
     */
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
