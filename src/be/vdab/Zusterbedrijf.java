package be.vdab;

import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Zusterbedrijf{

    public static void main(String[] args) {
        var personeelsbestand = new Bedrijf();


        personeelsbestand.leesLijst();


        personeelsbestand.printLijst();


    }

}
