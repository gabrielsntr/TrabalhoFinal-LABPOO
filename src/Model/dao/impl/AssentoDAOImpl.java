package Model.dao.impl;

import Model.dao.interfaces.AssentoDAO;
import Model.dao.interfaces.Conexao;
import Model.dao.interfaces.ItinerarioDAO;
import Model.domain.Assento;
import Model.domain.Itinerario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabri
 */
public class AssentoDAOImpl extends CrudDAOImpl<Assento, Integer> 
        implements AssentoDAO{

    @Override
    protected Integer getChave(Assento assento) {
        return assento.getId();
    }

    @Override
    protected String getConsultaSql(Assento assento) {
        StringBuilder sql = new StringBuilder("from Assento a ");
        sql.append("where 1 = 1 ");
        if (assento.getId() != null){
            sql.append("and a.id = :id ");
        }
        //if (assento.getItinerario()!= null){
            sql.append("and a.itinerario.id = :idItinerario ");
        //}        
        if (assento.getNumeroAssento()!= null){
            sql.append("and a.numeroAssento = :numeroAssento ");
        }
        if (assento.getNomePassageiro()!= null){
            sql.append("and a.nomePassageiro = :nomePassageiro ");
        }
        if (assento.getTelefonePassageiro()!= null){
            sql.append("and a.telefonePassageiro = :telefonePassageiro ");
        }
        sql.append("order by a.numeroAssento");
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getParametrosMapa(Assento assento) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        
        if (assento.getId() != null) {
            mapa.put("id", assento.getId());
        }
        if (assento.getItinerario()!= null){
            System.out.println(assento.getItinerario().getId());
            mapa.put("idItinerario", assento.getItinerario().getId());
        } else {
            mapa.put("idItinerario", 0);
        }
        if (assento.getNumeroAssento()!= null){
            mapa.put("numeroAssento", assento.getNumeroAssento());
        }
        if (assento.getNomePassageiro()!= null){
            mapa.put("nomePassageiro", "%" + assento.getNomePassageiro());
        }
        if (assento.getTelefonePassageiro()!= null){
            mapa.put("telefonePassageiro", "%" + assento.getTelefonePassageiro());
        }        
        return mapa;
    }

    @Override
    public List<Itinerario> buscarItinerarios() {
        ItinerarioDAO itinerarioDAO = new ItinerarioDAOImpl();
        return itinerarioDAO.search(new Itinerario());    
    }

    @Override
    public List<Assento> buscarAssentosOcupados(Itinerario itinerario) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql;
        sql = new StringBuilder("select new Assento(a.itinerario, a.numeroAssento) from Assento a ");
        sql.append("where 1 = 1 ");
        sql.append("and a.itinerario.id = :idItinerario ");

        Query q = em.createQuery(sql.toString());
        if (itinerario != null){
            q.setParameter("idItinerario", itinerario.getId());
        } else {
            q.setParameter("idItinerario", 0);
        }  
        return q.getResultList();
    }
    
    
}
