package br.ufrn.imd.obama.conversor;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class ConversorLocalDateTime implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        Timestamp retorno = null;
        if (locDateTime != null) {
            retorno = Timestamp.valueOf(locDateTime);
        }
        return retorno;
    }


    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        LocalDateTime retorno = null;
        if (sqlTimestamp != null) {
            retorno = sqlTimestamp.toLocalDateTime();
        }
        return retorno;
    }
}
