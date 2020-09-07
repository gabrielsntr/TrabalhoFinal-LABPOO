/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.dao.interfaces.ItinerarioDAO;
import Model.dao.impl.ItinerarioDAOImpl;
import Model.domain.Itinerario;
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
public class ItinerarioControl {
    
    private PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Itinerario itinerarioDigitado;
    private Itinerario itinerarioSelecionado;
    private List<Itinerario> itinerariosTabela;
    private List<Municipio> municipiosTabela;
    private ItinerarioDAO itinerarioDAO;
    
    
    
    public ItinerarioControl(){
        itinerarioDAO = new ItinerarioDAOImpl();
        itinerariosTabela = ObservableCollections.observableList(
                new ArrayList<Itinerario>());
        municipiosTabela = ObservableCollections.observableList(
                new ArrayList<Municipio>());        
        novo();
        search();
        searchMunicipio();
       
    }
    
    public void searchMunicipio(){
        municipiosTabela.clear();
        municipiosTabela.addAll(itinerarioDAO.buscarMunicipios());
    }

    public void novo() {
        setItinerarioDigitado(new Itinerario());
    }

    public void search() {
        itinerariosTabela.clear();
        itinerariosTabela.addAll(itinerarioDAO.search(itinerarioDigitado));
    }
    
    public void save() throws ValidateException{
        itinerarioDigitado.validate();
        itinerarioDAO.insertUpdate(itinerarioDigitado);
        novo();
        search();
    }
    
    public void delete(){
        itinerarioDAO.delete(itinerarioDigitado);
        novo();
        search();
    }

    public Itinerario getItinerarioDigitado() {
        return itinerarioDigitado;
    }

    public void setItinerarioDigitado(Itinerario itinerarioDigitado) {
        Itinerario oldItinerarioDigitado = this.itinerarioDigitado;
        propertyChangeSupport.firePropertyChange("itinerarioDigitado", oldItinerarioDigitado, itinerarioDigitado);
        this.itinerarioDigitado = itinerarioDigitado;
    }

    public Itinerario getItinerarioSelecionado() {
        return itinerarioSelecionado;
    }

    public void setItinerarioSelecionado(Itinerario itinerarioSelecionado) {
        this.itinerarioSelecionado = itinerarioSelecionado;
        if (this.itinerarioDigitado != null){
            setItinerarioDigitado(itinerarioDigitado);
        }
    }

    public List<Itinerario> getItinerariosTabela() {
        return itinerariosTabela;
    }
    

    public void setItinerariosTabela(List<Itinerario> itinerariosTabela) {
        this.itinerariosTabela = itinerariosTabela;
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
