/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.dao.impl.AssentoDAOImpl;
import Model.dao.interfaces.AssentoDAO;
import Model.domain.Assento;
import Model.domain.AssentoOcupado;
import Model.domain.Itinerario;
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


public class AssentoControl {

        
    private PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Assento assentoDigitado;
    private Assento assentoSelecionado;
    private List<Assento> assentosTabela;
    private List<Itinerario> itinerariosTabela;
    private AssentoDAO assentoDAO;
    private List<Assento> ocupacao;
    private List<AssentoOcupado> listaAssentos;
    
    
    
    public AssentoControl(){
        assentoDAO = new AssentoDAOImpl();
        assentosTabela = ObservableCollections.observableList(
                new ArrayList<Assento>());
        itinerariosTabela = ObservableCollections.observableList(
                new ArrayList<Itinerario>());        
        listaAssentos = new ArrayList<AssentoOcupado>();
        novo();
        search();
        searchItinerario();
    }
    

    public void novo() {
        setAssentoDigitado(new Assento());
    }

    
    public void search() {
        assentosTabela.clear();
        assentosTabela.addAll(assentoDAO.search(assentoDigitado));
        searchOcupacao();
    }
    
    public void searchItinerario(){
        itinerariosTabela.clear();
        itinerariosTabela.addAll(assentoDAO.buscarItinerarios());
    }
    
    public void searchOcupacao(){
        this.listaAssentos.clear();
        if (assentoDigitado.getItinerario() != null){
            this.ocupacao = assentoDAO.buscarAssentosOcupados(assentoDigitado.getItinerario());        
            for (int i = 1; i <= this.assentoDigitado.getItinerario().getQtdLugares(); i++){
                AssentoOcupado assentoOcupado = new AssentoOcupado(i, false);
                for (int j = 0; j < this.ocupacao.size(); j++){
                    if (this.ocupacao.get(j).getNumeroAssento() == i){
                        assentoOcupado = new AssentoOcupado(i, true);
                        break;
                    }
                }            
                this.listaAssentos.add(assentoOcupado);
            }
        }
    }
    
    public void save() throws ValidateException{
        
        
        assentoDigitado.validate();
        AssentoOcupado assentoEscolhido = null;
        for (AssentoOcupado a : listaAssentos){
            if (a.getNumeroAssento() == assentoDigitado.getNumeroAssento() && a.isOcupado()){
                assentoEscolhido = a;
                break;
            }
        }
        if (assentoDigitado.getId() == null && assentoEscolhido != null){
            throw new ValidateException("Assento já ocupado!");
        } else if (assentoSelecionado != null && assentoEscolhido != null){
            if (assentoSelecionado.getNumeroAssento() != assentoDigitado.getNumeroAssento() && assentoEscolhido != null){
                throw new ValidateException("Assento já ocupado!");
            }
        } else {
            assentoDAO.insertUpdate(assentoDigitado);
            novo();
            search();
        }
    }
    
    public void delete(){
        assentoDAO.delete(assentoDigitado);
        novo();
        search();
    }

    public Assento getAssentoDigitado() {
        return assentoDigitado;
    }
    
    public void fireChange(){
        Assento oldAssentoDigitado = this.assentoDigitado;
        propertyChangeSupport.firePropertyChange("assentoDigitado", oldAssentoDigitado, assentoDigitado);
        this.assentoDigitado = assentoDigitado;        
    }

    public void setAssentoDigitado(Assento assentoDigitado) {
        Assento oldAssentoDigitado = this.assentoDigitado;
        propertyChangeSupport.firePropertyChange("assentoDigitado", oldAssentoDigitado, assentoDigitado);
        this.assentoDigitado = assentoDigitado;
    }

    public Assento getAssentoSelecionado() {
        return assentoSelecionado;
    }

    public void setAssentoSelecionado(Assento assentoSelecionado) {
        this.assentoSelecionado = assentoSelecionado;
        if (this.assentoDigitado != null){
            setAssentoDigitado(assentoDigitado);
        }
    }

    public List<Assento> getAssentosTabela() {
        return assentosTabela;
    }
    

    public void setAssentosTabela(List<Assento> assentosTabela) {
        this.assentosTabela = assentosTabela;
    }

    public List<Itinerario> getItinerariosTabela() {
        return itinerariosTabela;
    }

    public void setItinerariosTabela(List<Itinerario> itinerariosTabela) {
        this.itinerariosTabela = itinerariosTabela;
    }

    public List<Assento> getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(List<Assento> ocupacao) {
        this.ocupacao = ocupacao;
    }

    public List<AssentoOcupado> getListaAssentos() {
        return listaAssentos;
    }

    public void setListaAssentos(List<AssentoOcupado> listaAssentos) {
        this.listaAssentos = listaAssentos;
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }
    
}
