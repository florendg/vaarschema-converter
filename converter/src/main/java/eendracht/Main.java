package eendracht;

import eendracht.model.Converter;
import eendracht.model.Reis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class reads a csv and converts it to another_csv
 * Created by florendegier on 06/05/2017.
 */
public class Main {

   private static Logger LOG = LoggerFactory.getLogger(Main.class);

   public static void main(String... args) {

      List<Reis> trips = new ArrayList<>();

      if (args.length != 1) {
         throw new IllegalArgumentException("Please provide the input file");
      }

      String inputFile = args[0];
      LOG.info("Process {}", inputFile);


      try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
         String line = br.readLine();
         LOG.info("header: {}", line);
         while((line = br.readLine()) != null) {
            trips.add(Converter.tekstToReis(line));
         }

      } catch (IOException ioe) {
         LOG.error("Failed to read the input file", ioe);
      }

      LOG.info("Vaarschema ingelezen");

      try (BufferedWriter bw = new BufferedWriter(new FileWriter("vaarschema_bootslieden.csv"))) {
         bw.write("reisnr;titel;van;naar;bemanning aan boord;;bemanning van boord;;dagen;soort reis;bootsman 1;bootsman 2;bio");
         bw.newLine();
         for(Reis trip:trips) {
            bw.write(Converter.generateBootsmanReis(trip));
            bw.newLine();
         }
      } catch (IOException ioe) {
         LOG.error("Failed to write schema");
      }

      LOG.info("Vaarschema geschreven");

   }
}
