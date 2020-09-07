/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import Model.domain.AssentoOcupado;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author gabri
 */
public class AssentoConversao extends Converter<Integer,AssentoOcupado>{

    public AssentoConversao() {
    }        

    @Override
    public AssentoOcupado convertForward(Integer value) {
        return new AssentoOcupado(value, false);
    }

    @Override
    public Integer convertReverse(AssentoOcupado value) {
        Integer assentoEscolhido = ((AssentoOcupado) value).getNumeroAssento();
        return assentoEscolhido;
    }
}
