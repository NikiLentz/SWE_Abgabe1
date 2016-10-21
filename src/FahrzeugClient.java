import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;

import java.util.ArrayList;

public class FahrzeugClient {

    public static void main(String[] args) {
        String pfad;
        FahrzeugManagement SpeicherManagement;
        if(args.length < 2) {
            System.out.println("Not enough Arguments");
            System.exit(1);
        }
        pfad = args[0];
        SpeicherManagement = new FahrzeugManagement(pfad);
        switch(args[1]){
            case "show":
                if(args.length == 2) {
                    try {
                        System.out.println(SpeicherManagement.showAll());
                        System.exit(1);
                    } catch(NoSuchFieldException e){
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                } else {
                    try {
                        int Id = 0;
                        try {
                            Id = Integer.parseInt(args[2]);
                        } catch(Exception e) {
                            System.out.println("This is not a valid Id");
                            System.exit(1);
                        }
                        System.out.println(SpeicherManagement.showFahrzeug(Id));
                        System.exit(1);
                    } catch(IllegalArgumentException  e) {
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                }
                break;
            case "add":
                //TODO maybe change the way I handle wrong inputs(e.g.: abc as year)
                Fahrzeug fahrzeug = null;
                try {
                    if (args.length > 7) {//PKW
                        fahrzeug = new PKW(Integer.parseInt(args[2]), args[3], args[4], Integer.parseInt(args[5]), Double.parseDouble(args[6]), args[7]);
                    } else if (args.length == 7) {//LKW
                        fahrzeug = new LKW(Integer.parseInt(args[2]), args[3], args[4], Integer.parseInt(args[5]), Double.parseDouble(args[6]));
                    } else {
                        System.out.println("Not enought Arguments!");
                        System.exit(1);
                    }
                    SpeicherManagement.addFahrzeug(fahrzeug);
                    System.out.println("Hinzufügen erfolgreich!");
                    System.exit(1);
                } catch(IllegalArgumentException e){
                    System.out.println("Falsche Eingabe \n" + e.getMessage());
                    System.exit(1);
                }
                break;
            case "del":
                try{
                    int Id = Integer.parseInt(args[2]);
                    SpeicherManagement.removeFahrzeug(Id);
                    System.out.println("Löschen erfolgreich!");
                    System.exit(1);
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
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
                }
                break;
            case "meanage":
                //TODO: differentiate between meanage LKW PKW and all in Fahrzeugmanagement
                if(args.length == 2){
                    System.out.println(SpeicherManagement.meanage());
                } else {
                    System.out.println("Falsche Eingabe");
                }
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
                }

                break;
            case "oldest":
                break;
            default:
                System.out.println("Unexpected Argument");
                System.exit(1);
        }

        }


    }

