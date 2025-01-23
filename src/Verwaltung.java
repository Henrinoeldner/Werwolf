
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
            System.out.println("Was moechtest du testen?");
            System.out.println("[1]Erzealer");
            int option = scanner.nextInt();
            if (option == 1) {
                Erzaehler erzaehler=new Erzaehler(5);
               erzaehler.spielen();
            }
        }
        }
}
