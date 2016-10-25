package at.ac.univie.swe2016.fm.fahrzeuge;


import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * <h1>Klasse PKW</h1>
 * Erstellt Fahrzeugobjekte vom Typ PKW und enthält Methoden um ihre Werte zu erhalten.
 *
 * @author Nikolaus Lentz
 * @version 1.0
 */
public class PKW extends Fahrzeug {
    LocalDate Überprüfungsdatum;

    /**
     * Konstruktor, initialisiert alle Variablen
     * @param id eindeutige ID zur Identifizierung
     * @param marke Die Marke des Fahrzeugs
     * @param modell Das Modell des Fahrzeugs
     * @param baujahr   Das Baujahr
     * @param grundpreis Der Preis ohne jeglichen Rabatt
     * @param überprüfungsdatum Das Datum an dem die letzten Überprüfung stattgefunden hat.
     * @throws IllegalArgumentException Wird geworfen wenn das Baujahr nach dem heurigen Jahr, oder das Überprüfungsdatum
     * nach dem heutigen Tag kommt.
     */
    public PKW(int id, String marke, String modell, int baujahr, double grundpreis,  String überprüfungsdatum) throws IllegalArgumentException {
        super(id, marke, modell, baujahr, grundpreis);
        Überprüfungsdatum = LocalDate.parse(überprüfungsdatum);
        if (Überprüfungsdatum.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Ungültiges Datum");
        }
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

    /**
     * Berechnet die Jahre die seit der letzten Überprüfung vergangen sind
     * @return gibt Jahre als long zurück.
     */
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
