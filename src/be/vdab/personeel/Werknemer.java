package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

public class Werknemer implements Comparable<Werknemer>{
    //**********Personeelsnummer AANPASSEN. ook met exception werken?
    private final int personeelsnummer;
    private WerknemersDatum datumInDienst;
    private String naam;
    private Geslacht geslacht;

    public Werknemer(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht) {
        this.personeelsnummer = personeelsnummer;
        this.datumInDienst = datumInDienst;
        this.naam = naam;
        this.geslacht = geslacht;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    public void setDatumInDienst(WerknemersDatum datumInDienst) {
        this.datumInDienst = datumInDienst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    @Override
    public int compareTo(Werknemer w) {
        return personeelsnummer - w.getPersoneelsnummer();
    }

    @Override
    public String toString() {
        return personeelsnummer + "\t" + datumInDienst + "\t" + naam + "\t" + geslacht.getVoluit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Werknemer werknemer)) return false;

        return getPersoneelsnummer() == werknemer.getPersoneelsnummer();
    }

    @Override
    public int hashCode() {
        return getPersoneelsnummer();
    }
}
