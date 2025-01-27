import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class WildeWalzen extends Spiel {
    public int start(int einsatz, Bank b) {
        Scanner sc = new Scanner(System.in);
        int gewinn = 100;

        System.out.println("---");
        System.out.println("Willkommen bei den Wilden Walzen!!!");
        System.out.println("Drücke 'Enter', um zu starten.");
        System.out.println("Drücke 'A', um die Auszahlungstabelle einzusehen.");
        System.out.println("Tipp: Drücke 'STRG' + 'PLUS', um heranzuzoomen.");
        System.out.println("---");
        System.out.println();
        System.out.println();
        System.out.println();

        String input = sc.nextLine();

        if(input.equals("")) {
            Slots(einsatz);
        }

        if(input.equals("a")) {
            Auszahlungstabelle();
        }

        return gewinn;
    }

    public void Slots(int einsatz) {
        Random random = new Random();
        int[][] nums = new int[3][5];

        //farbe reset
        String ANSI_RESET = "\u001B[0m";
        //farben
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_VIOLET = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";

        //gen ran nums
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<5; j++) {
                nums[i][j] = random.nextInt(107);
            }
        }

        //replace w symbols
        for(int i = 0; i<3; i++) {
            System.out.print(" | ");
            for(int j = 0; j<5; j++) {
                if(nums[i][j] <= 16) {
                    System.out.print(ANSI_RED + "♙" + ANSI_RESET + " | ");
                    nums[i][j] = 0;
                }
                if(nums[i][j] >= 17 && nums[i][j] <= 30) {
                    System.out.print(ANSI_VIOLET + "ᕷ" + ANSI_RESET + " | ");
                    nums[i][j] = 17;
                }
                if(nums[i][j] >= 31 && nums[i][j] <= 44) {
                    System.out.print(ANSI_GREEN + "⁂" + ANSI_RESET + " | ");
                    nums[i][j] = 31;
                }
                if(nums[i][j] >= 45 && nums[i][j] <= 56) {
                    System.out.print(ANSI_YELLOW + "♔" + ANSI_RESET + " | ");
                    nums[i][j] = 45;
                }
                if(nums[i][j] >= 57 && nums[i][j] <= 67) {
                    System.out.print(ANSI_CYAN + "♪" + ANSI_RESET + " | ");
                    nums[i][j] = 57;
                }
                if(nums[i][j] >= 68 && nums[i][j] <= 78) {
                    System.out.print(ANSI_BLUE + "࿊" + ANSI_RESET + " | ");
                    nums[i][j] = 68;
                }
                if(nums[i][j] >= 79 && nums[i][j] <= 87) {
                    System.out.print("⌘" + " | ");
                    nums[i][j] = 79;
                }
                if(nums[i][j] >= 88 && nums[i][j] <= 94) {
                    System.out.print("𝛼" + " | ");
                    nums[i][j] = 88;
                }
                if(nums[i][j] >= 95 && nums[i][j] <= 100) {
                    System.out.print("ඩ" + " | ");
                    nums[i][j] = 95;
                }
                if(nums[i][j] >= 101 && nums[i][j] <= 106) {
                    System.out.print("Σ" + " | ");
                    nums[i][j] = 101;
                }
            }
                System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<5; j++) {
                //1. Reihe horizontal
                if(i == 0 && j < 4) {
                    if(nums[i][j] == nums[i][j+1]) {
                        System.out.println("H");
                    }
                }
                //1. Reihe vertikal runter
                if(i == 0) {
                    if(nums[i][j] == nums[i+1][j]) {
                        System.out.println("V");
                    }
                }
                //1. Reihe diagonal rechts
                if(i == 0 && j < 4) {
                    if(nums[i][j] == nums[i+1][j+1]) {
                        System.out.println("DR");
                    }
                }
                //1. Reihe diagonal links
                if(i == 0 && j > 0) {
                    if(nums[i][j] == nums[i+1][j-1]) {
                        System.out.println("DL");
                    }
                }
                //2. Reihe horizontal
                if(i == 1 && j < 4) {
                    if(nums[i][j] == nums[i][j+1]) {
                        System.out.println("2H");
                    }
                }
                //2. Reihe vertikal runter
                if(i == 1) {
                    if(nums[i][j] == nums[i+1][j]) {
                        System.out.println("2V");
                    }
                }
                //2. Reihe diagonal rechts
                if(i == 1 && j < 4) {
                    if(nums[i][j] == nums[i+1][j+1]) {
                        System.out.println("2DR");
                    }
                }
                //2. Reihe diagonal links
                if(i == 1 && j > 0) {
                    if(nums[i][j] == nums[i+1][j-1]) {
                        System.out.println("2DL");
                    }
                }
                //3. Reihe horizontal
                if(i == 2 && j < 4) {
                    if(nums[i][j] == nums[i][j+1]) {
                        System.out.println("3H");
                    }
                }
            }
        }
    }

    public void Auszahlungstabelle() {
        System.out.println("AT");
    }
}
