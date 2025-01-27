import java.util.Scanner;

class Spieler
{
    public String Spieler()
    {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Bitte geben sie ihren Namen ein.");
        String Name = (scanner.next());
        System.out.println(" ");
        return Name;
    }

    public void spielen(Spiel[] s, Bank b)
    {
        Scanner scanner = new Scanner (System.in);
        int test=1;

        //Einsatz angeben
        int kts = b.get_kontospieler();
        for(int i=0; i<1010101; i++)
        {
            System.out.println("Wir bieten folgende Spiele an:");
            for(int x=2; x<=8;x++)
            {
                System.out.println(x + " " + s[x]);
            }
            System.out.println(" ");
            System.out.println("Welches Spiel möchten Sie spielen? Gebe die entsprechende Nummer an.");
            int spil = 0;
            for(int k = 0; k<=1001001; k++)
            {
                spil = Integer.parseInt(scanner.next());
                if (spil >= 9 || spil <= 1)
                {
                    System.out.println(" ");
                    System.out.println("Falsche Eingabe, bitte erneut eingeben.");
                }
                else
                {
                    System.out.println("Sie spielen nun " + s[spil] + "!");
                    break;
                }
            }

            System.out.println(" ");
            System.out.println("Ihr Kontostand beträgt " + kts + "C");
            int einsatz = 0;
            for(int j=0;j<=10000000;j++)
            {
                if (spil == 2 || spil == 7)
                {
                    break;
                }
                System.out.println("Bitte Einsatz zwischen 0-" + kts + "C eingeben:");
                einsatz = Integer.parseInt (scanner.next());
                boolean gut = false;
                gut = b.einsatz_einziehen(einsatz);
                if(gut==true)
                {
                    System.out.println(" ");
                    System.out.println("Juhu! Sie können losspielen!");
                    break;
                }
            }

            Spiel Piel = s[spil];

            //Spielen
            int erg = Piel.start(einsatz, b);

            //Abfrage weiterspielen
            System.out.println(" ");
            kts = b.get_kontospieler();
            System.out.println("Ihr Kontostand beträgt nun " + kts + "C");
            if(kts > 0)
            {
                System.out.println("Wollen Sie weiterspielen? [1] Ja [2] Nein");
                int ents = 0;
                for(int j=0;j<=100000;j++)
                {
                    ents = Integer.parseInt(scanner.next());
                    if(ents==2)
                    {
                        System.out.println(" ");
                        System.out.println("Herzlichen Glückwunsch! Sie haben keine Spielsucht entwickelt!");
                        break;
                    }
                    if(ents==1)
                    {
                        System.out.println(" ");
                        System.out.println("Das Casino ist nun ihr zweites Zuhause!");
                        System.out.println(" ");
                        break;
                    }
                    else
                    {
                        System.out.println(" ");
                        System.out.println("Falsche Eingabe. Bitte nochmal entscheiden.");
                    }
                    if(ents==2)
                    {
                        break;
                    }
                }
                if(ents==2)
                {
                    break;
                }
            }
            else
            {
                System.out.println("Sie sind nun pleite. Sie können nicht weiterspielen. :(");
                break;
            }
        }
    }
}
