package Model.dao.impl;

import Model.dao.interfaces.Conexao;
import Model.dao.interfaces.UsuarioDAO;
import Model.domain.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabri
 */
public class UsuarioDAOImpl extends CrudDAOImpl<Usuario, Integer> implements UsuarioDAO {
    
    @Override
    public List<Usuario> searchTabela(Usuario usuario, Usuario usuarioLogado){
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql;
        sql = new StringBuilder("select new Usuario(u.id, u.username) from Usuario u ");
        sql.append("where 1 = 1 ");
        if (usuario.getId() != null){
            sql.append("and u.id = :id ");
        }
        if (usuario.getUsername() != null && 
                !usuario.getUsername().equals("")){
            sql.append("and u.username like :username ");
        }
        if (usuarioLogado != null && !usuarioLogado.getUsername().equals("admin")){
            sql.append("and u.username = :userlogado");
        }
        Query q = em.createQuery(sql.toString());
        if (usuario.getId() != null) {
            q.setParameter("id", usuario.getId());
        }
        if (usuario.getUsername() != null && 
                !usuario.getUsername().equals("")){
            q.setParameter("username", "%" + usuario.getUsername());
        }
        if (usuarioLogado != null && !usuarioLogado.getUsername().equals("admin")){
            q.setParameter("userlogado", usuarioLogado.getUsername());
        }        
        
        return q.getResultList();
    }

    @Override
    protected Integer getChave(Usuario usuario) {
        return usuario.getId();
    }

    @Override
    protected String getConsultaSql(Usuario usuario) {
        StringBuilder sql = new StringBuilder("select new Usuario(u.id, u.username) from Usuario u ");
        sql.append("where 1 = 1 ");
        if (usuario.getId() != null){
            sql.append("and u.id = :id ");
        }
        if (usuario.getUsername() != null && 
                !usuario.getUsername().equals("")){
            sql.append("and u.username like :username ");
        }
        if (usuario.getPassword()!= null && 
                !usuario.getPassword().equals("")){
            sql.append("and u.password = :password ");
        }
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getParametrosMapa(Usuario usuario) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        
        if (usuario.getId() != null) {
            mapa.put("id", usuario.getId());
        }
        if (usuario.getUsername() != null && 
                !usuario.getUsername().equals("")){
            mapa.put("username", "%" + usuario.getUsername());
        }
        if (usuario.getPassword()!= null && 
                !usuario.getPassword().equals("")){
            mapa.put("password", usuario.getPassword());
        }
        return mapa;
    }


}
