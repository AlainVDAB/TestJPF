package be.vdab.util;

public class Datum implements IDatum, Comparable<Datum> {
    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {

        if (checkJaar(jaar)) {
            this.jaar = jaar;
        } else {
            throw new DatumException("Het opgegeven jaar is niet in het opgegeven bereik (1584 t.e.m. 4099)");
        }
        if (checkMaand(maand)) {
            this.maand = maand;
        } else {
            throw new DatumException("De opgegeven maand klopt niet (1 t.e.m. 12)");
        }

        if (checkDag(dag)) {
            this.dag = dag;
        } else {
            throw new DatumException("De opgegeven dag klopt niet");
        }


    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        return dag + "/" + maand + "/" + jaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Datum datum)) return false;

        if (getDag() != datum.getDag()) return false;
        if (getMaand() != datum.getMaand()) return false;
        return getJaar() == datum.getJaar();
    }

    @Override
    public int hashCode() {
        int result = getDag() + getMaand() * 100 + getJaar() * 10000;
        return result;
    }

    @Override
    public int compareTo(Datum d) {
        return this.hashCode() - d.hashCode();
    }


    private boolean checkJaar(int jaar) {
        return jaar >= 1584 && jaar <= 4099;
    }

    private boolean checkMaand(int maand) {
        return maand >= 1 && maand <= 12;
    }

    private boolean checkDag(int dag) {
        return switch (maand) {
            case 1, 3, 5, 7, 8, 10, 12 -> dag >= 1 && dag <= 31;
            case 4, 6, 9, 11 -> dag >= 1 && dag <= 30;
            case 2 -> dag >= 1 && dag <= febMaxSchrikkeljaar(jaar);
            default -> throw new DatumException("Er liep iets grondig fout");
            };

        }





    private int febMaxSchrikkeljaar(int jaar) {
        if (jaar % 4 == 0) return 29;
        if (jaar % 100 == 0) return 28;
        if (jaar % 400 == 0) return 29;
        else return 28;

    }


}




