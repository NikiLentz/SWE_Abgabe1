/**
 * Created by Nikolaus Lentz 1326773 on 07.10.16.
 */
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import java.util.ArrayList;

public interface FahrzeugDAOInterface {

    ArrayList<Fahrzeug> getFahrzeugList();

    Fahrzeug  getFahrzeugbyId(int id);

    void speichereFahrzeug(Fahrzeug fahrzeug);

    void loescheFahrzeug(Fahrzeug fahrzeug);


}
