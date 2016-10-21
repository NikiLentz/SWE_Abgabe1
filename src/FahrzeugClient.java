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
                    System.out.println(SpeicherManagement.showAll());
                    System.exit(1);
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
                //TODO: Catch illegalArgumentExceptions
                //TODO: also throw more IllegalArgumentExceptions in the Constructors;
                Fahrzeug fahrzeug = null;
                if(args.length > 7) {//PKW
                    fahrzeug = new PKW(Integer.parseInt(args[2]), args[3], args[4], Integer.parseInt(args[5]), Double.parseDouble(args[6]), args[7]);
                } else if(args.length == 6){//LKW
                    fahrzeug = new LKW(Integer.parseInt(args[2]), args[3], args[4], Integer.parseInt(args[5]), Double.parseDouble(args[6]));
                } else{
                    System.out.println("Not enought Arguments!");
                    System.exit(1);
                }
                SpeicherManagement.addFahrzeug(fahrzeug);

                break;
            case "del":
                break;
            case "count":
                break;
            case "meanage":
                break;
            case "meanprice":
                break;
            case "oldest":
                break;
            default:
                System.out.println("Unexpected Argument");
                System.exit(1);
        }

        }

    }

