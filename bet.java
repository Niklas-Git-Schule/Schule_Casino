public class bet{
    private int zahl_bereich;
    private int einsatz;
    private int zahl;

    public bet (int zahl_bereich, int einsatz){
        this.zahl_bereich = zahl_bereich;
        this.einsatz = einsatz;
    }
    public bet (int zahl_bereich, int einsatz, int zahl){
        this.zahl_bereich = zahl_bereich;
        this.einsatz = einsatz;
        this.zahl = zahl;
    }

    public int getEinsatz() {
        return einsatz;
    }

    public int getZahl() {
        return zahl;
    }

    public int getZahl_bereich() {
        return zahl_bereich;
    }
}
