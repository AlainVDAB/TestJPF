package be.vdab.personeel;

import be.vdab.util.DatumException;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Bedrijf implements Serializable {
    private List<Werknemer> bedrijfslijst=new ArrayList<>();
    private final static Path PAD = Path.of("/data/personeel.dat");
    private static final long serialVersionUID = 1L;



    public List<Werknemer> getBedrijfslijst() {
        return bedrijfslijst;
    }

    public void voegWerknemerToe(Werknemer werknemer) {
        if (!bedrijfslijst.contains(werknemer)) {
            bedrijfslijst.add(werknemer);
        }
        ;
    }

    public void printLijst() {
        bedrijfslijst.stream()
                .forEach(System.out::println);

    }

    public void gesorteerdeLijst() {
        bedrijfslijst.stream()
                .sorted()
                .forEach(System.out::println);
    }

   public void lijstArbeiders(){
       bedrijfslijst.stream()
               .filter(werknemer -> werknemer instanceof Arbeider)
               .forEach(System.out::println);
    }

    public void percentageMannelijkeWerknemers(){
        var totaalAantal = bedrijfslijst.size();

        var aantalMannen = bedrijfslijst.stream()
                .map(werknemer -> werknemer.getGeslacht())
                .filter(man-> man==Geslacht.M)
                .count();

         var percentage= aantalMannen*100/totaalAantal;
         System.out.println("Het percentage aan mannen is " + percentage +"%");


    }

    public void bewaarLijst(){

            try (var stream = new ObjectOutputStream(
                    Files.newOutputStream(PAD))) {
                stream.writeObject(bedrijfslijst);
            } catch (IOException ex) {
                System.err.println(ex);
            }
    }

    public void leesLijst(){
        if (Files.exists(PAD)) {
            try (var stream = new ObjectInputStream(
                    Files.newInputStream(PAD))) {
                //System.out.println("test");
                bedrijfslijst= (ArrayList<Werknemer>) stream.readObject();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());



            }

    }


    }}




