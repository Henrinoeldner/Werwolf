public class Schlafwandlerin extends Character{
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
        if (!Sabotirt){
            System.out.println("Bei welchem Spieler verbringst du diese Nacht?");
            int gesuchterspieler = scanner.nextInt();
            findspieler(gesuchterspieler).setSchlafwandlerin(this);
        }else{
            Sabotirt=false;
           System.out.println("HAHA");
        }
    }
}
