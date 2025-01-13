import java.util.*;

public class Roulette {

    private int ballPos;
    private int[] rouletteRad = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
    private Scanner sc = new Scanner(System.in);
    private ArrayList<bet> bettingList = new ArrayList<bet>();
    /*
          Bets:
          0 = Einzelne Zahlen
          1 = Rote Zahlen
          2 = Schwarze Zahlen
          3 = Gerade Zahlen
          4 = Ungerade Zahlen
          5 = Hohe Zahlen
          6 = Niedrige Zahlen
          7 = erstes Dutzend
          8 = zweites Dutzend
          9 = drittes Dutzend
          10 = erste Reihe
          11 = zweite Reihe
          12 = dritte Reihe
      */
    private int[][] bets = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36},
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


    public Roulette() {

    }

    public int start() {
        ballPos = (int) (Math.random() * rouletteRad.length);

        Scanner scanner = new Scanner(System.in);

        String eingabe;

        int ballWert = rouletteRad[ballPos];
        int gewinn = 0;
        int einsatz = 0;
        int zahl;

        boolean neuerEinsatz = true;

        while (neuerEinsatz) {
            System.out.println("Wie viel willst du einsetzen?");
            eingabe = scanner.nextLine();
            einsatz -= Integer.parseInt(eingabe);
            System.out.println("Auf was willst du setzen?\n0 = Einzelne Zahlen (36 zu 1)\n1 = Rote Zahlen(2 zu 1)\n2 = Schwarze Zahlen(2 zu 1)\n3 = Gerade Zahlen(2 zu 1)\n4 = Ungerade Zahlen(2 zu 1)\n5 = Hohe Zahlen(2 zu 1)\n6 = Niedrige Zahlen(2 zu 1)\n7 = erstes Dutzend(3 zu 1)\n8 = zweites Dutzend(3 zu 1)\n9 = drittes Dutzend(3 zu 1)\n10 = erste Reihe(3 zu 1)\n11 = zweite Reihe(3 zu 1)\n12 = dritte Reihe(3 zu 1)");

            eingabe = scanner.nextLine();
            zahl = Integer.parseInt(eingabe);

            switch (zahl) {
                case 0:
                    System.out.println("Auf welche Zahl willst du wetten?");
                    eingabe = scanner.nextLine();
                    bettingList.add(new bet(0, einsatz, Integer.parseInt(eingabe)));
                    System.out.println("Möchtest du noch eine Wette setzen (y/n)");
                    eingabe = scanner.nextLine();
                    if (eingabe.toLowerCase().equals("n")) {
                        neuerEinsatz = false;
                    }
                    break;
                default:
                    if (zahl < 13 && zahl > 0) {
                        bettingList.add(new bet(zahl, einsatz));
                        System.out.println("Möchtest du noch eine Wette setzen (y/n)");
                        eingabe = scanner.nextLine();
                        if (eingabe.toLowerCase().equals("n")) {
                            neuerEinsatz = false;
                        }
                    } else {
                        System.err.println("Invalide Eingabe!!!");
                    }
                    break;
            }
        }
        ArrayList<Integer> zahlenGruppenW = new ArrayList<Integer>();
        ArrayList<Integer> zahlList = new ArrayList<Integer>();
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
        System.out.println("Die Zahl ist: " + ballWert);
        for (int i = 0; i < bettingList.size(); i++) {
            if (bettingList.get(i).getZahl_bereich() == 0) {
                if (zahlList.contains(bettingList.get(i).getZahl())) {
                    gewinn += bettingList.get(i).getEinsatz() + bettingList.get(i).getEinsatz() * 36;
                    System.out.println("Du hast " + bettingList.get(i).getEinsatz() * 36 + " Chips Gewonnen auf: " + bettingList.get(i).getZahl());
                }
            } else if (zahlenGruppenW.contains(bettingList.get(i).getZahl_bereich())) {
                int zahlBereich = bettingList.get(i).getZahl_bereich();
                if (zahlBereich > 0 || zahlBereich < 6) {
                    gewinn += bettingList.get(i).getEinsatz() + bettingList.get(i).getEinsatz() * 2;
                    System.out.println("Du hast " + bettingList.get(i).getEinsatz() * 2 + " gewonnen auf: " +
                            ((zahlBereich == 1) ? "Rot" :
                                    (zahlBereich == 2) ? "Schwarz" :
                                            (zahlBereich == 3) ? "Gerade" :
                                                    (zahlBereich == 4) ? "Ungerade" :
                                                            (zahlBereich == 5) ? "Hoch" : "Nieder")
                    );
                } else if (zahlBereich > 6 || zahlBereich < 13) {
                    gewinn += bettingList.get(i).getEinsatz() + bettingList.get(i).getEinsatz() * 3;
                    System.out.println("Du hast " + bettingList.get(i).getEinsatz() * 3 + " gewonnen auf " +
                            ((zahlBereich == 7) ? "dem ersten Dutzend" :
                                    (zahlBereich == 8) ? "dem zweiten Dutzend" :
                                            (zahlBereich == 9) ? "dem dritten Dutzend" :
                                                    (zahlBereich == 10) ? "der ersten Reihe" :
                                                            (zahlBereich == 11) ? "der zweiten Reihe" : "der dritten Reihe")
                    );
                }
            }
        }

        gewinn = einsatz + gewinn;

        return gewinn;

    }


    public String toString() {
        String rueckgabe = "";
        for (int i = 0; i < rouletteRad.length; i++) {
            rueckgabe += rouletteRad[i] + " ";
        }
        return rueckgabe;
    }
}
