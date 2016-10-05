package at.ac.univie.swe2016.fm.fahrzeuge;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Nikolaus Lentz 1326773 on 05.10.16.
 */
public class PKW extends Fahrzeug {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate Überprüfungsdatum;
    public PKW(String marke, String modell, int baujahr, int grundpreis, int id, String überprüfungsdatum) throws IllegalArgumentException {
        super(marke, modell, baujahr, grundpreis, id);
        Überprüfungsdatum = LocalDate.parse(überprüfungsdatum, formatter);
    }

    @Override
    public double getRabatt() {
        return 0;
    }
}
