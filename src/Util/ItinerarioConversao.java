/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.domain.Itinerario;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author gabri
 */
public class ItinerarioConversao extends Converter<Itinerario, Object>{

    @Override
    public Object convertForward(Itinerario value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Itinerario convertReverse(Object value) {
        return (Itinerario) value;
    }
    
}
