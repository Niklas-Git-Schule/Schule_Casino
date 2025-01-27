import java.util.ArrayList;

public class Bank{
    private int chips_ges;
    private int einsatz = 0;
    private int konto_spieler;
    private int position = 1;
    private int runde;
    ArrayList <Integer []> archiv= new ArrayList<>();

    public Bank(){
    chips_ges = 10000000;
    einsatz = 0;
    konto_spieler = 10000;
    runde = 0;
    }

    public boolean einsatz_einziehen(int c){
        boolean kontrolle;
        if (konto_spieler < c) kontrolle = false;
        else{
            einsatz = c;
            kontrolle = true;
            konto_spieler = konto_spieler - einsatz;
        }
        return kontrolle;                           	// kontrolle gibt zurück, ob der einsatz im bereich des maximal erlaubten liegt
    }	
											// WENN FALSE RETURNED WIRD MUSS DIE METHODE NOCHMAL AUFGERUFEN WERDEN!
	public boolean einsatz_rp(int c){
		boolean kontrolle;							// c ist das was zum einsatz dazu addiert wird
        einsatz = einsatz + c;
        if (konto_spieler < c)
			kontrolle = false;
        else{
			konto_spieler = konto_spieler - c;
			kontrolle = true;
        }
        return kontrolle;
	}

    public void ergebnis(int g, int pos_spieler){
        if (g < 0){
            chips_ges = chips_ges + einsatz;
            einsatz = 0;
        }
        if (g > 0){
            konto_spieler = konto_spieler + g;
            chips_ges = chips_ges - (g - einsatz);
            einsatz = 0;
        }
        if (g == 0){
            while(position == 1){
                System.out.println("01");
            }
        }
        if (chips_ges <= 0){
            System.out.println("Herzlichen Glückwunsch, du hast die Bank gesprengt(KABOOOOM!!!)");
            while(position == 1){
            for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("L");

            for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Lo");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loa");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Load");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loadi");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loadin");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loading");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loading.");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loading..");
                for(int i = 0; i <= 10; i++){
                System.out.println(" ");
            }
                System.out.println("Loading...");
            }
        }
        //archiv_fuehren(g, pos_spieler);
    }

    public int get_kontospieler(){
        return konto_spieler;
    }
    private void archiv_fuehren(int g, int pos_spieler){
        runde++;
        Integer a [] = new Integer [5];
        a[0] = chips_ges;
        a[1] = konto_spieler;
        a[2] = einsatz;
        a[3] = g;
        a[4] = pos_spieler;
        archiv.add(a);

        archiv_ausgeben();
    }

    public void archiv_ausgeben(){
         Integer b [] = archiv.get(runde);
            System.out.println("Bankkonto: " + b[0]);
            System.out.println("Spielerkonto: " + b[1]);
            System.out.println("Einsatz: " + b[2]);
            System.out.println("Ergebnis: " + b[3]);
            System.out.println("Spielnummer: " + b[4]);;
    }
}
