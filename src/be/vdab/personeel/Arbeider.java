package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Arbeider extends Werknemer{
    private BigDecimal uurloon;
    public Arbeider(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal uurloon) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal uurloon) throws WerknemerException {
         this.uurloon = uurloon;
         if (uurloon.compareTo(BigDecimal.valueOf(9.76))<=0){
             throw new WerknemerException("Het opgegeven uurloon is onder het toegestane minimum");
         }
    }

    @Override
    public String toString() {
        return super.toString() + "\t" +uurloon;

    }
}
