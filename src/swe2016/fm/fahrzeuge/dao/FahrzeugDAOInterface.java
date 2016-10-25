package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import java.util.ArrayList;

/**
 * <h1>FahrzeugDAOInterface</h1>
 * Enthält Methoden zum Aufrufen und Verändern von Daten in einer Datenquelle.
 *
 * @author Nikolaus Lentz 1326773
 * @version 1.0
 */
public interface FahrzeugDAOInterface {

    /**
     * Gibt eine Liste mit allen gespeicherten Fahrzeugen zurück
     *
     * @return Hier wird die Liste in Form einer ArrayList zurückgegeben.
     */

    ArrayList<Fahrzeug> getFahrzeugList();

    /**
     * Sucht ein Fahrzeug mithilfe seiner ID im Speicher
     *
     * @param id ID des gesuchten Fahrzeuges
     * @return Gibt das gesuchte Fahrzeugobjekt zurück bzw. null wenn es nicht existiert.
     */

    Fahrzeug  getFahrzeugbyId(int id);

    /**
     * Speichert ein Fahrzeug im Speicher
     *
     * @param fahrzeug Dies ist das zu speichernde Fahrzeug
     */

    void speichereFahrzeug(Fahrzeug fahrzeug);

    /**
     * Entfernt ein Fahrzeugobjekt aus dem Speicher
     *
     * @param fahrzeug das zu entfernende Fahrzeugobjekt
     */
    void loescheFahrzeug(Fahrzeug fahrzeug);


}
