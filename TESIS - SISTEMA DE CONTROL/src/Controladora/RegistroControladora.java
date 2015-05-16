/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.RegistroDAO;
import Modelo.Registro;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Ezequiel
 */
public class RegistroControladora {

    RegistroDAO dao = new RegistroDAO();

    public void guardaRegistro(Registro registro) throws HibernateException {
        dao.guardaRegistro(registro);
    }

    public void actualizaRegistro(Registro registro) throws HibernateException {
        dao.actualizaRegistro(registro);
    }

    public void eliminaRegistro(Registro registro) throws HibernateException {
        dao.eliminaRegistro(registro);
    }

    public Registro obtenRegistro(long idRegistro) throws HibernateException {
        return dao.obtenRegistro(idRegistro);
    }

    public List<Registro> obtenListaRegistro() throws HibernateException {
        return dao.obtenListaRegistro();
    }

    public List<Registro> obtenListaRegistrosNombre(String nombre) throws HibernateException {

        return dao.obtenListaRegistrosNombre(nombre);
    }
}
