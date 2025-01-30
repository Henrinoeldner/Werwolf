public class Schlafwandlerin extends Character{
    public Schlafwandlerin(){
        Leben=1;
        Classe="Schlafwandlerin";
        Team=1;
        Reinfolge=4;
    }
    public void Feahikeit(){
        if (!Sabotirt){
            System.out.println("Bei welchem Spieler verbringst du diese Nacht?");
            int gesuchterspieler = scanner.nextInt();
            findspieler(gesuchterspieler).setLiebespatner(this);
        }else{
            Sabotirt=false;
           System.out.println("HAHA");
        }
    }
}
