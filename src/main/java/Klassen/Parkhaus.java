package Klassen;

import Interfaces.Fahrzeug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parkhaus {
    private int Anzahl_Etage;
    private int Anzahl_parkplatz_pro_etage;
    private Map<Integer,List<Parkplatz>> Parkhaus_Bau;



    public Parkhaus(Map<Integer , List<Parkplatz>> parkhaus_Bau){
        this.Parkhaus_Bau= parkhaus_Bau;
    }
    public Parkhaus(){

    }
   //Parkhaus ertellen
    public void createParkhaus(){
        Map<Integer,List<Parkplatz>> neuBau= new HashMap<>();
        for (int etagenummer=0;etagenummer<Anzahl_Etage;etagenummer++){
            List<Parkplatz>parkplatzList= new ArrayList<>();
            for (int platznummer=0;platznummer<Anzahl_parkplatz_pro_etage;platznummer++){
                parkplatzList.add(new Parkplatz(platznummer,etagenummer));
            }
            neuBau.put(etagenummer,parkplatzList);

        }
        Parkhaus_Bau = neuBau;
    }

    public void setAnzahl_Etage(int anzahl_Etage) {
        Anzahl_Etage = anzahl_Etage;
    }

    public void setAnzahl_parkplatz_pro_etage(int anzahl_parkplatz_pro_etage) {
        Anzahl_parkplatz_pro_etage = anzahl_parkplatz_pro_etage;
    }
  //Autos befahren das Parkhaus
    public void Parkhaus_befahren(Fahrzeug fahrzeug){
        if (findFahrzeug(fahrzeug)!=null){
           System.out.println("Auto schon vorhanden");
        }else{
            boolean check = false;
            for (Map.Entry entry: Parkhaus_Bau.entrySet()) {
                if (entry.getValue()!=null){
                    for (Parkplatz parkplatz: (List<Parkplatz>)entry.getValue()) {

                       if (parkplatz.isbesetz()==false){
                            parkplatz.setFahrzeug(fahrzeug);
                            parkplatz.setbesetz(true);
                            check= true;
                            System.out.println("Das Fahrzeug mit dem Id:"+fahrzeug.getIdFahrzeug()+" bekommt den Platz :"+parkplatz.getPlatznummer()+" Etage :"+parkplatz.getEtagenummer());
                            break;

                            }


                    }
                    if (check==true){
                        break;
                    }
                }
            }

        }

    }
    // Autos verlassen das Parkhaus
    public void Parkhaus_verlassen(Fahrzeug fahrzeug){
        Parkplatz parkplatz= findFahrzeug(fahrzeug);
        if (parkplatz!=null){
            parkplatz.setbesetz(false);
            parkplatz.setFahrzeug(null);
            System.out.println("parkhaus erfolgreich verlassen...!!!!!!!!");
        }


    }
    //Hilffunktion zum Finden eines Fahrzeugs
    public Parkplatz findFahrzeug(Fahrzeug fahrzeug){
        Parkplatz parkplatz2= null;
        boolean check = false;
        for (Map.Entry entry: Parkhaus_Bau.entrySet()) {
            if (entry.getValue()!=null){
                for (Parkplatz parkplatz: (List<Parkplatz>)entry.getValue()) {
                    if(getAnzahl_freie_Parkplaetze()>0){
                        if (parkplatz.isbesetz()==true){
                            if (fahrzeug.getIdFahrzeug()== parkplatz.getFahrzeug().getIdFahrzeug()){
                                parkplatz2 = parkplatz;
                                check=true;
                                break;
                            }
                        }

                    }else{
                        System.out.println("Error-----------------------------------------------!");
                        System.out.println("Das Fahrzeug :"+fahrzeug.toString()+" konnte nicht eingefügt werden");
                        System.out.println("Es gibt keine freie Parkplätze mehr");
                        check=true;
                        break;
                    }

                }
            }
            if (check==true){
                break;
            }
        }
        return parkplatz2;
    }

    //Parkhaus bekommen
    public Map<Integer, List<Parkplatz>> getParkhaus_Bau() {
        return Parkhaus_Bau;
    }


    //Liste von Fahrzeug im Parkhaus
    public List<Fahrzeug> ListAuto_vom_Parkhaus(){
        List<Fahrzeug> fahrzeugList = new ArrayList<>();
        for (Map.Entry entry: Parkhaus_Bau.entrySet()) {
            if (entry.getValue()!=null){
                for (Parkplatz parkplatz: (List<Parkplatz>)entry.getValue()) {
                    if (parkplatz.isbesetz()==true){
                       fahrzeugList.add(parkplatz.getFahrzeug());
                    }
                }
            }
        }
        return fahrzeugList;
    }

    public int getAnzahl_freie_Parkplaetze(){
        int Anzahl=0;
        for (Map.Entry entry: Parkhaus_Bau.entrySet()) {
            for (Parkplatz parkplatz:(List<Parkplatz>)entry.getValue()) {
                if (parkplatz.isbesetz()==false){
                    Anzahl++;
                }
            }
        }
        return Anzahl;
    }

}
