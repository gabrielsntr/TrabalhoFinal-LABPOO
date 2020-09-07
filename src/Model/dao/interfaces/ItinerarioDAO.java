package Model.dao.interfaces;

import Model.domain.Itinerario;
import Model.domain.Municipio;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ItinerarioDAO extends CrudDAO<Itinerario>{
    
    List<Municipio> buscarMunicipios();
}
