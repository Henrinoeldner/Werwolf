import java.util.List;
import java.util.Random;

public class Erzaehler {
     public Character[] spielendecharactere = new Character[5];
     List<Character> moeglicheWerwolfcharacter;

     public Erzaehler(){
          moeglicheWerwolfcharacter.add(new Werwolf());
          moeglicheWerwolfcharacter.add(new BlinderWerwolf());
          moeglicheWerwolfcharacter.add(new Weißerwerwolf());
          moeglicheWerwolfcharacter.add(new Werwolfseher());
     }
     public void test(){
          //Sorgt fuer ein verheltnis zwischen Werwoelfen und Dorfbewohneren(ein werwolf fuer alle drei dorfbeohner)
          int anzahlwerwoelfe=(spielendecharactere.length-1)/3;

          for(int i=0;i<anzahlwerwoelfe;i++){
               int speicher=(int)(Math.random()* moeglicheWerwolfcharacter.size());
               spielendecharactere[i]=moeglicheWerwolfcharacter.get(speicher);

               //wenn die gewaelte charakter kein einfacher Werwolf ist wird er aus der Liste der moeglichen Charakteren entfernt.
               if (speicher!=0) {
                    moeglicheWerwolfcharacter.remove(speicher);
               }
          }
     }
}
