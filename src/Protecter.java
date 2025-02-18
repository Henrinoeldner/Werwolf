public class Protecter extends Character{
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
