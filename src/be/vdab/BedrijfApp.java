package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BedrijfApp {
    public static void main(String[] args) {
        var personeelsbestand = new Bedrijf();
        try {
            personeelsbestand.voegWerknemerToe(new Arbeider(789, new WerknemersDatum(23, 7, 1980), "Alain", Geslacht.M, BigDecimal.valueOf(10.2)));
        } catch (DatumException | WerknemerException ex) {
            System.out.println(ex.getMessage());
        }
        try {
        personeelsbestand.voegWerknemerToe(new Bediende(569, new WerknemersDatum(12, 10, 1997), "Karen", Geslacht.V, BigDecimal.valueOf(1200.23)));
        } catch (DatumException | WerknemerException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            personeelsbestand.voegWerknemerToe(new Arbeider(457, new WerknemersDatum(26, 3, 2001), "Tilda", Geslacht.V, BigDecimal.valueOf(11.3)));
        } catch (DatumException | WerknemerException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            personeelsbestand.voegWerknemerToe(new Kaderlid(111, new WerknemersDatum(26, 3, 2001), "Alissa", Geslacht.V, BigDecimal.valueOf(20000), Functietitel.CEO));
        } catch (DatumException | WerknemerException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            personeelsbestand.voegWerknemerToe(new Bediende(895, new WerknemersDatum(26, 2, 2001), "Eddy", Geslacht.M, BigDecimal.valueOf(2000)));
        } catch (DatumException | WerknemerException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            personeelsbestand.voegWerknemerToe(new Kaderlid(258, new WerknemersDatum(26, 3, 2008), "Siska", Geslacht.V, BigDecimal.valueOf(12000), Functietitel.MANAGER));
        } catch (DatumException | WerknemerException ex) {
            System.out.println(ex.getMessage());
        }


System.out.println("\nDe volledige lijst");
        personeelsbestand.printLijst();

        System.out.println("\nDe volledige gesorteerde lijst");
        personeelsbestand.gesorteerdeLijst();

        System.out.println("\nDe lijst van arbeiders");
        personeelsbestand.lijstArbeiders();

        System.out.println("\n");
        personeelsbestand.percentageMannelijkeWerknemers();

        personeelsbestand.bewaarLijst();


    }


}
