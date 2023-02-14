package be.vdab.util;

public enum Geslacht {
    M("man"), V("vrouw");
    private final String voluit;

    Geslacht(String voluit){
        this.voluit=voluit;
    }

    public String getVoluit() {
        return voluit;
    }
}
