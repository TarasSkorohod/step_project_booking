package utils;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static utils.ConfigDate.TIME_ZONE;

public class FormatDate {

public static String dateToStr(Long dateTime, String format){
  return Instant.ofEpochMilli(dateTime).atZone(ZoneId.of(TIME_ZONE)).toLocalDateTime().format(DateTimeFormatter.ofPattern(format));
}


}
