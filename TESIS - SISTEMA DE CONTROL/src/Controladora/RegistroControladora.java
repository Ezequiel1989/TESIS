/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.RegistroDAO;
import Modelo.Empleado;
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

    public List<Registro> obtenListaRegistrosNombre(int mes, int ano, Empleado e) throws HibernateException {

        return dao.obtenListaRegistrosNombre(mes, ano, e);
    }

    public void report(String path, String fileName, int mes, int ano, Empleado empleado) {
        dao.report(path, fileName, mes, ano, empleado);
    }
}
