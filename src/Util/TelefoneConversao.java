package Util;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author gabri
 */
public class TelefoneConversao extends Converter<String, String>{

    @Override
    public String convertForward(String value) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return value;
    }

    @Override
    public String convertReverse(String value) {
        return value.replaceAll("[^0-9]+", "");
    }
    
}
