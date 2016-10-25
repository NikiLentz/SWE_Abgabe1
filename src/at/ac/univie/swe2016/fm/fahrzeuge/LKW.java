package at.ac.univie.swe2016.fm.fahrzeuge;

/**
 * <h1>Klasse LKW</h1>
 * Erstellt Fahrzeugobjekte vom Typ LKW und enthält Methoden um ihre Werte zu erhalten.
 *
 * @author Nikolaus Lentz
 * @version 1.0
 */
public class LKW extends Fahrzeug{
    /**
     * Konstruktor, initialisiert alle Variablen
     * @param id eindeutige ID zur Identifizierung
     * @param marke Die Marke des Fahrzeugs
     * @param modell Das Modell des Fahrzeugs
     * @param baujahr   Das Baujahr
     * @param grundpreis Der Preis ohne jeglichen Rabatt
     * @throws IllegalArgumentException Wird geworfen wenn das Baujahr nach dem heurigen Jahr kommt
     */
    public LKW(int id, String marke, String modell, int baujahr, double grundpreis) throws IllegalArgumentException {
        super(id, marke, modell, baujahr, grundpreis);
    }

    @Override
    public double getRabatt() {
        /* pro Jahr beträgt der Rabatt 5 prozent
         * also 5/100 des grundpreises
         * maximal ist ein Rabatt von 20 prozent möglich
         * dieser ist erreicht, wenn der LKW älter als
         * 4 Jahre ist.
         */
        int Alter = this.getAlter();
        if(Alter < 4) {
            return Alter * 0.05 * Grundpreis;
        } else {
            return Grundpreis*0.2;
        }
    }

    @Override
        public String toString() {
            return  "Typ:                   LKW\n" +
                    "Id:                    " + Id + "\n" +
                    "Marke:                 " + Marke + "\n" +
                    "Modell:                " + Modell + "\n" +
                    "Baujahr:               " + Baujahr + "\n" +
                    "Grundpreis:            " + Grundpreis + "\n" +
                    "Preis:                 " + this.getPreis() + "\n";
        }
}
