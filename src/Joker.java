import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joker extends Character{
    private Character neuercaracter;
    List<Character> moeglicheWerwolfcharacter;
    List<Character> moeglicheDorfbewohner;
    private boolean benutzt;
    public Joker(){

        Leben=1;
        Classe="Joker";
        Team=1;
        Reinfolge=2;
        benutzt=false;
        moeglicheWerwolfcharacter.add(new Werwolf());
        moeglicheWerwolfcharacter.add(new BlinderWerwolf());
        moeglicheWerwolfcharacter.add(new Weißerwerwolf());
        moeglicheWerwolfcharacter.add(new Werwolfseher());


        moeglicheDorfbewohner.add(new Dorfbewohner());
        moeglicheDorfbewohner.add(new Alterman());
        moeglicheDorfbewohner.add(new Amor());
        moeglicheDorfbewohner.add(new Dieb());
        moeglicheDorfbewohner.add(new Hexe());
        moeglicheDorfbewohner.add(new HexenJeager());
        moeglicheDorfbewohner.add(new Jeager());
        moeglicheDorfbewohner.add(new Necromant());
        moeglicheDorfbewohner.add(new Protecter());
        moeglicheDorfbewohner.add(new Saboteur());
        moeglicheDorfbewohner.add(new Schlafwandlerin());
        moeglicheDorfbewohner.add(new Seherin());
        moeglicheDorfbewohner.add(new Totengreaber());
        moeglicheDorfbewohner.add(new Vampier());
        moeglicheDorfbewohner.add(new Verfluchter());
    }
    public void Feahikeit(){

        Scanner scanner= new Scanner(System.in);
        int option;

        //Wenn die faehikeit des Jokers bereits benutzt wurde, wird die Faehikeit von dem neuen Charakter benutzt.
        if (benutzt){
        neuercaracter.Feahikeit();
        }
        //Wenn die Feahikeit des Jokers noch nicht benutzt wird, wird ein neuer Charakter gewaehlt der spaeter benutzt wird
        else{
            System.out.println("Welchen Character moechtest du spielen?");
            for(int i=0; i<3;i++){
                System.out.println("["+i+"] "+moeglicheWerwolfcharacter.get(i));

            }
            for(int i=3; i< moeglicheDorfbewohner.size()+2;i++){
                System.out.println("["+i+"] "+moeglicheDorfbewohner.get(i-3));

            }
            option= scanner.nextInt();

            if (option<4){
                neuercaracter= moeglicheWerwolfcharacter.get(option);
            }else{
                neuercaracter=moeglicheDorfbewohner.get(option-4);

            }
            Leben=neuercaracter.getLeben();
            Classe=neuercaracter.getClasse();
            Team=neuercaracter.getTeam();
            Reinfolge=neuercaracter.getReinfolge();
        }


    }
}
