
import java.util.Scanner;

public class Blackjack extends Spiel{
    public int Wert_s = 0;
    public int Wert_d = 0;
    public String Wert_s2 = "";
    public String Wert_d2 = "";
    public String [] Kartendeck = new String[52];
    public int start(int einsatz, Bank b){
        Wert_s = 0;
        Wert_d = 0;
        Wert_s2 = "";
        Wert_d2 = "";
        String [] Kartendeck_Symbol = new String[52];
        for(int symbol = 0; symbol < 4; symbol++){
            for(int wert = 0; wert < 13; wert++){
                if(symbol == 0){
                    if(wert == 0){
                        Kartendeck[wert] = "Ass";
                    }
                    else if(wert == 10){
                        Kartendeck[wert] = "Köni";
                    }
                    else if(wert == 11){
                        Kartendeck[wert] = "Dame";
                    }
                    else if(wert == 12){
                        Kartendeck[wert] = "Bube";
                    }
                    else{
                        Kartendeck[wert] = Integer.toString(wert);
                    }
                    Kartendeck_Symbol[wert] = "Schippe";
                }
                if(symbol == 1){
                    if(wert == 0){
                        Kartendeck[wert + 13] = "Ass";
                    }
                    else if(wert == 10){
                        Kartendeck[wert + 13] = "König";
                    }
                    else if(wert == 11){
                        Kartendeck[wert + 13] = "Dame";
                    }
                    else if(wert == 12){
                        Kartendeck[wert + 13] = "Bube";
                    }
                    else{
                        Kartendeck[wert + 13] = Integer.toString(wert);
                    }
                    Kartendeck_Symbol[wert + 13] = "Kreuz";
                }
                if(symbol == 2){
                    if(wert == 0){
                        Kartendeck[wert + 26] = "Ass";
                    }
                    else if(wert == 10){
                        Kartendeck[wert + 26] = "König";
                    }
                    else if(wert == 11){
                        Kartendeck[wert + 26] = "Dame";
                    }
                    else if(wert == 12){
                        Kartendeck[wert + 26] = "Bube";
                    }
                    else{
                        Kartendeck[wert + 26] = Integer.toString(wert);
                    }
                    Kartendeck_Symbol[wert + 26] = "Karo";
                }
                if(symbol == 3){
                    if(wert == 0){
                        Kartendeck[wert + 39] = "Ass";
                    }
                    else if(wert == 10){
                        Kartendeck[wert + 39] = "König";
                    }
                    else if(wert == 11){
                        Kartendeck[wert + 39] = "Dame";
                    }
                    else if(wert == 12){
                        Kartendeck[wert + 39] = "Bube";
                    }
                    else{
                        Kartendeck[wert + 39] = Integer.toString(wert);
                    }
                    Kartendeck_Symbol[wert + 39] = "Herz";
                }
            }
        }
        boolean fertig_s = false;
        boolean fertig_d = false;
        int Anzahl_Ass_s = 0;
        int Anzahl_Ass_d = 0;
        boolean Kartevorhanden = false;
        while(Kartevorhanden == false){
            int Stelle = (int)(Math.random()*52);
            if(Kartendeck[Stelle] != ""){
                Kartevorhanden = true;
                if(Wert_d2 != "") Wert_d2 += " ";
                Wert_d2 += Kartendeck[Stelle];
                if(Kartendeck[Stelle] == "König" || Kartendeck[Stelle] == "Dame" || Kartendeck[Stelle] == "Bube"){
                    Wert_d += 10;
                }
                else if(Kartendeck[Stelle] != "Ass"){
                    Wert_d += Integer.parseInt(Kartendeck[Stelle]);
                }
                else if(Kartendeck[Stelle] == "Ass"){
                    Anzahl_Ass_d++;
                }
                Kartendeck[Stelle] = "";
            }
        }
        for(int i = 0; i < 2; i++){
            Kartevorhanden = false;
            while(Kartevorhanden == false){
                int Stelle = (int)(Math.random()*52);
                if(Kartendeck[Stelle] != ""){
                    Kartevorhanden = true;
                    Wert_s2 += " " + Kartendeck[Stelle];
                    if(Kartendeck[Stelle] == "König" || Kartendeck[Stelle] == "Dame" || Kartendeck[Stelle] == "Bube"){
                        Wert_s += 10;
                    }
                    else if(Kartendeck[Stelle] != "Ass"){
                        Wert_s += Integer.parseInt(Kartendeck[Stelle]);
                    }
                    else if(Kartendeck[Stelle] == "Ass"){
                        Anzahl_Ass_s++;
                    }
                    Kartendeck[Stelle] = "";
                }
            }
        }
        boolean Gewonnen = false;
        boolean Unentschieden = false;
        boolean zweikarten_s = true;
        boolean einekarte = true;
        boolean zweikarten_d = false;
        boolean fertig = false;
        boolean ueberkauft_s = false;
        boolean ueberkauft_d = false;
        while(fertig == false){
            while(Anzahl_Ass_d > 0){
                if(Wert_d <= 10) Wert_d += 11;
                else Wert_d += 1;
                Anzahl_Ass_d--;
            }
            System.out.println("Dealer: " + Wert_d2);
            System.out.println("Wert:" + Wert_d);
            if(Anzahl_Ass_d > 0){
                System.out.println("Asse wurden nicht dazugerechnet");
            }
            System.out.println("");
            System.out.println("Spieler: " + Wert_s2);
            System.out.println("Wert:" + Wert_s);
            while(Anzahl_Ass_s > 0){
                System.out.println("Du hast " + Anzahl_Ass_s + " Ass/e");
                boolean richtig = false;
                Scanner Frage = new Scanner(System.in);
                System.out.println("Welchen Wert soll dein Ass haben");
                while(richtig == false){
                    String Antwort = Frage.nextLine();
                    if(Antwort.equals("11") || Antwort.equals("1")){
                        richtig = true;
                        Wert_s += Integer.parseInt(Antwort);
                        Anzahl_Ass_s--;
                    }
                    else{
                        System.out.println("So nicht Freundchen, nur 1 oder 11!");
                    }
                }
            }
            if(fertig_s == false && Wert_s < 21){
                Scanner Ziehen = new Scanner(System.in);
                System.out.println("Noch eine Karte ziehen? (y/n)");
                boolean richtig = false;
                while(richtig == false){
                    String Antwort = Ziehen.nextLine();
                    if(Antwort.equals("y")){
                        System.out.println("---------------------------------");
                        richtig = true;
                        zweikarten_s = false;
                        Kartevorhanden = false;
                        while(Kartevorhanden == false){
                            int Stelle = (int)(Math.random()*52);
                            if(Kartendeck[Stelle] != ""){
                                Kartevorhanden = true;
                                Wert_s2 += " " + Kartendeck[Stelle];
                                if(Kartendeck[Stelle] == "König" || Kartendeck[Stelle] == "Dame" || Kartendeck[Stelle] == "Bube"){
                                    Wert_s += 10;
                                }
                                else if(Kartendeck[Stelle] != "Ass"){
                                    Wert_s += Integer.parseInt(Kartendeck[Stelle]);
                                }
                                else if(Kartendeck[Stelle] == "Ass"){
                                    Anzahl_Ass_s++;
                                }
                                Kartendeck[Stelle] = "";
                            }
                        }
                    }
                    else if(Antwort.equals("n")){
                        System.out.println("---------------------------------");
                        richtig = true;
                        fertig_s = true;
                    }
                    else{
                        System.out.println("So nicht Freundchen, nur y oder n (Ja oder Nein)!");
                    }
                }
            }
            else if(fertig_d == false){
                Scanner Enter = new Scanner(System.in);
                System.out.println("Drücke 'Enter' um fortzufahren.");
                String Antwort = Enter.nextLine();
                System.out.println("---------------------------------");
                if(einekarte == false){
                    if(Wert_d <= 16){
                        zweikarten_d = false;
                        Kartevorhanden = false;
                        while(Kartevorhanden == false){
                            int Stelle = (int)(Math.random()*52);
                            if(Kartendeck[Stelle] != ""){
                                Kartevorhanden = true;
                                if(Wert_d2 != "") Wert_d2 += " ";
                                Wert_d2 += Kartendeck[Stelle];
                                if(Kartendeck[Stelle] == "König" || Kartendeck[Stelle] == "Dame" || Kartendeck[Stelle] == "Bube"){
                                    Wert_d += 10;
                                }
                                else if(Kartendeck[Stelle] != "Ass"){
                                    Wert_d += Integer.parseInt(Kartendeck[Stelle]);
                                }
                                else if(Kartendeck[Stelle] == "Ass"){
                                    Anzahl_Ass_d++;
                                }
                                Kartendeck[Stelle] = "";
                            }
                        }
                    }
                    else if(Wert_d >= 17){
                        fertig_d = true;
                    }
                }
                else if(einekarte == true){
                    einekarte = false;
                    Kartevorhanden = false;
                    while(Kartevorhanden == false){
                        int Stelle = (int)(Math.random()*52);
                        if(Kartendeck[Stelle] != ""){
                            Kartevorhanden = true;
                            Wert_d2 += " " + Kartendeck[Stelle];
                            if(Kartendeck[Stelle] == "König" || Kartendeck[Stelle] == "Dame" || Kartendeck[Stelle] == "Bube"){
                                Wert_d += 10;
                            }
                            else if(Kartendeck[Stelle] != "Ass"){
                                Wert_d += Integer.parseInt(Kartendeck[Stelle]);
                            }
                            else if(Kartendeck[Stelle] == "Ass"){
                                Anzahl_Ass_d++;
                            }
                            Kartendeck[Stelle] = "";
                        }
                    }
                }
            }
            while(Anzahl_Ass_d > 0){
                if(Wert_d <= 10) Wert_d += 11;
                else Wert_d += 1;
                Anzahl_Ass_d--;
            }
            while(Anzahl_Ass_s > 0){
                System.out.println("Du hast " + Anzahl_Ass_s + " Ass/e");
                boolean richtig = false;
                Scanner Frage = new Scanner(System.in);
                System.out.println("Welchen Wert soll dein Ass haben");
                while(richtig == false){
                    String Antwort = Frage.nextLine();
                    if(Antwort.equals("11") || Antwort.equals("1")){
                        richtig = true;
                        Wert_s += Integer.parseInt(Antwort);
                        Anzahl_Ass_s--;
                    }
                    else{
                        System.out.println("So nicht Freundchen, nur 1 oder 11!");
                    }
                }
            }
            if(Wert_d == 21){
                System.out.println("Dealer: Blackjack");
                System.out.println();
            }
            if(Wert_d > 21){
                System.out.println("Dealer: Überkauft");
                System.out.println();
                ueberkauft_d = true;
                Gewonnen = true;
            }
            if(Wert_s == 21){
                System.out.println("Spieler: Blackjack");
                System.out.println();
                fertig_s = true;
                if(Wert_d == 21) Unentschieden = true;
                else Gewonnen = true;
            }
            if(Wert_s > 21){
                System.out.println("Spieler: Überkauft");
                System.out.println();
                fertig_s = true;
                ueberkauft_s = true;
                if(Wert_d > 21) Unentschieden = true;
                else{
                    if(einekarte == true) fertig_d = true;
                }
            }
            if(ueberkauft_s == false && ueberkauft_d == false){
                if(fertig_d == true && fertig_s == true){
                    if(Wert_d < Wert_s){
                        Gewonnen = true;
                        Unentschieden = false;
                    }
                    else if(Wert_d == Wert_s){
                        Unentschieden = true;
                    }
                }
            }
            if(Wert_s == 21 && Wert_d == 21){
                if(zweikarten_d == true && zweikarten_s == false){
                    Gewonnen = false;
                    Unentschieden = false;
                }
                if(zweikarten_s == true && zweikarten_d == false){
                    Gewonnen = true;
                    Unentschieden = false;
                }
            }
            if(fertig_d == true){
                if(fertig_s == true){
                    fertig = true;
                }
            }
        }
        if(Unentschieden == true){
            System.out.println("Unentschieden!");
            b.ergebnis(einsatz, 4);
            return(einsatz); 
        }
        else if(Gewonnen == true){
            System.out.println("Gewonnen!");
            b.ergebnis(einsatz*2, 4);
            return(einsatz*2);
        }
        else{
            System.out.println("Verloren!");
            b.ergebnis(einsatz*-1, 4);
            return(einsatz*-1);
        }
    }
}
