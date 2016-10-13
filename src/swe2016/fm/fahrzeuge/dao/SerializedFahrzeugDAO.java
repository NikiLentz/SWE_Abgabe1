package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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


    public SerializedFahrzeugDAO(String pfad){
        Pfad = pfad;
        File data = new File(Pfad);
        if(!data.exists() && !data.isDirectory()) {
            data.getParentFile().mkdirs();
        }
        try {
            fos = new FileOutputStream(Pfad);
            o = new ObjectOutputStream(fos);
            fis = new FileInputStream(Pfad);
            oi = new ObjectInputStream(fis);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Fahrzeug> getFahrzeugList() {
        ArrayList<Fahrzeug> FahrzeugList;
        try {
            FahrzeugList = (ArrayList<Fahrzeug>) oi.readObject();
            return FahrzeugList;
        }catch(ClassNotFoundException e){
            return null;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Fahrzeug getFahrzeugbyId(int id) {
        return null;
    }

    @Override
    public void speichereFahrzeug(Fahrzeug fahrzeug) {
        ArrayList<Fahrzeug> FahrzeugList = new ArrayList<Fahrzeug>();
        if(this.getFahrzeugList() != null) {
            FahrzeugList = this.getFahrzeugList();
        }
            FahrzeugList.add(fahrzeug);
            try {
                o.writeObject(FahrzeugList);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void loescheFahrzeug(Fahrzeug fahrzeug) {

    }
}
