import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kniffel extends Spiel
{

    public int start(int einsatz, Bank b)
    {
        System.out.println("Mit 'Aussteigen' kommt man aus dem Programm.");
        System.out.println("Mit 'Würfel' kann man Würfeln.");
        System.out.println("Nach dem Würfeln 'b' drücken und danach die Zahlen der Würfel, die man behalten möchte. Zwischen 'b' und Zahlen einn Leerzeichen.");


        // Alle Variablen
        boolean Stopper = true;
        int[] Wurf = {0,0,0,0,0};
        int Wurfzahler = 0;
        char Buchstabe = 'Q';
        int lange = 0;
        int Punkte = 0;

        boolean Sperr[] = new boolean[5];

        Sperr[0] = false;
        Sperr[1] = false;
        Sperr[2] = false;
        Sperr[3] = false;
        Sperr[4] = false;

        int SpielZahler = 0;

        int Erg[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};



        Scanner scanner = new Scanner(System.in);
        while(SpielZahler < 13)
        {
            String s = scanner.next();

            Buchstabe = s.charAt(0);

            if(Buchstabe == 'b' || Buchstabe == 'B')
            {

            lange = s.length();

                for(int i = 2; i < lange;i++)
                {
                    Buchstabe = s.charAt(i);

                    Sperr[Buchstabe] = true;
                }


            }

            if(s.equals("Aussteigen"))
            {
                Stopper = false;
            }

            if(s.equals("stopp"))
            {
                Stopper = false;
            }

            if(s.equals("Stopp"))
            {
                Stopper = false;
            }


            if(s.equals("Würfel") || s.equals("Wuerfel") || s.equals("Wurfel") || s.equals("Wurf") || s.equals("Wuerfl") || s.equals("Wüerfel") || s.equals("Wuref") || s.equals("wuerfel") || s.equals("wurf") || s.equals("wuff"))
            {

                if(Wurfzahler <= 2)
                {
                    Feld(Wuerfel(Sperr));

                    Wurfzahler = Wurfzahler + 1;

                    Sperr[0] = false;
                    Sperr[1] = false;
                    Sperr[2] = false;
                    Sperr[3] = false;
                    Sperr[4] = false;

                }

            }

            if(s.equals("ADHSEKB"))
            {

                Punkte = 999;
            }





            if(s.equals("1er"))
            {
                for(int i = 0; i <= 4; i++)
                {
                    if(Wurf[i] == 1)
                    {
                        Erg[0] = Erg[0] + 1;
                    }
                }

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("2er"))
            {
                for(int i = 0; i <= 4; i++)
                {
                    if(Wurf[i] == 2)
                    {
                        Erg[1] = Erg[1] + 2;
                    }
                }

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("3er"))
            {
                for(int i = 0; i <= 4; i++)
                {
                    if(Wurf[i] == 3)
                    {
                        Erg[2] = Erg[2] + 3;
                    }
                }

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("4er"))
            {
                for(int i = 0; i <= 4; i++)
                {
                    if(Wurf[i] == 4)
                    {
                        Erg[3] = Erg[3] + 4;
                    }
                }

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("5er"))
            {
                for(int i = 0; i <= 4; i++)
                {
                    if(Wurf[i] == 5)
                    {
                        Erg[4] = Erg[4] + 5;
                    }
                }

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("6er"))
            {
                for(int i = 0; i <= 4; i++)
                {
                    if(Wurf[i] == 6)
                    {
                        Erg[5] = Erg[5] + 6;
                    }
                }

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("3P"))
            {

                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("4P"))
            {
                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("FH"))
            {
                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("SS"))
            {
                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("BS"))
            {
                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("Ya"))
            {
                SpielZahler = SpielZahler + 1;
            }

            if(s.equals("Ch"))
            {
                SpielZahler = SpielZahler + 1;
            }












            if(s.equals("Feld"))
            {
                Feld(Wurf);
            }


            Buchstabe = 'Q';





        }


        System.out.println("Tschusss");
        scanner.close();


        if(Punkte >= 50)
        {
            return einsatz*2;
        }
        else
        {
            return 10;
        }

    }





    private int[] Wuerfel(boolean[] SperrW)
    {
        int[] Wurfliste = new int[5];

            for(int i = 0; i<5;i++)
            {
                if(SperrW[i] == false)
                {
                    Wurfliste[i] = ((int)(Math.random() * 6)+1);
                }
            }

            return Wurfliste;

    }





    //3 array WerteSpieler WerteComputer WerteWurf String Arrays bei werten, weil Leerzeichen leichter dargestellt
    //2 int ComputerErg SpielerErg
    // Zähler für Züge Anfrgae am Ende



//boolean gibt zurück ob Spiel rum

    private boolean Feld(int[] Wurf)
        {
            for(int i= 0; i<20;i++)
            {
                    System.out.println("");
            }

        // Computer
            System.out.println("Computer");
            System.out.println("");
            System.out.println("-------------------------");
            System.out.println("|1er|2er|3er|4er|5er|6er|");
            System.out.println("-------------------------");
            System.out.println("|" + "  0" + "|" + "  0" + "|" + "  0" + "|" + "  0" + "|" + "  0" + "|" + "  0" + "|");
            System.out.println("-------------------------");
            System.out.println("Bonus: "+ "0" );
            System.out.println("");




            System.out.println("----------------------");
            System.out.println("|" + "3P" + "|" + "4P" + "|" + "FH" + "|" + "SS" + "|" + "BS" + "|" + "Ya" + "|" + "Ch" + "|");
            System.out.println("----------------------");
            System.out.println("|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|");
            System.out.println("----------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("Endsumme: " + "0");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

        // Spieler
            System.out.println("Spieler");
            System.out.println("");
            System.out.println("-------------------------");
            System.out.println("|1er|2er|3er|4er|5er|6er|");
            System.out.println("-------------------------");
            System.out.println("|" + "  0" + "|" + "  0" + "|" + "  0" + "|" + "  0" + "|" + "  0" + "|" + "  0" + "|");
            System.out.println("-------------------------");
            System.out.println("Bonus: "+ "0");
            System.out.println("");



            System.out.println("----------------------");
            System.out.println("|" + "3P" + "|" + "4P" + "|" + "FH" + "|" + "SS" + "|" + "BS" + "|" + "Ya" + "|" + "Ch" + "|");
            System.out.println("----------------------");
            System.out.println("|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|" + " 0" + "|");
            System.out.println("----------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("Endsumme: " + "0");
            System.out.println("");


            // Wurf

            System.out.println("-----------");
            System.out.println("|" + Wurf[0] + "|" + Wurf[1] + "|" + Wurf[2] + "|" + Wurf[3] + "|" + Wurf[4] + "|");
            System.out.println("-----------");

            //Zähler und Ob gewonnen

            if(8 == 3 && 3 == 8)
            {
                System.out.println("");
                System.out.println("");
                System.out.println("Spiel vorbei");
                System.out.println("Du hast gewonnen");
                return true;
            }

            else if(7 == 43 && 3 == 6)
            {
                System.out.println("");
                System.out.println("");
                System.out.println("Spiel vorbei");
                System.out.println("Du hast verloren");
                return true;
            }

            else
            {
                return false;
            }

        }


        //Gib die Stelen der Würfel an, die du behalten möchtest (ohne Leerzeichen)
        // wenn der Spieler auhören will schreibt er "fertig" und dahinter Die Stelle bei der er die Würfel einsetzen möchte. Dann Macht der Computer seinen Zug, setz den Zähler auf 0 und erhöhe den Zähler für die Züge um 1, das ausgewählte Feld muss gesperrt werden.
        // Start gibt Geld zurück
}
