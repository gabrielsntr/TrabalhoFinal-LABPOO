/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao.interfaces;

import Model.domain.Usuario;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface UsuarioDAO extends CrudDAO<Usuario>{

 
    List<Usuario> searchTabela(Usuario usuario, Usuario usuarioLogado);
    
    
}
