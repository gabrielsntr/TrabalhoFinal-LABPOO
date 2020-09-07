package Model.dao.impl;

import Model.dao.interfaces.MunicipioDAO;
import Model.domain.Municipio;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gabri
 */
public class MunicipioDAOImpl extends CrudDAOImpl<Municipio, Integer> 
        implements MunicipioDAO {

    @Override
    protected Integer getChave(Municipio municipio) {
        return municipio.getId();
    }

    @Override
    protected String getConsultaSql(Municipio municipio) {
        StringBuilder sql = new StringBuilder("from Municipio m "
                + "where 1 = 1 ");
        if (municipio.getId() != null){
            sql.append("and m.id = :id ");
        }
        if (municipio.getNome() != null && 
                !municipio.getNome().equals("")){
            sql.append("and m.nome like :nome ");
        }
        sql.append("order by m.nome, m.uf ");
        /*if (municipio.getUf() != null && 
                !municipio.getUf().equals("")){
            sql.append("and m.uf = :uf ");
        }*/
        return sql.toString();
    }

    @Override
    protected Map<String, Object> getParametrosMapa(Municipio municipio) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        if (municipio.getId() != null) {
            mapa.put("id", municipio.getId());
        }
        if (municipio.getNome() != null && 
                !municipio.getNome().equals("")){
            mapa.put("nome", "%" + municipio.getNome());
        }
        /*if (municipio.getUf() != null && 
                !municipio.getUf().equals("")){
            q.setParameter("uf", municipio.getUf());
        }        */        
        return mapa;
    }
}
