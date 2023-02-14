package be.vdab;

import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Zusterbedrijf implements Serializable {

    private final static Path PAD = Path.of("/data/personeel.dat");
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        var personeelsbestand = new Bedrijf();

        if (Files.exists(PAD)) {
            try (var stream = new ObjectInputStream(
                    Files.newInputStream(PAD))) {

                personeelsbestand = (Bedrijf) stream.readObject();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());

            }

            personeelsbestand.printLijst();


    }

}
