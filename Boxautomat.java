import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.*;
import javax.sound.sampled.*;

// Highscore, Auszahlung
public class Boxautomat extends Spiel{
    private int spaceCount;
    private boolean gameStarted;
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";
    private int wette;
    private int guessnum;
    private int gewinn;
    private int einsatz;
    JFrame frame;
    JTextField tf;

    public Boxautomat () {
        spaceCount = 0;
        wette = 1;
        gewinn = 0;
        einsatz = 0;
        gameStarted = false;
        tf = new JTextField();
        frame = new JFrame();
        Bank b = new Bank();
    }

    public int start(int einsatz, Bank b) {
        SFX("Hintergrund.wav");
        this.einsatz = einsatz;
        print("Hallo! Willkommen zum Boxautomat.");
        wait(2000);
        print("Auf was setzt du?");
        print("\n1 : Gerade Zahlen");
        print("\n2 : Ungerade Zahlen");
        print("\n3 : Durch 10 teilbare Zahlen");
        print("\n4 : Genaue Zahl erschätzen");
        Scanner scan = new Scanner(System.in);
        int scerg = scan.nextInt();
        if(scerg == 1) {
            wette = 1;
        }
        else if(scerg == 2) {
            wette = 2;
        }
        else if(scerg == 3) {
            wette = 3;
        }
        else if(scerg == 4) {
            wette = 4;
            print("Welche Zahl schätzt du? (1-999)");
            guessnum = scan.nextInt();
        }
        Random rand = new Random();
        int r = rand.nextInt(19);
        String spruch[] = {"Hoffentlich kannst du genauso viel aushalten, wie du reinsteckst!",
" Bist du sicher, dass du nicht schon ein bisschen mehr Mut brauchst?",
"Na, willst du zeigen, wie groß deine Schlagkraft ist?",
"Komm schon, zeig mir, wie du den Punch austeilen kannst!",
"Der Automatenring wird dich testen, mein Freund. Viel Glück!",
"Wenn du so viel Energie in den Schlag steckst wie in deinen Einsatz, könnte das spannend werden.",
"Hoffentlich bist du genauso standhaft wie du tust!",
"Bereit, den Kopf zu drehen und ordentlich zuzuschlagen?",
"Du weißt, je härter du zuschlägst, desto länger bleibt der Eindruck!",
"Du weißt, es ist nicht nur der Einsatz, der zählt – sondern auch, wie du austeilst!",

"Na, zeig mal, ob du wirklich 'was auf dem Kasten' hast!",
"Wenn du genauso gut zuschlägst wie du anpackst, wird das ein Spaß!",
"Das ist kein Kinderspiel – also, wie gut kannst du wirklich standhalten?",
"Denk dran, der erste Schlag zählt – auch wenn's um die Größe geht!",
"Mach dich bereit, dem Automaten zu zeigen, was du drauf hast!",
"So wie du hier reingehst, wirst du bestimmt Eindruck hinterlassen!",
"Zeig mal, wie du das Ding zum Schwingen bringst!",
"Du willst also ein bisschen Action? Mach, dass es knallt!",
"Du wirst sehen, hier ist der Druck höher als du denkst!",
"Na, bist du sicher, dass du bereit für die Herausforderung bist? Wir warten auf deinen Schlag!"};
        print(spruch[r]);
        wait(2000);
        print("Mache dich bereit.");
        wait(2000);
        SFX("Beep.wav");
        print("3");
        wait(1000);
        SFX("Beep2.wav");
        print("2");
        wait(1000);
        SFX("Beep3.wav");

        print("1");
        wait(1000);
                SFX("BeepHell.wav");

        print("Los!");

        frame.setSize(1, 1);
        frame.setLayout(null);

        frame.getContentPane().add(tf);
        frame.setVisible(true);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                gameStarted = true;
                try {
            Thread.sleep(5*1000);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
                gameStarted = false;
                System.out.println(ANSI_RESET);
                frame.dispose();
            }
        };
        Thread thread = new Thread(task);
        thread.start();




