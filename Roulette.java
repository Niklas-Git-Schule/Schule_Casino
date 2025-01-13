import java.util.*;

public class Roulette{

    private int ballPos;
    private int[] rouletteRad = {0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26};
    private Scanner sc = new Scanner(System.in);


    public Roulette(){
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
        int[][] bets = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36},
                        {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36},
                        {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35},
                        {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36},
                        {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35},
                        {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18},
                        {19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36},
                        {1,2,3,4,5,6,7,8,9,10,11,12},
                        {13,14,15,16,17,18,19,20,21,22,23,24},
                        {25,26,27,28,29,30,31,32,33,34,35,36},
                        {1,4,7,10,13,16,19,22,25,28,31,34},
                        {2,5,8,11,14,17,20,23,26,29,32,35},
                        {3,6,9,12,15,18,21,24,27,30,33,36}}
    }

    public int start(){
        // -einsatz verlust, +einsatz unentschieden, einsatz * multiplikator gewinn
        Scanner scanner = new Scanner(System.in);

        String eingabe;

        int rnd = (int)(Math.random()*rouletteRad.length);

        boolean neuerEinsatz = true;

        while(neuerEinsatz){
            System.out.println("Wie viel willst du einsetzen?");
            eingabe = scanner.nextLine();
            System.out.println("Auf was willst du setzen?\n0 = Einzelne Zahlen\n1 = Rote Zahlen\n2 = Schwarze Zahlen\n3 = Gerade Zahlen\n4 = Ungerade Zahlen\n5 = Hohe Zahlen\n6 = Niedrige Zahlen\n7 = erstes Dutzend\n8 = zweites Dutzend\n9 = drittes Dutzend\n10 = erste Reihe\n11 = zweite Reihe\n12 = dritte Reihe")

            eingabe = scanner.nextLine();
            int zahl = Integer.parseInt(eingabe);

            switch(zahl){
                case 0

            }
        }

    }



    public String toString(){
        String rueckgabe = "";
        for(int i = 0; i < rouletteRad.length; i++){
            rueckgabe += rouletteRad[i] + " ";
        }
        return rueckgabe;
    }
}
