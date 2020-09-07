package Model.dao.impl;

import Model.dao.interfaces.ItinerarioDAO;
import Model.dao.interfaces.MunicipioDAO;
import Model.domain.Itinerario;
import Model.domain.Municipio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gabri
 */
public class ItinerarioDAOImpl extends CrudDAOImpl<Itinerario, Integer> 
        implements ItinerarioDAO{

    @Override
    public List<Municipio> buscarMunicipios() {
        MunicipioDAO municipioDAO = new MunicipioDAOImpl();
        return municipioDAO.search(new Municipio());
    }
    
    @Override
    protected Integer getChave(Itinerario itinerario) {
        return itinerario.getId();
    }

    @Override
    protected String getConsultaSql(Itinerario itinerario) {
        StringBuilder sql = new StringBuilder("from Itinerario i ");
        sql.append("where 1 = 1 ");
        if (itinerario.getId() != null){
            sql.append("and i.id = :id ");
        }
        if (itinerario.getMunicipioOrigem()!= null){
            sql.append("and i.municipioOrigem.id = :idMunicipioOrigem ");
        }
        if (itinerario.getMunicipioDestino()!= null){
            sql.append("and i.municipioDestino.id = :idMunicipioDestino ");
        }
        sql.append("order by i.municipioOrigem.nome, i.municipioDestino.nome ");
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getParametrosMapa(Itinerario itinerario) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        
        if (itinerario.getId() != null) {
            mapa.put("id", itinerario.getId());
        }
        if (itinerario.getMunicipioOrigem()!= null){
            mapa.put("idMunicipioOrigem", itinerario.getMunicipioOrigem().getId());
        }
        if (itinerario.getMunicipioDestino()!= null){
            mapa.put("idMunicipioDestino", itinerario.getMunicipioDestino().getId());
        }
        return mapa;
    }
    
}
