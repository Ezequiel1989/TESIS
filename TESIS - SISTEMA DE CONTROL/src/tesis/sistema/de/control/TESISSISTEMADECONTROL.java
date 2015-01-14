/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis.sistema.de.control;
import DAO.UsuarioDAO;
import Modelo.Usuario;
/**
 *
 * @author matias
 */
public class TESISSISTEMADECONTROL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioDAO DAOUsuario = new UsuarioDAO();
        Usuario confirmar = DAOUsuario.confirmarUsuario("1", "1");
        System.out.println("usuario: " +confirmar.getUsuario()+"  password: "+confirmar.getPassword());
    }
    
}
