import java.util.*;
import java.io.File;
import java.lang.Object;
import javax.sound.sampled.*;

public class Roulette extends Spiel{
    private int spieleNr = 7;
    private int[] rouletteRad = new int[]{0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
    /**
     * Bets:
     * 0 = Einzelne Zahlen
     * 1 = Rote Zahlen
     * 2 = Schwarze Zahlen
     * 3 = Gerade Zahlen
     * 4 = Ungerade Zahlen
     * 5 = Hohe Zahlen
     * 6 = Niedrige Zahlen
     * 7 = erstes Dutzend
     * 8 = zweites Dutzend
     * 9 = drittes Dutzend
     * 10 = erste Reihe
     * 11 = zweite Reihe
     * 12 = dritte Reihe
     */
    private int[][] bets = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36},
            {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36},
            {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35},
            {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36},
            {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36},
            {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34},
            {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35},
            {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36}};
    //Gibt einen String zurueck basierend auf der uebergebenen Nummer


    private String winSound = "Sounds_Roulette/win.wav";
    private String bigWinSound = "Sounds_Roulette/big_win.wav";
    private String loseSound = "Sounds_Roulette/lose.wav";
    private String ballSound = "Sounds_Roulette/ball.wav";

    public Roulette() {}

    public int start(int Void, Bank bank){

        //Position des Balls
        int ballPos = (int) (Math.random() * rouletteRad.length);

        //Scanner fuer die Eingabe
        Scanner scanner = new Scanner(System.in);

        //Eingabe Variable
        String eingabe;

        //Die Zahl auf der der Ball liegt
        int ballWert = rouletteRad[ballPos];

        //Wichtige Variablen zur Ermittlung des Gewinns
        int einsatz;
        int einsatzInsg = 0;
        int gewinnRueck = 0;
        int gewinnFinal;
        int zahl;
        int gewinnAnzahl = 0;

        //Benutzt Um zu ermitteln welche Gruppen / welche Zahl gewonnen hat und damit den gewinn zu berechnen
        ArrayList<bet> bettingList = new ArrayList<>();
        ArrayList<Integer> zahlenGruppenW = new ArrayList<>();
        ArrayList<Integer> zahlList = new ArrayList<>();

        //Erlaubt dem Spieler weitere Wetten abzuschließen
        boolean neuerEinsatz = true;

        //Überprüft ob die Wette <= dem Konto des Spielers ist
        boolean valid;

        //Wetten annahme
        while (neuerEinsatz) {
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("\f");
            System.out.println("Wie viel willst du einsetzen?");
            System.out.println("Dein Konto liegt bei " + bank.get_kontospieler());
            eingabe = scanner.nextLine();

            valid = bank.einsatz_rp(Integer.parseInt(eingabe));
            if(valid){
                einsatzInsg -= Integer.parseInt(eingabe);
                einsatz = Integer.parseInt(eingabe);
                System.out.println("Auf was willst du setzen?\n0 = Einzelne Zahlen (36 zu 1)\n1 = Rote Zahlen(2 zu 1)\n2 = Schwarze Zahlen(2 zu 1)\n3 = Gerade Zahlen(2 zu 1)\n4 = Ungerade Zahlen(2 zu 1)\n5 = Hohe Zahlen(2 zu 1)\n6 = Niedrige Zahlen(2 zu 1)\n7 = erstes Dutzend(3 zu 1)\n8 = zweites Dutzend(3 zu 1)\n9 = drittes Dutzend(3 zu 1)\n10 = erste Reihe(3 zu 1)\n11 = zweite Reihe(3 zu 1)\n12 = dritte Reihe(3 zu 1)");
                eingabe = scanner.nextLine();
                zahl = Integer.parseInt(eingabe);

                if (zahl == 0) {
                    System.out.println("Auf welche Zahl willst du wetten?");
                    eingabe = scanner.nextLine();
                    bettingList.add(new bet(0, einsatz, Integer.parseInt(eingabe)));
                    System.out.println("Du hast " + einsatz + " auf die Zahl " + eingabe + " gesetzt!");

                    System.out.println("Möchtest du noch eine Wette setzen (y/n)");
                    eingabe = scanner.nextLine();
                    if (eingabe.equalsIgnoreCase("n")) {
                        neuerEinsatz = false;
                    }
                } else {
                    if (zahl < 13 && zahl > 0) {

                        bettingList.add(new bet(zahl, einsatz));
                        System.out.println("Du hast " + einsatz + " auf " + ZahlBereichAusgabe(zahl) + " gesetzt!");


                        System.out.println("Möchtest du noch eine Wette setzen (y/n)");
                        eingabe = scanner.nextLine();
                        if (eingabe.equalsIgnoreCase("n")) {
                            neuerEinsatz = false;
                        }

                    } else {
                        System.err.println("Invalide Eingabe!!!");
                    }
                }
            }else{
                System.err.println("Du kannst nicht mehr einsetzen als du auf dem Konto hast!!!");
            }


        }
        makeSound(ballSound);

        try{
            Thread.sleep(9000);
        }catch (Exception e){
            e.printStackTrace();
        }


        for (int i = 0; i < bets[0].length; i++) {
            if (bets[0][i] == ballWert) {
                zahlList.add(bets[0][i]);
                break;
            }
        }
        for (int i = 1; i < 13; i++) {
            for (int j = 0; j < bets[i].length; j++) {
                if (bets[i][j] == ballWert) {
                    zahlenGruppenW.add(i);
                    break;
                }
            }
        }
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Die Zahl ist: " + ballWert);
        for (bet bet : bettingList) {
            
            int zahlBereich = bet.getZahl_bereich();
            if (bet.getZahl_bereich() == 0) {
                if (zahlList.contains(bet.getZahl())) {
                    gewinnRueck += bet.getEinsatz() * 36;
                    System.out.println("Du hast " + bet.getEinsatz() * 36 + " Chips Gewonnen auf: " + bet.getZahl());
                    makeSound(bigWinSound);
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    gewinnAnzahl++;
                }else{
                    System.out.println("Du hast deine Wette von " + bet.getEinsatz() + " auf der Zahl " + bet.getZahl() + " verloren!");
                    makeSound(loseSound);
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } else if (zahlenGruppenW.contains(bet.getZahl_bereich())) {
                if (zahlBereich > 0 && zahlBereich < 6) {
                    gewinnRueck += bet.getEinsatz() * 2;
                    System.out.println("Du hast " + bet.getEinsatz() * 2 + " gewonnen auf: " + ZahlBereichAusgabe(zahlBereich));
                    makeSound(winSound);
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    gewinnAnzahl++;
                } else if (zahlBereich > 6 && zahlBereich < 13) {
                    gewinnRueck += bet.getEinsatz() * 3;
                    System.out.println("Du hast " + bet.getEinsatz() * 3 + " gewonnen auf " + ZahlBereichAusgabe(zahlBereich));
                    makeSound(winSound);
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    };
                    gewinnAnzahl++;
                }

            } else {
                System.out.println("Du hast deine Wette von " + bet.getEinsatz() + " auf " + ZahlBereichAusgabe(zahlBereich) + " verloren!");
                makeSound(loseSound);
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        gewinnFinal = einsatzInsg + gewinnRueck;
        System.out.println("Du hast insgesamt "
                + gewinnAnzahl
                + " mal gewonnen und damit "
                + gewinnRueck
                + " Chips gewonnen, dein insgesamter Einsatz waren "
                + Math.abs(einsatzInsg)
                + " das bedeutet du hast insgesamt "
                + (gewinnFinal > 0 ? Math.abs(gewinnFinal) + " Chip(s) gewonnen!"
                : gewinnFinal < 0 ? Math.abs(gewinnFinal) + " Chip(s) verloren!"
                : " nichts gewonnen oder verloren!")
        );
        if(gewinnFinal != 0){
            bank.ergebnis(gewinnFinal, spieleNr);
            return gewinnFinal;
        }else{
            bank.ergebnis(einsatzInsg, spieleNr);
            return einsatzInsg;
        }

    }
    public void makeSound(String soundPath){
        File sound = new File(soundPath);


        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public  String ZahlBereichAusgabe(int zahl) {
        return  (zahl == 1) ? "Rot" :
                (zahl == 2) ? "Schwarz" :
                (zahl == 3) ? "Gerade" :
                (zahl == 4) ? "Ungerade" :
                (zahl == 5) ? "Hoch" :
                (zahl == 6) ? "Nieder" :
                (zahl == 7) ? "dem ersten Dutzend" :
                (zahl == 8) ? "dem zweiten Dutzend" :
                (zahl == 9) ? "dem dritten Dutzend" :
                (zahl == 10) ? "der ersten Reihe" :
                (zahl == 11) ? "der zweiten Reihe" : "der dritten Reihe";
    }
    public String toString() {
        StringBuilder rueckgabe = new StringBuilder();
        for (int j : rouletteRad) {
            rueckgabe.append(j).append(" ");
        }
        return rueckgabe.toString();
    }
}
