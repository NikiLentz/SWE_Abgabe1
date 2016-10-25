package at.ac.univie.swe2016.fm.fahrzeuge;

import java.io.Serializable;
import java.time.Year;

/**
 * <h1>Abstrakte Klasse Fahrzeug</h1>
 * Erstellt Fahrzeugobjekte und enthält Methoden um ihre Werte zu erhalten.
 *
 * @author Nikolaus Lentz
 * @version 1.0
 */

public abstract class Fahrzeug implements Serializable{
    String Marke;
    String Modell;
    int Baujahr;
    double Grundpreis;
    int Id;

    /**
     * Konstruktor, initialisiert alle Variablen
     * @param id eindeutige ID zur Identifizierung
     * @param marke Die Marke des Fahrzeugs
     * @param modell Das Modell des Fahrzeugs
     * @param baujahr   Das Baujahr
     * @param grundpreis Der Preis ohne jeglichen Rabatt
     * @throws IllegalArgumentException Wird geworfen wenn das Baujahr nach dem heurigen Jahr kommt
     */
    public Fahrzeug(int id, String marke, String modell, int baujahr, double grundpreis) throws IllegalArgumentException{
        Marke = marke;
        Modell = modell;
        if(baujahr <= Year.now().getValue()) {
            Baujahr = baujahr;
        } else {
            throw new IllegalArgumentException("Baujahr ungültig!");
        }
        Grundpreis = grundpreis;
        Id = id;
    }

    /**
     * Gibt das Alter des Fahrzeugs zurück
     * @return Das Alter als Integer
     */
    public int getAlter(){
        return Year.now().getValue() - Baujahr;
    }

    /**
     * berechnet den Preis
     * @return Gibt den Preis als double zurück, berechnet aus Grundpreis-Rabatt
     */
    public double getPreis(){
        return Grundpreis - this.getRabatt();
    }

    /**
     * berechnet den Rabatt
     * @return der Rabatt des jeweiligen Fahrzeugs als double Wert
     */
    public abstract double getRabatt();

    /**
     * gibt die Id zurück
     * @return Id als Integer
     */
    public int getId(){
        return this.Id;
    }


}
