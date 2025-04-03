public class Protecter extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    int beschuetzterspieler; // merkt sich wer in der runde davor beschützt wurde.
    public Protecter(){
        Leben=1;
        Classe="Protecter";
        Team=1;
        Reinfolge=6;

    }

    /**
     * Läst ein Spieler aussuchen der diese Nacht beschützt ist und nicht Sterben kann
     */
    public void Feahikeit(){
        if (!Sabotirt&&Leben>0) {
            // frage an den Spieler wenn er beschützen möchte.
            System.out.println("Welchen Spieler möchtest du diese Nacht beschützten?");
           //Rückgabe an den Computer wer beschützt werden soll.
            int gesuchterspieler = scanner.nextInt();
            // überprüft ob der geschütztespieler vorher schon geschützt wurde. falls  nicht
            if (gesuchterspieler != beschuetzterspieler) {
                // wird die Variable protectet auf true so dass der Spieler protectet ist.
                findspieler(gesuchterspieler).changeProtectet(true);
                // überprüft ob die Variable beschuetzterspieler einen Wert hat
                // wenn dies nicht der fall ist wird die schleife
                // übersprungen da sonst das Programm abstürzt.
                if (beschuetzterspieler != 0){
                    findspieler(beschuetzterspieler).changeProtectet(false);
                    // setzt die Variable protectet von dem der in der runde davor beschützt
                    // wurde auf false so das er wieder getötet werden kann
                }
                // beschuetzterspieler wird auf den wert des Ateullen beschützten
                // spieler gesetzt für die nächste runde
                beschuetzterspieler = gesuchterspieler;
            }// falls der Spieler der beschützt werden soll erneut beschützt werden
            // soll. Dies ist nicht erlaubt.
            // spieler wird aufgefordert einen anderen Spieler zu schützten
            else{
                System.out.println("Du darfst nicht 2 mal hintereinander die selbe Person schützen");
                Feahikeit(); // Rekursive aufruf der methode
            }
        }else //falls der Spieler sabortiert wurde und nimanden beschützen kann

            {
            Sabotirt=false;
            System.out.println("HAHA Wurdest Sabortiert");
        }
    }
}
