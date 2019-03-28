package br.ufrn.imd.obama.conversor;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;
import com.google.common.base.Strings;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Convert(LocalDate.class)
@RequestScoped
public class LocalDateConverter implements Converter<LocalDate> {
    private final Locale locale;

    /** @deprecated */
    protected LocalDateConverter() {
        this((Locale)null);
    }

    @Inject
    public LocalDateConverter(Locale locale) {
        this.locale = locale;
    }

    public LocalDate convert(String value, Class<? extends LocalDate> type) {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        } else {
            try {
                return LocalDate.parse(value, this.getFormatter());
            } catch (DateTimeParseException var4) {
                throw new ConversionException(new ConversionMessage("is_not_a_valid_date", new Object[]{value}));
            }
        }
    }

    protected DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(this.locale);
    }
}

