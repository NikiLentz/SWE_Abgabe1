package at.ac.univie.swe2016.fm;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Nikolaus Lentz 1326773 on 18.10.16.
 */
public class FahrzeugManagement {
    SerializedFahrzeugDAO Speicher;
    ArrayList<Fahrzeug> FahrzeugList =  new ArrayList<>();
    Boolean ListEmpty = true;
    String Pfad;

    public FahrzeugManagement(String pfad) {
        Pfad = pfad;
        Speicher = new SerializedFahrzeugDAO(Pfad);
        FahrzeugList = Speicher.getFahrzeugList();
        if(FahrzeugList != null){
            ListEmpty = false;
        }
    }

    public String showFahrzeug(int Id) throws IllegalArgumentException{
        try{
            return(Speicher.getFahrzeugbyId(Id).toString());
        } catch(NullPointerException e) {
            throw new IllegalArgumentException("Fahrzeug mit dieser ID existiert nicht!");
        }
    }

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

    public void addFahrzeug(Fahrzeug fahrzeug) throws IllegalArgumentException{
        if(Speicher.getFahrzeugbyId(fahrzeug.getId()) == null){
            Speicher.speichereFahrzeug(fahrzeug);
        } else {
            throw new IllegalArgumentException("ID existiert bereits");
        }
    }

    public void removeFahrzeug(int Id){
        Fahrzeug fahrzeug = Speicher.getFahrzeugbyId(Id);
        Speicher.loescheFahrzeug(fahrzeug);
        FahrzeugList = Speicher.getFahrzeugList();
    }

    public int count(Class arg){
        int counter = 0;
        for(int i = 0; i<FahrzeugList.size(); i++) {
            if (arg.isInstance(FahrzeugList.get(i))) {
                counter++;
            }
        }
        return counter;
    }

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

    public double meanage(){
        int counter = 0;
        double totalage = 0;
        for(int i = 0; i<FahrzeugList.size(); i++) {
                totalage += FahrzeugList.get(i).getAlter();
                counter++;
        }
        return totalage/counter;
    }

    public ArrayList<Integer> oldest(){
        int oldAge;
        int thisAge;
        int thisId;
        ArrayList<Integer> returnList = new ArrayList<>();
        returnList.set(0, FahrzeugList.get(0).getId());
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
