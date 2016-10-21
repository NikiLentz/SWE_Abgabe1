package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Nikolaus Lentz 1326773 on 07.10.16.
 */
public class SerializedFahrzeugDAO implements FahrzeugDAOInterface {

    String Pfad;
    OutputStream fos = null;
    FileInputStream fis = null;
    ObjectOutputStream o = null;
    ObjectInputStream oi = null;
    ArrayList<Fahrzeug> FahrzeugList = new ArrayList<>();


    public SerializedFahrzeugDAO(String pfad){
        Pfad = pfad;
        Boolean FileExists = true;
        File data = new File(Pfad);
        if(!data.exists() && !data.isDirectory()) {
            data.getParentFile().mkdirs();
            FileExists = false;
        }
        try {
            fos = new FileOutputStream(Pfad, true);
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        if(FileExists == true) {
            try {
                fis = new FileInputStream(Pfad);
                oi= new ObjectInputStream(fis);
                FahrzeugList = (ArrayList<Fahrzeug>) oi.readObject();
                System.out.println("SIZE:" + FahrzeugList.size());
                oi.close();
                fis.close();
            } catch(IOException e){
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        } else {

        }
    }
    @Override
    public ArrayList<Fahrzeug> getFahrzeugList() {
        this.writeToFile();
        return FahrzeugList;
    }

    @Override
    public Fahrzeug getFahrzeugbyId(int id) {
        Fahrzeug fahrzeug;
        for(int i=0; i < FahrzeugList.size(); i++){
            fahrzeug = FahrzeugList.get(i);
            if(fahrzeug.getId() == id){
                return fahrzeug;
            }
        }
        return null;//Fahrzeug mit dieser ID existiert nicht im File
    }

    @Override
    public void speichereFahrzeug(Fahrzeug fahrzeug) {
        FahrzeugList.add(fahrzeug);
        this.writeToFile();
    }

    @Override
    public void loescheFahrzeug(Fahrzeug fahrzeug) {
        FahrzeugList.remove(fahrzeug);
        this.writeToFile();
    }

    private void writeToFile(){
        try {
            fos = new FileOutputStream(Pfad,false);
            o = new ObjectOutputStream(fos);
            //System.out.println("writing to file");
            o.writeObject(FahrzeugList);
            o.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
