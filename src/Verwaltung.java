
import java.util.Scanner;


public class Verwaltung {
    private Scanner scanner;
    public static void main(String[] args) {

        new Verwaltung();


    }

    public Verwaltung(){
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("== HAUPTMENÜ ==");
            System.out.println("Wie viele Spieler spielen mit?");
            int pAnzahl = scanner.nextInt();
                Erzaehler erzaehler=new Erzaehler(pAnzahl);
                System.out.println("Viel spaß beim spielen");
               erzaehler.spielen();
        }
        }
}
