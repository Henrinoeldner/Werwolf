public class Jeager extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Jeager(){
        Leben=1;
        Classe="Jaeger";
        Team=1;
        Reinfolge=15;
    }

    /**
     * Der Spieler kann sich ein Spieler aussuchen der dann stirbt
     */
    public void Feahikeit(){
        if(!Sabotirt){
            System.out.println("Welchen spieler möchtest du it deinem letzten Atemzug noch erschießen?");
            findspieler(scanner.nextInt()).sterben();
        }else{
            System.out.println("Du wurdest sabotiert und kannst deinen Fähigkeit nicht benutzten");
            Sabotirt=false;
        }

    }
}
