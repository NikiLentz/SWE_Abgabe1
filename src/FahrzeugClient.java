import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;
import java.util.ArrayList;

/**
 * <h1>FahrzeugClient</h1>
 * Frontend der Fahrzeugverwaltung, implementiert die main methode.
 *
 * @author Nikolaus Lentz 1326773
 * @version 1.0
 */
public class FahrzeugClient {
    /**
     * Die main Methode, erhält alle Befehle als Argument am Start des Programms
     * @param args Liste der möglichen Befehle
     *             args[0]: der Pfad an dem sich die Datei befindet mit der gearbeitet wird
     *             args[1]: der eigentliche Befehl
     *             args[2-7]: weitere Optionen für die jeweiligen Befehle
     */
    public static void main(String[] args) {
        String pfad;
        FahrzeugManagement SpeicherManagement;
        if(args.length < 2) {
            System.out.println("Not enough Arguments");
            System.exit(3);
        }
        pfad = args[0];
        SpeicherManagement = new FahrzeugManagement(pfad);
        switch(args[1]){
            case "show":
                if(args.length == 2) {
                    try {
                        System.out.println(SpeicherManagement.showAll());
                        System.exit(0);
                    } catch(NoSuchFieldException e){
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                } else {
                    int Id = 0;
                    Id = Integer.parseInt(args[2]);
                    System.out.println(SpeicherManagement.showFahrzeug(Id));
                    System.exit(0);
                }
                break;
            case "add":
                Fahrzeug fahrzeug = null;
                if (args.length > 7) {//PKW
                    fahrzeug = new PKW(Integer.parseInt(args[2]), args[3], args[4], Integer.parseInt(args[5]), Double.parseDouble(args[6]), args[7]);
                } else if (args.length == 7) {//LKW
                    fahrzeug = new LKW(Integer.parseInt(args[2]), args[3], args[4], Integer.parseInt(args[5]), Double.parseDouble(args[6]));
                } else {
                    System.out.println("Not enought Arguments!");
                    System.exit(3);
                }
                SpeicherManagement.addFahrzeug(fahrzeug);
                System.out.println("Hinzufügen erfolgreich!");
                System.exit(0);
                break;
            case "del":
                int Id = Integer.parseInt(args[2]);
                SpeicherManagement.removeFahrzeug(Id);
                System.out.println("Löschen erfolgreich!");
                System.exit(0);

                break;
            case "count":
                if(args.length == 2){
                    System.out.println(SpeicherManagement.count(Fahrzeug.class));
                } else if (args[2].equals("PKW")){
                    System.out.println(SpeicherManagement.count(PKW.class));
                } else if (args[2].equals("LKW")){
                    System.out.println(SpeicherManagement.count(LKW.class));
                } else {
                    System.out.println("Falsche Eingabe");
                    System.exit(3);
                }
                System.exit(0);
                break;
            case "meanage":
                //TODO: differentiate between meanage LKW PKW and all in Fahrzeugmanagement
                if(args.length == 2){
                    System.out.println(SpeicherManagement.meanage());
                } else {
                    System.out.println("Falsche Eingabe");
                    System.exit(3);
                }
                System.exit(0);
                break;
            case "meanprice":
                if(args.length == 2){
                    System.out.println(SpeicherManagement.meanprice(Fahrzeug.class));
                } else if (args[2].equals("PKW")){
                    System.out.println(SpeicherManagement.meanprice(PKW.class));
                } else if (args[2].equals("LKW")){
                    System.out.println(SpeicherManagement.meanprice(LKW.class));
                } else {
                    System.out.println("Falsche Eingabe");
                    System.exit(3);
                }
                System.exit(0);
                break;
            case "oldest":
                ArrayList<Integer> oldestList;
                oldestList = SpeicherManagement.oldest();
                for(int i = 0; i < oldestList.size(); i++){
                    System.out.println("Id: " + oldestList.get(i));
                }
                break;
            default:
                System.out.println("Unexpected Argument");
                System.exit(2);
        }

    }


}

