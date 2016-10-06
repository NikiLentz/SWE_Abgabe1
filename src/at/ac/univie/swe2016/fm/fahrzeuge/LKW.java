package at.ac.univie.swe2016.fm.fahrzeuge;

/**
 * Created by Nikolaus Lentz 1326773 on 05.10.16.
 */
public class LKW extends Fahrzeug{
    public LKW(String marke, String modell, int baujahr, int grundpreis, int id) throws IllegalArgumentException {
        super(marke, modell, baujahr, grundpreis, id);
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
