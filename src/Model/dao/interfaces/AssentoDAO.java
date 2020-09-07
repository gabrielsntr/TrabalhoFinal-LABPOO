package Model.dao.interfaces;

import Model.domain.Assento;
import Model.domain.Itinerario;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface AssentoDAO extends CrudDAO<Assento> {
    
    List<Itinerario> buscarItinerarios();
    List<Assento> buscarAssentosOcupados(Itinerario itinerario);
    
}
