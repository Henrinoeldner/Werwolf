import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joker extends Character{
    private Character neuercaracter;
    List<Character> moeglicheWerwolfcharacter; //Erstellen der Listen an Characteren die der Joker annehmen kann.
    List<Character> moeglicheDorfbewohner;
    // Werwolf und Dorfbewohner werden in getrennten Listen gespeichert um die
    // Teams einfacher zuteilen zu können.

    private boolean benutzt; // Initalsierung von der Variable benutzt
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character). Beim Joker werden zusätzlich noch alle
     * Rollen mit gegeben die der Joker annehmen kann. Diese werden in einer Liste gespeichert
     * und ob er seine fähigkeit bereits genutzt hat. Bei false ist dies nicht der fall bei True
     * wurde die Fähigkeit des jokers bereits benutzt
     */
    public Joker(){

        Leben=1;
        Classe="Joker";
        Team=1;
        Reinfolge=2;
        benutzt=false;
        moeglicheWerwolfcharacter=new ArrayList<>();
        moeglicheDorfbewohner=new ArrayList<>();
        //befüllen der Werwolfliste.
        moeglicheWerwolfcharacter.add(new Werwolf());
        moeglicheWerwolfcharacter.add(new BlinderWerwolf());
        moeglicheWerwolfcharacter.add(new Weißerwerwolf());
        moeglicheWerwolfcharacter.add(new Werwolfseher());

        // befüllen der Dorfbewohner liste
        moeglicheDorfbewohner.add(new Dorfbewohner());
        moeglicheDorfbewohner.add(new Alterman());
        moeglicheDorfbewohner.add(new Amor());
        moeglicheDorfbewohner.add(new Dieb());
        moeglicheDorfbewohner.add(new Hexe());
        moeglicheDorfbewohner.add(new HexenJeager());
        moeglicheDorfbewohner.add(new Jeager());
        moeglicheDorfbewohner.add(new Necromant());
        moeglicheDorfbewohner.add(new Protecter());
        moeglicheDorfbewohner.add(new Saboteur());
        moeglicheDorfbewohner.add(new Schlafwandlerin());
        moeglicheDorfbewohner.add(new Seherin());
        moeglicheDorfbewohner.add(new Totengreaber());
        moeglicheDorfbewohner.add(new Vampier());
        moeglicheDorfbewohner.add(new Verfluchter());
    }

    /**
     * Lässt den Spieler eine neue Rolle aussuchen, welche er dann übernimmt und fortan als diese spielt
     */
    public void Feahikeit() {

        Scanner scanner = new Scanner(System.in);
        int option;
        if (!Sabotirt) {
            //Wenn die faehikeit des Jokers bereits benutzt wurde, wird die Faehikeit von dem neuen Charakter benutzt.
            if (benutzt) {
                neuercaracter.Feahikeit();
            }
            //Wenn die Feahikeit des Jokers noch nicht benutzt wird, wird ein neuer Charakter gewaehlt der spaeter benutzt wird
            else {
                //Ausgabe an den Benutzter welche Rolle er wählen kann.
                System.out.println("Welchen Character moechtest du spielen?");
                for (int i = 0; i < 3; i++) {
                    System.out.println("[" + i + "] " + moeglicheWerwolfcharacter.get(i));

                }
                for (int i = 3; i < moeglicheDorfbewohner.size() + 2; i++) {
                    System.out.println("[" + i + "] " + moeglicheDorfbewohner.get(i - 3));

                }
                option = scanner.nextInt();
                // Rückgabe an den Computer welcher Character ausgewählt wurde
                if (option < 4) {
                    neuercaracter = moeglicheWerwolfcharacter.get(option);
                } else {
                    neuercaracter = moeglicheDorfbewohner.get(option - 4);

                }
                // Die Variabeln Leben Classe Team und rheinfolge werden auf die werte des neugewählten Chracters initaliesiert.
                Leben = neuercaracter.getLeben();
                Classe = neuercaracter.getClasse();
                Team = neuercaracter.getTeam();
                Reinfolge = neuercaracter.getReinfolge();
            }


        }else //falls der Joker sabortiert wird
        // und sich keinen Character auswählen darf wird er als normaler Dorfbewohner gewertet..
        {
            benutzt = true;
            Reinfolge=15;
            Sabotirt=false;
            System.out.println("HAHA Wurdest sabortiert.");
        }
    }
}
