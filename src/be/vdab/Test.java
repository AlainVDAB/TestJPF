package be.vdab;

import be.vdab.personeel.Bediende;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        var test = new Bediende(45698,new WerknemersDatum(19,04,2020),"Alain", Geslacht.M, BigDecimal.valueOf(2645));

        System.out.println(test.getGeslacht());

    }
}
