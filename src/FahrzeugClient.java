import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

public class FahrzeugClient {

    public static void main(String[] args) {
        PKW test = new PKW("Toyota", "Celica", 1991, 10000, 1, "2014-02-01");
        System.out.println(test.getPreis());
        System.out.println(test.getAlter());

        System.out.println("Hello World");
    }
}
