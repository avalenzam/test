package com.telefonica.eof.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.PriceTypeEnum;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceTypeProdAltType;

public class Util {

    public static String fromBoolToYN(boolean cond) {
	return cond ? Constant.YES : Constant.NO;
    }

    public static LocalDate parseDate(String dateString) {
	LocalDate localDAte = null;
	if (dateString.contains("T")) {
	    localDAte = LocalDate.parse(Arrays.asList(dateString.split("T")).get(0));
	}
	return localDAte;
    }

    /**
     * método que separa una cadena en base a un divisor "," ,":" , etc..
     * 
     * @param data
     *            : cadena a ser dividida
     * @param separator
     *            : divisores
     * @return lista de cadena dividida ;
     */
    public static List<String> getListSplit(String data, String separator) {
	return Arrays.asList(data.split(separator));
    }

    /**
     * Método que devuelve la fecha actual en formato gregoriano.
     * 
     * @return Fecha actual en formato gregoriano.
     */
    public static GregorianCalendar getGCalendar() {
	GregorianCalendar gCalendar = new GregorianCalendar();
	gCalendar.setTime(new Date());
	return gCalendar;
    }

    public static Long getMonthsPeriod(LocalDate localDate) {
	LocalDate localDatenow = LocalDate.now();
	return ChronoUnit.MONTHS.between(localDate, localDatenow);
    }

    public static Long getDaysPeriod(XMLGregorianCalendar xmlGC) {
	LocalDate localDatenow = LocalDate.now();
	LocalDate localDate = LocalDate.of(xmlGC.getYear(), xmlGC.getMonth(), xmlGC.getDay());
	return ChronoUnit.DAYS.between(localDate, localDatenow);
    }

    public static PriceTypeEnum enumEquivalence(PriceTypeProdAltType ptpatEnum) {

	for (PriceTypeEnum b : PriceTypeEnum.values()) {
	    if (b.toString().substring(0, 5).equals(ptpatEnum.value().substring(0, 5))) {
		return b;
	    }
	}
	return null;
    }

    /**
     * Agrega el IGV
     * 
     * @param amount
     * @return amount con IGV
     */
    public static BigDecimal addIgv(BigDecimal amount) {

	return amount.multiply(Constant.IGV_MULTIPLIER);
    }

    /**
     * Redondea a 2 decimales
     * 
     * @param value
     * @return value con 2 decimales
     */
    public static BigDecimal roundValue(BigDecimal value) {

	return value.setScale(2, RoundingMode.HALF_UP);
    }

}
