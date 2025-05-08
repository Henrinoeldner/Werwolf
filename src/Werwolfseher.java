public class Werwolfseher extends Character{
    private Erzaehler erzaehler;
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Werwolfseher(Erzaehler pErzaehler){
        erzaehler=pErzaehler;
        Leben=1;
        Classe="Werwolfseher";
        Team=0;
        Reinfolge=8;
    }

    /**
     * Gibt die Rolle des vom Benutzter gewählten Spielers zurück
     * (Außer der Schattenwerwolf wird betrachtet, dann wird Dorfbewohner ausgegeben)
     */
   public void Feahikeit(){
        // Abfrage ob er sabortiert wurde.
        if (!Sabotirt){
                // Abfrage welcher Spieler angeschaut werden soll
                System.out.println("Von welchem Spieler möchtest du die Rolle sehen?");
                int gesuchterspieler = scanner.nextInt();
                // Spieler wird angeschaut
                String erblickteklasse = findspieler(gesuchterspieler).getClasse();
                // Abfrage ob der angeschaute Spieler Schattenwerwolf ist (kann nicht angeschaut werden)
                if (erblickteklasse.equals("Schattenwerwolf")) {
                    //Falls sschattenwerwolf wird Dorfbewohner angezeigt
                    System.out.println("Der erblickte Spieler ist Dorfbewohner");
                } else {
                    //Ansonsten die reale Figur
                    System.out.println("Der erblickte Spieler ist " + erblickteklasse);
                }
                System.out.println("Wähle den Spieler den gerne verspeisen möchtest.");
                gesuchterspieler = scanner.nextInt();
                Character speicher= findspieler(gesuchterspieler);
                Werwolf.werwolfopfer.add(speicher);
                speicher.changeStimmen();
        }else{
            // // Falls er sabortiert wird wird die sabortation zurück gesetzt
            Sabotirt=false;
            System.out.println("HAHA");
        }

    }
}
