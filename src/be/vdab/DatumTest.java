package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

import java.util.ArrayList;

public class DatumTest {

    public static void main(String[] args) {
        var data = new ArrayList<Datum>();
        try {
            data.add(new Datum(29, 2, 1700));
        } catch (DatumException x) {
            System.out.println(x.getMessage());
        }
        data.add(new Datum(14, 2, 1983));

        for (var datum : data) {
            System.out.println(datum);

        }


    }
}