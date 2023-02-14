package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

public class Arbeider extends Werknemer{
    public Arbeider(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
    }
}
