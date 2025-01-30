public class Protecter extends Character{
    public Protecter(){
        Leben=1;
        Classe="Protecter";
        Team=1;
        Reinfolge=6;
    }
    public void Feahikeit(){
        if (!Sabotirt) {
            System.out.println("Welchen Spieler möchtest du diese Nacht beschützten?");
            int gesuchterspieler = scanner.nextInt();
            findspieler(gesuchterspieler).changeProtectet(true);
        }else {
            Sabotirt=false;
            System.out.println("HAHA");
        }
    }
}
