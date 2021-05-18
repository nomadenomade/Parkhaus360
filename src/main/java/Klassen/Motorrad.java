package Klassen;

import Interfaces.Fahrzeug;

public class Motorrad implements Fahrzeug {
    private int Id;
    private String Modell;
    private String Farbe;
    private String Marke;

    public Motorrad(int id, String modell, String farbe, String marke) {
        Id = id;
        Modell = modell;
        Farbe = farbe;
        Marke = marke;
    }

    public Motorrad(){

    }

    public void setId(int id) {
        Id = id;
    }

    public void setModell(String modell) {
        Modell = modell;
    }

    public void setFarbe(String farbe) {
        Farbe = farbe;
    }

    public void setMarke(String marke) {
        Marke = marke;
    }




    @Override
    public int getIdFahrzeug() {
        return Id;
    }

    @Override
    public String getMarke() {
        return Marke;
    }

    @Override
    public String getModell() {
        return Modell;
    }

    @Override
    public String getFarbe() {
        return Farbe;
    }

    @Override
    public String toString() {
        return "Motorrad{" +
                "Id=" + Id +
                ", Type='" + Modell + '\'' +
                ", Farbe='" + Farbe + '\'' +
                ", Marke='" + Marke + '\'' +
                '}';
    }
}
