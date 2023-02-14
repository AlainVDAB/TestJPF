package be.vdab.util;

public class WerknemersDatum extends Datum{
    private final static Datum oprichtingsdatum= new Datum(12,02,1977);

    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
    }
}
