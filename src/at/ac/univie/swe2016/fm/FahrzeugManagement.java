package at.ac.univie.swe2016.fm;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;
import java.util.ArrayList;

/**
 * <h1>Fahrzeug Management</h1>
 * Diese Klasse implementiert die Logik der Fahrzeugverwaltung. Hier werden alle Methoden implementiert die
 * FahrzeugClient.java zum Aufrufen und Verändern von Fahrzeugdaten verwendet.
 *
 * @author Nikolaus Lentz 1326773
 * @version 1.0
 */

public class FahrzeugManagement {
    SerializedFahrzeugDAO Speicher;
    ArrayList<Fahrzeug> FahrzeugList =  new ArrayList<>();
    String Pfad;

    /**
     * Initialisiert den Speicher und befüllt FahrzeugList mit allen schon im Speicher vorhandenen Fahrzeugen.
     * @param pfad Das ist der Pfad der Datei in die gespeichert wird
     */
    public FahrzeugManagement(String pfad) {
        Pfad = pfad;
        Speicher = new SerializedFahrzeugDAO(Pfad);
        FahrzeugList = Speicher.getFahrzeugList();
    }

    /**
     * Diese Methode gibt das gesuchte Fahrzeug in Form eines Strings zurück.
     *
     * @param Id Das ist die ID des Fahrzeugs das angezeigt werden soll
     * @return Hier wird ein String mit allen Informationen des Fahrzeugs zurückgegeben
     * @throws IllegalArgumentException Passiert wenn ein Fahrzeug mit der Id nicht im File vorhanden ist
     */

    public String showFahrzeug(int Id) throws IllegalArgumentException{
        try{
            return(Speicher.getFahrzeugbyId(Id).toString());
        } catch(NullPointerException e) {
            throw new IllegalArgumentException("Fahrzeug mit dieser ID existiert nicht!");
        }
    }

    /**
     * Diese Methode gibt alle Fahrzeuge in Form eines Strings zurück.
     *
     * @return Hier wird ein String mit allen Informationen aller Fahrzeuge im Speicher zurückgegeben
     * @throws NoSuchFieldException Passiert wenn der Speicher leer ist
     */

    public String showAll() throws NoSuchFieldException{
        if(Speicher.getFahrzeugList() == null){
            throw new NoSuchFieldException("Nothing found to display");
        }
        String returnString = "";
        for(int i = 0; i < FahrzeugList.size()-1; i++){
            returnString += FahrzeugList.get(i).toString()+"\n";
        }
        returnString += FahrzeugList.get(FahrzeugList.size()-1).toString();
        return returnString;
    }

    /**
     * Fügt dem Speicher ein Fahrzeugobjekt hinzu.
     *
     * @param fahrzeug Das ist das Fahrzeug das hinzugefügt werden soll
     * @throws IllegalArgumentException Passiert wenn die gegebene ID bereits im Speicher vorhanden ist
     */

    public void addFahrzeug(Fahrzeug fahrzeug) throws IllegalArgumentException{
        if(Speicher.getFahrzeugbyId(fahrzeug.getId()) == null){
            Speicher.speichereFahrzeug(fahrzeug);
        } else {
            throw new IllegalArgumentException("ID existiert bereits");
        }
    }

    /**
     * Entfernt ein Fahrzeug aus dem Speicher
     *
     * @param Id Das ist die ID des Fahrzeugs das entfernt werden soll.
     */
    public void removeFahrzeug(int Id){
        Fahrzeug fahrzeug = Speicher.getFahrzeugbyId(Id);
        Speicher.loescheFahrzeug(fahrzeug);
        FahrzeugList = Speicher.getFahrzeugList();
    }

    /**
     * Zählt alle Fahrzeuge einer bestimmten Klasse.
     *
     * @param arg Ist eine Klasse von Fahrzeug. Z.b. Fahrzeug.class oder PKW.class
     * @return Hier wird ein Integer mit der Anzahl der Fahrzeuge zurückgegeben.
     */
    public int count(Class arg){
        int counter = 0;
        for(int i = 0; i<FahrzeugList.size(); i++) {
            if (arg.isInstance(FahrzeugList.get(i))) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Berechnete den Durchschnittspreis aller Fahrzeuge einer bestimmten Klasse
     *
     * @param arg Ist eine Klasse von Fahrzeug. Z.b. Fahrzeug.class oder PKW.class
     * @return Hier wird ein double mit dem Durchschnittspreis der Fahrzeuge zurückgegeben.
     */
    public double meanprice(Class arg){
        int counter = 0;
        double totalprice = 0;
        for(int i = 0; i<FahrzeugList.size(); i++) {
            if (arg.isInstance(FahrzeugList.get(i))) {
                totalprice += FahrzeugList.get(i).getPreis();
                counter++;
            }
        }
        return totalprice/counter;
    }

    /**
     * Berechnet das Durchschnittsalter der Fahrzeuge im Speicher.
     *
     * @return Gibt das Durschnittsalter aller Fahrzeuge im Speicher zurück.
     */

    public double meanage(){
        int counter = 0;
        double totalage = 0;
        for(int i = 0; i<FahrzeugList.size(); i++) {
                totalage += FahrzeugList.get(i).getAlter();
                counter++;
        }
        return totalage/counter;
    }

    /**
     * Befüllt eine Liste mit den Fahrzeug-IDs der ältesten Fahrzeuge.
     *
     * @return Gibt eine ArrayList mit den IDs der jeweiligen Fahrzeuge zurück.
     */

    public ArrayList<Integer> oldest(){
        int oldAge;
        int thisAge;
        int thisId;
        ArrayList<Integer> returnList = new ArrayList<>();
        returnList.add(FahrzeugList.get(0).getId());
        oldAge = FahrzeugList.get(0).getAlter();
        for(int i = 1; i < FahrzeugList.size(); i++){
            thisAge = FahrzeugList.get(i).getAlter();
            thisId = FahrzeugList.get(i).getId();
            if(thisAge > oldAge){
                oldAge = thisAge;
                returnList.clear();
                returnList.add(thisId);
            } else if(thisAge == oldAge){
                returnList.add(thisId);
            }
        }
        return returnList;
    }





}
