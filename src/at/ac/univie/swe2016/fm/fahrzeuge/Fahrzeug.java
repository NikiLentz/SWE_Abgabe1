package at.ac.univie.swe2016.fm.fahrzeuge;

import java.time.Year;

/**
 * Created by Nikolaus Lentz 1326773 on 05.10.16.
 */

abstract class Fahrzeug {
    String Marke;
    String Modell;
    int Baujahr;
    double Grundpreis;
    int Id;

    public Fahrzeug(String marke, String modell, int baujahr, double grundpreis, int id) throws IllegalArgumentException{
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

    public int getAlter(){
        return Year.now().getValue() - Baujahr;
    }

    public double getPreis(){
        return Grundpreis - this.getRabatt();
    }

    public abstract double getRabatt();


}
