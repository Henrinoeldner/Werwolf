public class HexenJeager extends Character {
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public HexenJeager(){
        Leben=1;
        Classe="HexenJeager";
        Team=1;
        Reinfolge=15;
    }

    /**
     * Der Spieler kann ein Spieler aussuchen und umbringen.
     * Sollte der ausgewaehlte Spieler hexe sein bekommt der Hexenjaeger eine nette Nachricht
     */
    public void Feahikeit(){
        if(!Sabotirt){
            System.out.println("Welchen spieler möchtest du it deinem letzten Atemzug noch erschießen?");
            Character gewaehltrspieler=findspieler(scanner.nextInt());
            if(gewaehltrspieler.getClasse()=="Hexe"){
                System.out.println("Herzlichen glückwunsch! Du hast erfolgreich die Hexe eliminiert");
                System.out.println("Lass dir ein Bier in der nah gelegenen Taverne ausgeben, leg dich schlafen ");
                System.out.println("und überlass den Rest der komplizierten Sachen den Anderen, ");
                System.out.println("die kommen bestimmt auch ohne Hexe zurecht");
            }
        }else{
            System.out.println("Du wurdest sabotiert und kannst deinen Fähigkeit nicht benutzten");
        }

    }
}
