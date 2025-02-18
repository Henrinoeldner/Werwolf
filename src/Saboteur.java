public class Saboteur extends Character{
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
        System.out.println("Welchen Spieler möchtest du diese Nacht Sabotieren ?");
        int gesuchterspieler = scanner.nextInt();
        findspieler(gesuchterspieler).sabotirt();

    }
}
