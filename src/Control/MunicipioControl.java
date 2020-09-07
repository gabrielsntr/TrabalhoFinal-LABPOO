package Control;

import Model.dao.interfaces.MunicipioDAO;
import Model.dao.impl.MunicipioDAOImpl;
import Model.domain.Municipio;
import Util.ValidateException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author gabri
 */
public class MunicipioControl {
    
    private PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Municipio municipioDigitado;
    private Municipio municipioSelecionado;
    private List<Municipio> municipiosTabela;
    private MunicipioDAO municipioDAO;
    
    
    public MunicipioControl(){
        municipioDAO = new MunicipioDAOImpl();
        municipiosTabela = ObservableCollections.observableList(
                new ArrayList<Municipio>());
        novo();
        search();
       
    }

    public void novo() {
        setMunicipioDigitado(new Municipio());
    }

    public void search() {
        municipiosTabela.clear();
        municipiosTabela.addAll(municipioDAO.search(municipioDigitado));
    }
    
    public void save() throws ValidateException{
        municipioDigitado.validate();
        municipioDAO.insertUpdate(municipioDigitado);
        novo();
        search();
    }
    
    public void delete(){
        municipioDAO.delete(municipioDigitado);
        novo();
        search();
    }

    public Municipio getMunicipioDigitado() {
        return municipioDigitado;
    }

    public void setMunicipioDigitado(Municipio municipioDigitado) {
        Municipio oldMunicipioDigitado = this.municipioDigitado;
        propertyChangeSupport.firePropertyChange("usuarioDigitado", oldMunicipioDigitado, municipioDigitado);
        this.municipioDigitado = municipioDigitado;
    }

    public Municipio getMunicipioSelecionado() {
        return municipioSelecionado;
    }

    public void setMunicipioSelecionado(Municipio municipioSelecionado) {
        this.municipioSelecionado = municipioSelecionado;
        if (this.municipioDigitado != null){
            setMunicipioDigitado(municipioDigitado);
        }
    }

    public List<Municipio> getMunicipiosTabela() {
        return municipiosTabela;
    }

    public void setMunicipiosTabela(List<Municipio> municipiosTabela) {
        this.municipiosTabela = municipiosTabela;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }
    
}
