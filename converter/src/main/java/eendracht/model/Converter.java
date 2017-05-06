package eendracht.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Conversion functions for VaarSchema
 * Created by florendegier on 06/05/2017.
 */
public class Converter {

   private Converter() {
      // This is a utility class
   }

   /**
    * Converts line from Vaarschema Eendracht
    * @param tekst Line from the Vaarschema
    * @return a Reis object
    */
   public static Reis tekstToReis(final String tekst) {

      DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");

      String[] velden = tekst.split(";");
      if (velden.length != 9 ) {
         throw new IllegalArgumentException("Aantal velden is geen 8 maar " + velden.length);
      }
      Reis reis = new Reis();
      reis.setNummer(velden[1]);
      reis.setTitel(velden[2]);
      reis.setSooort(velden[3]);
      reis.setAantalDagen(Integer.valueOf(velden[4]));
      reis.setOpstapTijd(LocalDateTime.parse(velden[5],format));
      reis.setAfstapTijd(LocalDateTime.parse(velden[6],format));
      reis.setOpStapplaats(velden[7]);
      reis.setAfstapPlaats(velden[8]);
      return reis;
   }

   /**
    * Create a line for the document maintained by the Bosun
    * @param reis tip info.
    * @return ; seperated String for one trip.
    */
   public static String generateBootsmanReis(Reis reis) {
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EE dd MMM", Locale.forLanguageTag("nl_NL"));
      DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
      StringBuilder sb = new StringBuilder(reis.getNummer()).append(";");
      sb.append(reis.getTitel()).append(";");
      sb.append(reis.getOpStapplaats()).append(";");
      sb.append(reis.getAfstapPlaats()).append(";");
      sb.append(reis.getOpstapTijd().format(dateFormat)).append(";");
      sb.append(reis.getOpstapTijd().format(timeFormat)).append(";");
      sb.append(reis.getAfstapTijd().format(dateFormat)).append(";");
      sb.append(reis.getAfstapTijd().format(timeFormat)).append(";");
      sb.append(reis.getAantalDagen()).append(";");
      sb.append(reis.getSooort()).append(";");
      return sb.toString();
   }

}
