import java.util.*;

public class Roulette{

    public String auswahl;

    public int ballPos;
    public int[] drehTisch;
    public Scanner sc = new Scanner(System.in);


    public Roulette(){
        drehTisch = new int[]{0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26};
        int[] redNumbers = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        int[] blackNumbers = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
        int[] evenNumbers = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
        int[] oddNumbers = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
        int[] rouletteTable = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
        int[] highNumbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int[] lowNubers = {19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
        int[] erstesDutzend = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] zweitesDutzend = {13,14,15,16,17,18,19,20,21,22,23,24};
        int[] drittesDutzend = {25,26,27,28,29,30,31,32,33,34,35,36};

    }



    public String toString(){
        String rueckgabe = "";
        for(int i = 0; i < drehTisch.length; i++){
            rueckgabe += drehTisch[i] + " ";
        }
        return rueckgabe;
    }
}
