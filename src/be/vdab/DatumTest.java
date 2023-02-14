package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemersDatum;

import java.util.ArrayList;
import java.util.List;

public class DatumTest {
    private static List data = new ArrayList<Datum>();

    public static void nieuweTest(int dag, int maand, int jaar) {
        try {
            data.add(new WerknemersDatum(dag, maand, jaar));
        } catch (DatumException x) {
            System.out.println(x.getMessage());
        }

    }

    public static void main(String[] args) {

        nieuweTest(19, 4, 1983);
        nieuweTest(29, 2, 1700);
        nieuweTest(29, 2, 2000);
        nieuweTest(29, 2, 1997);
        nieuweTest(14, 13, 1400);
        nieuweTest(14, 13, 2020);
        nieuweTest(29, 2, 1996);
        nieuweTest(10, 2, 1960);

        for (var datum : data) {
            System.out.println(datum + " - "+ datum.hashCode());

        }


    }
}