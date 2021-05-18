package Klassen;

import Interfaces.Fahrzeug;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestKlasse {

    public static void main(String[] arg){
        //Grundinfos für Autos definieren
        String[] Farben= {"Blau","Rot","grün","schwarz","Weiss","Orange"};
        String[] Marke = {"Vw","Mercedes","mazda","Opel","Nissan","Renaut","Mitzubishi"};
        String[] Model = {"Combi","Cs5","C3"};
        Random random = new Random();
        int Anzahl_etage =2;
        int Anzahl_parkplatz_pro_etage=5;



        //Parkhaus bauen und auf Parkplätzeanwesenheit testen
        System.out.println("....................................................");
        System.out.println("Test auf Aufbau eines Parkhauses");
        System.out.println("....................................................");
        System.out.println("Parkhaus mit Anzahl Etagen :"+Anzahl_etage+", Anzahl Parkplätze pro Etage:"+Anzahl_parkplatz_pro_etage);
        Parkhaus parkhaus = new Parkhaus();
        parkhaus.setAnzahl_Etage(2);
        parkhaus.setAnzahl_parkplatz_pro_etage(5);
        parkhaus.createParkhaus();
        System.out.println("Mehr Beschreibung");
        for (Map.Entry entry:(parkhaus.getParkhaus_Bau()).entrySet()) {
            for (Parkplatz parkplatz: (List<Parkplatz>)entry.getValue()) {
                System.out.print("Etagenummer :"+entry.getKey()+", Platznummer:"+parkplatz.getPlatznummer());
                System.out.println("");
            }
        }

        //Test auf das Anfahren von Autos ins Parkhaus
        System.out.println("");
        System.out.println("");
        System.out.println(".................................................");
        System.out.println("Test auf das Anfahren von Auto ins Parkhaus");
        System.out.println(".................................................");

        List<Fahrzeug> fahrzeugList = new ArrayList<>();

        for (int Anzahlauto=0;Anzahlauto<25;Anzahlauto++){
            fahrzeugList.add(new Auto(random.nextInt(60000000),Model[random.nextInt(3)],Farben[random.nextInt(6)],Marke[random.nextInt(7)]));
        }
        parkhaus.Parkhaus_befahren(fahrzeugList.get(0));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(2));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(5));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(7));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(10));


        //aktuelle Liste von Fahrzeug
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("aktuelle Liste von Fahrzeug im Parkhaus!");
        System.out.println("..................................................");
        for (Fahrzeug a: parkhaus.ListAuto_vom_Parkhaus()) {
            System.out.println(a);
        }

        //Test : Ein Auto verlässt das Parkhaus
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("Test: Ein Auto verlässt das Parkhaus");
        System.out.println("..................................................");
        System.out.println("folgende Fahrzeug verlassen das Parkhaus:");
        System.out.println((Auto)fahrzeugList.get(5));
        parkhaus.Parkhaus_verlassen(fahrzeugList.get(5));


        //aktuelle Liste von Fahrzeug
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("aktuelle Liste von Fahrzeug im Parkhaus!");
        System.out.println("..................................................");
        for (Fahrzeug a: parkhaus.ListAuto_vom_Parkhaus()) {
            System.out.println(a);
        }


        //Einfügung eines neuen ankommenden Fahrzeug
        System.out.println("");
        System.out.println("");
        System.out.println("...................................................");
        System.out.println("Einfügung eines neuen ankommenden Fahrzeug");
        System.out.println("....................................................");
        Fahrzeug motorrad = new Motorrad(517354223,"C28","Orange","Mitzubishi");
        parkhaus.Parkhaus_befahren(motorrad);

        //aktuelle Liste von Fahrzeug
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("aktuelle Liste von Fahrzeug im Parkhaus!");
        System.out.println("..................................................");
        for (Fahrzeug a: parkhaus.ListAuto_vom_Parkhaus()) {
            System.out.println(a);
        }

        //Der Verwalter will ein Fahrzeug finden
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("Der Verwalter will ein Fahrzeug im Parkhaus finden!");
        System.out.println("..................................................");
        System.out.println("Er will das folgende Fahrzeug haben!");
        System.out.println(parkhaus.ListAuto_vom_Parkhaus().get(3));
        System.out.println("Systemergebnisse-----------------------------------!");
        System.out.println(parkhaus.findFahrzeug(parkhaus.ListAuto_vom_Parkhaus().get(3)));


        //Test auf Anzahl freie Parkplätze
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("Test auf Anzahl freie Parkplätze");
        System.out.println("..................................................");
        System.out.println("Anzahl von freien Parkplätze :"+parkhaus.getAnzahl_freie_Parkplaetze());


        //Test auf Parkhaus vollbesetzt
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("Test auf Parkhaus vollbesetzt");
        System.out.println("..................................................");
        parkhaus.Parkhaus_befahren(fahrzeugList.get(15));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(16));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(17));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(18));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(19));
        parkhaus.Parkhaus_befahren(fahrzeugList.get(20));


        //aktuelle Liste von Fahrzeug
        System.out.println("");
        System.out.println("");
        System.out.println("..................................................");
        System.out.println("aktuelle Liste von Fahrzeug im Parkhaus!");
        System.out.println("..................................................");
        for (Fahrzeug a: parkhaus.ListAuto_vom_Parkhaus()) {
            System.out.println(a);
        }

    }
}
