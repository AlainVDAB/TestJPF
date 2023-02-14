package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.util.Functietitel;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;

public class Kaderlid extends Bediende implements Serializable {
    private Functietitel functietitel;
    public Kaderlid(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde, Functietitel functietitel) {
        super(personeelsnummer, datumInDienst, naam, geslacht, maandwedde);
        setFunctietitel(functietitel);

    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }
//****Hier moet ik nog een exception in steken.
    public void setFunctietitel(Functietitel functietitel) {
        this.functietitel = functietitel;
    }

    @Override
    public String toString() {
        return super.toString() +"\t" + functietitel.toString().toLowerCase();
    }
}
