public class Schlafwandlerin extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Schlafwandlerin(){
        Leben=1;
        Classe="Schlafwandlerin";
        Team=1;
        Reinfolge=4;
    }

    /**
     * Lässt den Benutzter wählen, bei wem er diese Nacht bleiben wird.
     */
    public void Feahikeit(){
        //Überprüfung ob sabortiert wurde
        if (!Sabotirt){
            System.out.println("Bei welchem Spieler verbringst du diese Nacht?");
            // auswahl des Übernachtungspartners wird gespeichertin einer variable
            int gesuchterspieler = scanner.nextInt();
            // Der Übernachtungspartner wird gefunden mit der Methode findspieler in caracter
            // und wird als Übernachtungspartner gesetzt mit der Methode setSchlafwandlerin in Caracter
            findspieler(gesuchterspieler).setSchlafwandlerin(this);
        }else{
            Sabotirt=false;
            // Falls er sabortiert wird wird die sabortation zurück gesetzt
           System.out.println("HAHA wurdest sabortiert");
        }
    }
}
