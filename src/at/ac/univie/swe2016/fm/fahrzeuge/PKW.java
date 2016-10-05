package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Date;

/**
 * Created by Nikolaus Lentz 1326773 on 05.10.16.
 */
public class PKW extends Fahrzeug {
    Date Überprüfungsdatum;
    public PKW(String marke, String modell, int baujahr, int grundpreis, int id, Date überprüfungsdatum) throws IllegalArgumentException {
        super(marke, modell, baujahr, grundpreis, id);
        Überprüfungsdatum = überprüfungsdatum;
    }

    @Override
    public double getRabatt() {
        return 0;
    }
}
