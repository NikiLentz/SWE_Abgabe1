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
        return 0;
    }
}
