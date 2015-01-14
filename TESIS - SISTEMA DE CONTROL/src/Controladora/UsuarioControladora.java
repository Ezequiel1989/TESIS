/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import DAO.UsuarioDAO;
import Modelo.Usuario;

/**
 *
 * @author Ezequiel
 */
public class UsuarioControladora {
     UsuarioDAO usuario = new UsuarioDAO();
     public Usuario confirmarUsuario(String user, String pass)
     {
         return usuario.confirmarUsuario(user, pass);
     }
}
