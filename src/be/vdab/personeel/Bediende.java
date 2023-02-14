package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bediende extends Werknemer implements Serializable {
    private BigDecimal maandwedde;
    public Bediende(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setMaandwedde(maandwedde);
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public void setMaandwedde(BigDecimal maandwedde) throws WerknemerException {
        this.maandwedde = maandwedde;
        if (maandwedde.compareTo(BigDecimal.valueOf(1129.47))<=0){
            throw new WerknemerException("De opgegeven maandwedde is onder het toegestane minimum");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\t" +maandwedde + "\t" + getVerloning();

    }
@Override
public BigDecimal getVerloning(){
        return maandwedde;
}

}
