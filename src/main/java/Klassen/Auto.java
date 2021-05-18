package Klassen;

import Interfaces.Fahrzeug;

public class Auto implements Fahrzeug {
    private int Id;
    private String Modell;
    private String Farbe;
    private String Marke;

    public Auto(){

    }

    public Auto(int Id ,String Type,String Farbe,String Marke){
        this.Id=Id;
        this.Modell= Type;
        this.Farbe=Farbe;
        this.Marke=Marke;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setType(String type) {
        Modell = type;
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
        return "Auto{" +
                "Id=" + Id +
                ", Type='" + Modell + '\'' +
                ", Farbe='" + Farbe + '\'' +
                ", Marke='" + Marke + '\'' +
                '}';
    }
}
