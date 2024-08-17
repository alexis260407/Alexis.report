package fr.alexis.report.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static final SimpleDateFormat STANDAR_DATE_TIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static final  int PARIS_TIMEZONE_OFFSET = TimeZone.getTimeZone("Europe/Paris").getOffset((new Date()).getTime());

    public static Date convertToEuropeParis (Date date){
        Date result = (Date)date.clone();
        result.setTime(date.getTime() + PARIS_TIMEZONE_OFFSET);
        return result;
    }
}
