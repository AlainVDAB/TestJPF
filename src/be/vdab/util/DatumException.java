package be.vdab.util;

public class DatumException extends RuntimeException{
    private Datum fouteDatum;
    public DatumException(){};
    public DatumException(String omschrijving){
        super(omschrijving);
    };
    public DatumException(String omschrijving, Datum fouteDatum){
        super(omschrijving);
        this.fouteDatum=fouteDatum;
    };

    public Datum getFouteDatum() {
        return fouteDatum;
    }
}
