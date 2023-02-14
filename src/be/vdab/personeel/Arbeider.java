package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer implements Serializable {
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
        return super.toString() + "\t" +uurloon + "\t" + getVerloning() ;

    }

    @Override
    public BigDecimal getVerloning(){
    var maalGetal = new BigDecimal(7.6*65/3);
     return uurloon.multiply(maalGetal).divide(BigDecimal.ONE,2,RoundingMode.HALF_UP);
    }
}
