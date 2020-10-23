/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import org.postgresql.util.PGobject;

/**
 *
 * @author Giovanni
 */
@Converter(autoApply = true)
public class EnderecoConverter implements AttributeConverter<Endereco, PGobject> {
    @Override
    public PGobject convertToDatabaseColumn(Endereco endereco) {
        try {
            return endereco.ToDBData();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
    @Override
    public Endereco convertToEntityAttribute(PGobject dbData) { 
        return Endereco.FromDBData(dbData);
    }
}
