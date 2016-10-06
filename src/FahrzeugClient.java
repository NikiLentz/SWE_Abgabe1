import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

public class FahrzeugClient {

    public static void main(String[] args) {
        PKW test = new PKW("Toyota", "Celica", 2014, 10000, 1, "2014-11-01");
        LKW lkwtest = new LKW("MAN", "xy", 2010, 10000, 1);

        System.out.println(lkwtest.toString());
        System.out.println(test.toString());

        System.out.println("Hello World");
    }
}
