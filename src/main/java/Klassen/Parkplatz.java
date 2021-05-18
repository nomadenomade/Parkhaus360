package Klassen;

import Interfaces.Fahrzeug;

public class Parkplatz {
    private int Platznummer;
    int Etagenummer;
    private boolean besetz= false;
    private Fahrzeug fahrzeug;


    public Parkplatz(int platznummer, int etagenummer) {
        Platznummer = platznummer;
        Etagenummer = etagenummer;
    }
    public Parkplatz(){

    }



    public boolean isbesetz() {
        return besetz;
    }

    public void setbesetz(boolean besetz) {
        this.besetz = besetz;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    @Override
    public String toString() {
        return "Parkplatz{" +
                "Platznummer=" + Platznummer +
                ", Etagenummer=" + Etagenummer +
                ", besetz=" + besetz +
                ", fahrzeug=" + fahrzeug +
                '}';
    }

    public int getPlatznummer() {
        return Platznummer;
    }

    public void setPlatznummer(int platznummer) {
        Platznummer = platznummer;
    }

    public int getEtagenummer() {
        return Etagenummer;
    }

    public void setEtagenummer(int etagenummer) {
        Etagenummer = etagenummer;
    }
}
