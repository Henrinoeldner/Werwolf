public class Saboteur extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Saboteur(){
        Leben=1;
        Classe="Saboteur";
        Team=1;
        Reinfolge=1;
    }

    /**
     * Läst den Benutzter ein spieler wählen der diese Nacht seine Fähigkeit nicht nutzten kann
     */
    public void Feahikeit(){
        // abfrage ob er sabortiert wurde.
        if(!Sabotirt&&Leben>0){
        System.out.println("Welchen Spieler möchtest du diese Nacht Sabotieren ?");
        //Der Spieler der sabortiert wird wir in einer variable gespeichert.
        int gesuchterspieler = scanner.nextInt();
        // Der spieler wird mit der Methode findspieler gefunden und seine fahigkeit wird auf sabortiert gesezt
        // mit der Methode sabortiert in Caracter
        findspieler(gesuchterspieler).sabotirt();
        } else {
            System.out.println("Du wurdest sabortiert");
            Sabotirt = false;
        }
    }
}
