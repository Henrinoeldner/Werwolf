import java.util.Objects;

public class Seherin extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Seherin(){
        Leben=1;
        Classe="Seherin";
        Team=1;
        Reinfolge=5;
    }

    /**
     * Gibt die Rolle des vom Benutzter gewählten Spielers zurück
     * (Außer der Schattenwerwolf wird betrachtet, dann wird Dorfbewohner ausgegeben)
     */
    public void Feahikeit(){
        // Abfrage, ob er sabortiert wurde.
        if (!Sabotirt&&Leben>0){
            // Abfrage welcher Spieler angeschaut werden soll
            System.out.println("Von welchem Spieler möchtest du die Rolle sehen?");
            int gesuchterspieler = scanner.nextInt();
            // Spieler wird angeschaut
            String erblickteklasse = findspieler(gesuchterspieler).getClasse();
            // Abfrage, ob der angeschaute Spieler Schattenwerwolf ist (kann nicht angeschaut werden)
            if (erblickteklasse.equals("Schattenwerwolf")){
                //Falls sschattenwerwolf wird Dorfbewohner angezeigt
                System.out.println("Der erblickte Spieler ist Dorfbewohner");
            }else{
                //Ansonsten die reale Figur
                System.out.println("Der erblickte Spieler ist "+erblickteklasse);
            }
        }else{
            // // Falls er sabortiert wird, wird die sabortation zurück gesetzt
            Sabotirt=false;
            System.out.println("HAHA");
        }

    }
}
