import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;

public class FahrzeugClient {

    public static void main(String[] args) {
        PKW test = new PKW("Toyota", "Celica", 2014, 10000, 1, "2014-11-01");
        LKW lkwtest = new LKW("MAN", "xy", 2010, 10000, 1);
        SerializedFahrzeugDAO speicher = new SerializedFahrzeugDAO("test/test.ser");
        //System.out.println(lkwtest.toString());
        //System.out.println(test.toString());
        speicher.speichereFahrzeug(test);
        speicher.speichereFahrzeug(lkwtest);

        System.out.println("Hello World");
    }
}
