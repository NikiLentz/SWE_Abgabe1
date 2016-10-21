package at.ac.univie.swe2016.fm.fahrzeuge;


import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Created by Nikolaus Lentz 1326773 on 05.10.16.
 */
public class PKW extends Fahrzeug {
    LocalDate Überprüfungsdatum;
    public PKW(int id, String marke, String modell, int baujahr, double grundpreis,  String überprüfungsdatum) throws IllegalArgumentException {
        super(marke, modell, baujahr, grundpreis, id);
        Überprüfungsdatum = LocalDate.parse(überprüfungsdatum);
    }

    @Override
    public double getRabatt() {
        /* PKW erhalten pro Jahr 5% Rabatt plus 2% pro Jahr das die letzte Überprüfung her ist
         * bis maximal 15%
         */
        double Rabatt = 0.05*this.getAlter()+0.02*this.getJahreSeitÜberprüfung();
        if(Rabatt < 0.15){
            return Rabatt*Grundpreis;
        } else {
            return 0.15 * Grundpreis;
        }
    }

    public LocalDate getÜberprüfungsdatum(){
        return Überprüfungsdatum;
    }

    public long getJahreSeitÜberprüfung(){
        return YEARS.between(Überprüfungsdatum, LocalDate.now());
    }

    @Override
    public String toString() {
        return  "Typ:                   PKW\n" +
                "Id:                    " + Id + "\n" +
                "Marke:                 " + Marke + "\n" +
                "Modell:                " + Modell + "\n" +
                "Baujahr:               " + Baujahr + "\n" +
                "Grundpreis:            " + Grundpreis + "\n" +
                "Überprüfungsdatum:     " + Überprüfungsdatum + "\n" +
                "Preis:                 " + this.getPreis() + "\n";
    }
}
