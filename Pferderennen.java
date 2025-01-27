import java.util.*;
//public class Pferderennen extends Spiel{
public class Pferderennen extends Spiel{

    private int a = 0;
    private int sieger = 0;
    private String [][] spielfeld = new String [6][1000];
    private String [][] ausg_sp = new String [6][45];
    private Scanner auswahl = new Scanner(System.in);
    private boolean err = false;
    private int ausw = 0;
    public int start(int einsatz, Bank b){

            Pferd p1 = new Pferd();
            Pferd p2 = new Pferd();
            Pferd p3 = new Pferd();
            Pferd p4 = new Pferd();
            Pferd p5 = new Pferd();
            Pferd p6 = new Pferd();


            while(err == false){
                System.out.println("Bitte wähl dein Pferd aus (1-6) : ");
                ausw = Integer.parseInt(auswahl.nextLine());

                if(ausw <= 6 && ausw >= 1){
                    break;
                }
                else{
                    System.out.println("Falsche Auswahl ! Bitte wähle eine Zahl von 1 bis 6");
                }



            }

    while(a == 0){

        wait(2);
        clearScreen();

        p1.setGeschw();
        p2.setGeschw();
        p3.setGeschw();
        p4.setGeschw();
        p5.setGeschw();
        p6.setGeschw();
        p1.setPosition();
        p2.setPosition();
        p3.setPosition();
        p4.setPosition();
        p5.setPosition();
        p6.setPosition();


        System.out.println(spielfeld [0][p1.getPosition()] = "🏇🟨");
        System.out.println("Tempo:" + p1.getGeschw());
        System.out.println("Position:" + p1.getPosition());

        System.out.println(spielfeld [1][p2.getPosition()] = "🏇🏻");
        System.out.println("Tempo:" + p2.getGeschw());
        System.out.println("Position:" + p2.getPosition());

        System.out.println(spielfeld [2][p3.getPosition()] = "🏇🏽");
        System.out.println("Tempo:" + p3.getGeschw());
        System.out.println("Position:" + p3.getPosition());

        System.out.println(spielfeld [3][p4.getPosition()] = "🏇🏾");
        System.out.println("Tempo:" + p4.getGeschw());
        System.out.println("Position:" + p4.getPosition());

        System.out.println(spielfeld [4][p5.getPosition()] = "🏇🏿");
        System.out.println("Tempo:" + p5.getGeschw());
        System.out.println("Position:" + p5.getPosition());

        System.out.println(spielfeld [5][p6.getPosition()] = "🏇🏻");
        System.out.println("Tempo:" + p6.getGeschw());
        System.out.println("Position:" + p6.getPosition());


        int sp1 = (int) p1.getPosition()/5;
        int sp2 = (int) p2.getPosition()/5;
        int sp3 = (int) p3.getPosition()/5;
        int sp4 = (int) p4.getPosition()/5;
        int sp5 = (int) p5.getPosition()/5;
        int sp6 = (int) p6.getPosition()/5;

        ausg_sp[0][sp1] = "🏇🟨";
        ausg_sp[1][sp2] = "🏇🏻";
        ausg_sp[2][sp3] = "🏇🏽";
        ausg_sp[3][sp4] = "🏇🏾";
        ausg_sp[4][sp5] = "🏇🏿";
        ausg_sp[5][sp6] = "🏇🏻";

        for(int i = 0; i<=5;i++){
        for(int j= 0; j<40;j++){

        System.out.print(ausg_sp[i][j]);
        }
        System.out.println("-");
        }

        ausg_sp[0][sp1] = "null";
        ausg_sp[1][sp2] = "null";
        ausg_sp[2][sp3] = "null";
        ausg_sp[3][sp4] = "null";
        ausg_sp[4][sp5] = "null";
        ausg_sp[5][sp6] = "null";




        if(p1.getPosition() >= 200){
                sieger = 1;
                break;
        }
        if(p2.getPosition() >= 200){
                sieger = 2;
                break;
        }
        if(p3.getPosition() >= 200){
                sieger = 3;
                break;
        }
        if(p4.getPosition() >= 200){
                sieger = 4;
                break;
        }
        if(p5.getPosition() >= 200){
                sieger = 5;
                break;
        }
        if(p6.getPosition() >= 200){
                sieger = 6;
                break;

        }

        }

        System.out.println();
        System.out.println();

        String s = String.valueOf(sieger);
        System.out.println("Pferd " + s + " hat gewonnen");


        if(sieger == ausw){
        return einsatz*5;

        }
        else{
        return einsatz*-1;
        }
}
    public void ausg(){




    }


    public void wait(int sec){
        try {
            Thread.sleep(sec*1000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
}

}
