package be.vdab.util;

public class WerknemersDatum extends Datum{
    private final static Datum oprichtingsdatum= new Datum(12,02,1977);

    public WerknemersDatum(int dag, int maand, int jaar) throws DatumException {
        super(dag, maand, jaar);
        if(!checkWerknemersDatum(dag,maand,jaar)){
            throw new DatumException("De opgegeven datum is voor de oprichtingsdatum");
        }
    }

    public boolean checkWerknemersDatum(int dag, int maand, int jaar){
        var test = new Datum(dag,maand,jaar);
        return test.compareTo(oprichtingsdatum)>=0;
    }
}
