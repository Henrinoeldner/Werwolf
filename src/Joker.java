import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joker extends Character{
    private Character neuerkaracter;
    List<Character> moeglicheWerwolfcharacter;
    List<Character> moeglicheDorfbewohner;
    private boolean benutzt;
    public Joker(List<Character> pList1,List<Character> pList2){
        Leben=1;
        Classe="Joker";
        Team=1;
        Reinfolge=2;
        benutzt=false;
        moeglicheWerwolfcharacter=pList1;
        moeglicheDorfbewohner=pList2;
    }
    public void Feahikeit(){

        Scanner scanner= new Scanner(System.in);
        int option;

        //Wenn die faehikeit des Jokers bereits benutzt wurde, wird die Faehikeit von dem neuen Charakter benutzt.
        if (benutzt){
        neuerkaracter.Feahikeit();
        }
        //Wenn die Feahikeit des Jokers noch nicht benutzt wird, wird ein neuer Charakter gewaehlt der spaeter benutzt wird
        else{
            System.out.println("Welchen Character moechtest du spielen?");
            for(int i=0; i<4;i++){
                System.out.println("["+i+"] "+moeglicheWerwolfcharacter.get(i));

            }
            for(int i=4; i< moeglicheDorfbewohner.size()+4;i++){
                System.out.println("["+i+"] "+moeglicheWerwolfcharacter.get(i-4));

            }
            option= scanner.nextInt();

            if (option<4){
                neuerkaracter=moeglicheWerwolfcharacter.get(option);
            }else{
                neuerkaracter=moeglicheDorfbewohner.get(option-4);

            }
            Leben=neuerkaracter.getLeben();
            Classe=neuerkaracter.getClasse();
            Team=neuerkaracter.getTeam();
            Reinfolge=neuerkaracter.getReinfolge();
        }


    }
}
