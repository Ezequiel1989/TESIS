/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.LocalidadDAO;
import Modelo.Localidad;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Ezequiel
 */
public class LocalidadControladora {
        LocalidadDAO loc = new LocalidadDAO();
    public void guardaLocalidad(Localidad localidad) throws HibernateException {
        loc.guardaLocalidad(localidad);
    }


    public void actualizaLocalidad(Localidad localidad) throws HibernateException {
        loc.actualizaLocalidad(localidad);
    }


    public void eliminaLocalidad(Localidad localidad) throws HibernateException {
        loc.eliminaLocalidad(localidad);
    }

    public Localidad obtenLocalidad(long idLocalidad) throws HibernateException {
        return loc.obtenLocalidad(idLocalidad);
    }

    public List<Localidad> obtenListaLocalidades() throws HibernateException {
        return loc.obtenListaLocalidades();
    }

    public List<Localidad> obtenListaLocalidadesNombre(String nombre) throws HibernateException {
        return loc.obtenListaLocalidadesNombre(nombre);
    }
    
        public Localidad obtenLocalidadNombre(String nombre) throws HibernateException {
                return loc.obtenLocalidadNombre(nombre);
    }
}
