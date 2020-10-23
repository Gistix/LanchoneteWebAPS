/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import Entities.Ingrediente.Tipo;
/**
 *
 * @author Giovanni
 */
/*@Converter(autoApply = true)
public class TipoConverter implements AttributeConverter<Tipo, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Ingrediente.Tipo tipo) {
        return tipo.ordinal();
    }
 
    @Override
    public Tipo convertToEntityAttribute(Integer tipo) {       
        return Tipo.values()[tipo-1];
    }
}*/
