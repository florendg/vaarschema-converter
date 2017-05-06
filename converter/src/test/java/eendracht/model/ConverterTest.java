package eendracht.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test to validate Conversion function
 * Created by florendegier on 06/05/2017.
 */
public class ConverterTest {
   @Test
   public void tekstToReis() throws Exception {

      String testRegel="{851E2430-4A9C-E611-8B66-00163503EA9B};170828;170828 Wervingsdag bemanning;Dagtocht groep;1;" +
         "27/08/2017 19:30;28/08/2017 20:00;Vlissingen;Rotterdam";

      String expectedString ="170828;170828 Wervingsdag bemanning;Vlissingen;Rotterdam;Sun 27 Aug;19:30;Mon 28 Aug;20:00;1;Dagtocht groep;";

      Reis reis = Converter.tekstToReis(testRegel);

      String result = Converter.generateBootsmanReis(reis);

      assertEquals("",expectedString, result);

   }

}