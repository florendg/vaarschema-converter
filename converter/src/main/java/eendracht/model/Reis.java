package eendracht.model;

import java.time.LocalDateTime;

/**
 * Model voor een Eendracht reis.
 * Created by florendegier on 06/05/2017.
 */
public class Reis {
   private String nummer;
   private String titel;
   private String sooort;
   private int aantalDagen;
   private LocalDateTime opstapTijd;
   private LocalDateTime afstapTijd;
   private String opStapplaats;
   private String afstapPlaats;

   String getNummer() {
      return nummer;
   }

   void setNummer(String nummer) {
      this.nummer = nummer;
   }

   public String getTitel() {
      return titel;
   }

   void setTitel(String titel) {
      this.titel = titel;
   }

   String getSooort() {
      return sooort;
   }

   void setSooort(String sooort) {
      this.sooort = sooort;
   }

   int getAantalDagen() {
      return aantalDagen;
   }

   void setAantalDagen(int aantalDagen) {
      this.aantalDagen = aantalDagen;
   }

   LocalDateTime getOpstapTijd() {
      return opstapTijd;
   }

   void setOpstapTijd(LocalDateTime opstapTijd) {
      this.opstapTijd = opstapTijd;
   }

   LocalDateTime getAfstapTijd() {
      return afstapTijd;
   }

   void setAfstapTijd(LocalDateTime afstapTijd) {
      this.afstapTijd = afstapTijd;
   }

   String getOpStapplaats() {
      return opStapplaats;
   }

   void setOpStapplaats(String opStapplaats) {
      this.opStapplaats = opStapplaats;
   }

   String getAfstapPlaats() {
      return afstapPlaats;
   }

   void setAfstapPlaats(String afstapPlaats) {
      this.afstapPlaats = afstapPlaats;
   }
}