        System.out.print(ANSI_RED);
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                String text = textField.getText();
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    addSpace();
                    SFX("Schlag.wav");
                    System.out.print("█");
                }
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                }
                textField.setText("");
            }

        });

        while(gameStarted) {
            wait(100);
        }
        print("STOP!");
        wait(500);
        print("Berechnen...");
        wait(4000);
        runAnim();
        try {
            //Random ran = new Random();
            score(spaceCount*22);
        }
        catch (InterruptedException e) {}
        b.ergebnis(gewinn, 3);
        return 100;
    }

    private void SFX(String filename) {
         try {

            try {
                try {
                    File soundFile = new File(filename);

                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                }
                catch (LineUnavailableException e) {print(e + " ");}

            }catch (UnsupportedAudioFileException ex) {print(ex + " ");}

        }catch (IOException exx) {print(exx + " ");}
    }


    private boolean gewinn(int score) {
        if (wette == 1) {
            if (score % 2 == 0) {
                gewinn = (int) einsatz*2+einsatz;
                return true;
            }
            else {
                gewinn = (int) einsatz*(-2)-einsatz;
                return false;
            }
        }
        else if (wette == 2) {
            if (score % 2 != 0) {
                gewinn = (int) einsatz*2+einsatz;
                return true;
            }
            else {
                gewinn = (int) einsatz*(-2)-einsatz;
                return false;
            }
        }
        else if (wette == 3) {
             if (score % 10 == 0) {
                gewinn = (int) einsatz*3+einsatz;
                return true;
            }
            else {
                gewinn = (int) einsatz*(-3)-einsatz;
                return false;
            }
        }
        else if (wette == 4) {
             if (score == guessnum) {
                gewinn = (int) einsatz*20+einsatz;
                return true;
            }
            else {
                gewinn = (int) einsatz*(-10)-einsatz;
                return false;
            }
        }
        return false;
    }

    private void highscore(int sc) {
        int hs = 0;
        try {
      File myObj = new File("highscore.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        hs = Integer.parseInt(myReader.nextLine());
      }
      myReader.close();
    } catch (FileNotFoundException e) {
    try {
      File myObj = new File("highscore.txt");
      myObj.createNewFile();
    } catch (IOException ex) {
      System.out.println("An error occurred.");
      ex.printStackTrace();
    }
      System.out.println("An error occurred.");
      e.printStackTrace();
    }


        if (sc > hs) {
            String filePath = "highscore.txt";
        String content = sc + "";

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(content.getBytes());
            System.out.println("File overwritten successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        print("Sie haben einen neuen Highscore erreicht! Dieser liegt jetzt bei " + sc);
        }
        else {
        print("Sie haben keinen neuen Highscore erreicht. Er liegt bei " + hs);
        }

    }

    private void score(int sc) throws InterruptedException {
        int targetScore = sc;
        if (targetScore > 999)
            targetScore = 999;
        if (targetScore <= 0)
            targetScore = 0;
        boolean win = gewinn(sc);
        int currentScore = 0;
        long duration = 10000;
        long startTime = System.currentTimeMillis();

        while (currentScore < targetScore) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            double progress = (double) elapsedTime / duration;

            currentScore = (int) (targetScore * easeOut(progress));

            System.out.print("\r--- " + currentScore + " ---");

            try {
                long sleepTime = (long) (100 * (1 - progress));
                Thread.sleep(Math.max(sleepTime, 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nSie haben " + currentScore + " erreicht!");
        highscore(currentScore);
        print("Berechnet gewinne...");
        wait(2000);
        if (win) {
            print("Sie haben " + gewinn + " gewonnen");
        }
        else {
            print("Sie haben " + gewinn + " verloren");
        }
    }

    public static double easeOut(double value) {
        return 1 - Math.pow(1 - value, 3);
    }

    private void runAnim() {
        print("     |     ");
        print("     |     ");
        print("    ███    ");
        print("    ███    ");
        print("    ███    ");
        print("    ███    ");
        print("    ███    ");
        print("    ███    ");
        print("           ");
        print("           ");

        newFrame();


        print("     |     ");
        print("     |     ");
        print("    ███    ");
        print("    ███    ");
        print("    ███    ");
        print("     ███    ");
        print("     ███    ");
        print("     ███    ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("     |     ");
        print("    ███    ");
        print("    ███    ");
        print("    ████    ");
        print("     ████    ");
        print("     ████    ");
        print("      ██    ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("     |     ");
        print("    ████    ");
        print("     ████    ");
        print("      ███    ");
        print("      ████    ");
        print("       ███    ");
        print("       ███    ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      \\     ");
        print("     ████    ");
        print("      ████    ");
        print("       ███    ");
        print("        ████    ");
        print("        ████    ");
        print("          ███");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      \\     ");
        print("     ████    ");
        print("      ████    ");
        print("       ████    ");
        print("        ████    ");
        print("         ████    ");
        print("           ███");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      \\     ");
        print("      ████    ");
        print("       █████    ");
        print("         ██████   ");
        print("          ██████    ");
        print("              ███    ");
        print("           ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      |_____██    ");
        print("          ██████   ");
        print("           ██████   ");
        print("             ██████ ");
        print("                ███    ");
        print("                  ");
        print("           ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      |_____  ████    ");
        print("            ████████   ");
        print("              ██████████   ");
        print("                █████████ ");
        print("                    ███  ");
        print("                  ");
        print("           ");
        print("           ");
        print("           ");


        newFrame();

        print("     |     ");
        print("      |_____  ███████    ");
        print("            ██████████████   ");
        print("              ███████████████   ");
        print("                    █████ ");
        print("                     ");
        print("                  ");
        print("           ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      |_____ █████████████    ");
        print("            ███████████████   ");
        print("                 ████████   ");
        print("                      ");
        print("                     ");
        print("                  ");
        print("           ");
        print("           ");
        print("           ");

        newFrame();

        print("     |     ");
        print("      |_____ █████████████    ");
        print("             █████████████   ");
        print("   ");
        print("                      ");
        print("                     ");
        print("                  ");
        print("           ");
        print("           ");
        print("           ");


    }

    private void addSpace() {
        spaceCount++;
    }

    private void newFrame() {
        wait(50);
        for(int i = 0; i < 200; i++)
            System.out.println();

    }

    private void print(String s) {
        System.out.println(s);
    }

    private void wait(int sec) {
        try {
            Thread.sleep(sec);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
