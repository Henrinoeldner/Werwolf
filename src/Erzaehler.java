import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Erzaehler {
     public Character[] spielendecharactere;
     List<Character> moeglicheWerwolfcharacter;
     List<Character> moeglicheDorfbewohner=new ArrayList<>();

     public Erzaehler(int pAnzahanspielern){
          moeglicheWerwolfcharacter=new ArrayList<>();
          moeglicheDorfbewohner=new ArrayList<>();
          spielendecharactere = new Character[pAnzahanspielern];
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
          moeglicheDorfbewohner.add(new Joker());
          moeglicheDorfbewohner.add(new Necromant());
          moeglicheDorfbewohner.add(new Protecter());
          moeglicheDorfbewohner.add(new Saboteur());
          moeglicheDorfbewohner.add(new Schlafwandlerin());
          moeglicheDorfbewohner.add(new Seherin());
          moeglicheDorfbewohner.add(new Totengreaber());
          moeglicheDorfbewohner.add(new Vampier());
          moeglicheDorfbewohner.add(new Verfluchter());

     }

     public void characktereerstellen(){
          //Sorgt fuer ein verheltnis zwischen Werwoelfen und Dorfbewohneren(ein werwolf fuer alle drei dorfbeohner)
          int anzahlwerwoelfe=(spielendecharactere.length-1)/3;

          for(int i=0;i<anzahlwerwoelfe;i++){
               int speicher=(int)(Math.random()* moeglicheWerwolfcharacter.size());
               spielendecharactere[i]=moeglicheWerwolfcharacter.get(speicher);

               //wenn die gewaelte charakter kein einfacher Werwolf ist, wird er aus der Liste der moeglichen Charakteren entfernt.
               if (speicher!=0) {
                    moeglicheWerwolfcharacter.remove(speicher);
               }
          }
          for(int i=anzahlwerwoelfe;i<spielendecharactere.length;i++){
               int speicher=(int)(Math.random()* moeglicheDorfbewohner.size());
               spielendecharactere[i]=moeglicheDorfbewohner.get(speicher);
               //wenn die gewaelte charakter kein einfacher Werwolf ist, wird er aus der Liste der moeglichen Charakteren entfernt.
               if (speicher!=0) {
                    moeglicheDorfbewohner.remove(speicher);
               }
          }
          charackteremischen();
     }
     public void charackteremischen(){
          Character charecterspeicher;
          for(int i=0;i<spielendecharactere.length;i++){
               int speicher=(int)(Math.random()* spielendecharactere.length);
               charecterspeicher=spielendecharactere[speicher];
               spielendecharactere[speicher]=spielendecharactere[i];
               spielendecharactere[i]=charecterspeicher;
          }
     }
}
