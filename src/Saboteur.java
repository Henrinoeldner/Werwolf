public class Saboteur extends Character{
    public Saboteur(){
        Leben=1;
        Classe="Saboteur";
        Team=1;
        Reinfolge=1;
    }
    public void Feahikeit(){
        System.out.println("Welchen Spieler möchtest du diese Nacht Sabotieren ?");
        int gesuchterspieler = scanner.nextInt();
        findspieler(gesuchterspieler).sabotirt();

    }
}
