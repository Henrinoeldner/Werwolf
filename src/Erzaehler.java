import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Erzaehler {
     public static Character[] spielendecharactere;
     public List<Character> moeglicheWerwolfcharacter;
     List<Character> moeglicheDorfbewohner;

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
          moeglicheDorfbewohner.add(new Necromant());
          moeglicheDorfbewohner.add(new Protecter());
          moeglicheDorfbewohner.add(new Saboteur());
          moeglicheDorfbewohner.add(new Schlafwandlerin());
          moeglicheDorfbewohner.add(new Seherin());
          moeglicheDorfbewohner.add(new Totengreaber());
          moeglicheDorfbewohner.add(new Vampier());
          moeglicheDorfbewohner.add(new Verfluchter());
          moeglicheDorfbewohner.add(new Joker());

     }
     public Erzaehler(){}

     public void characktereerstellen(){
          //Sorgt fuer ein verheltnis zwischen Werwoelfen und Dorfbewohneren(ein werwolf fuer alle drei dorfbeohner)
          int anzahlwerwoelfe=(spielendecharactere.length-1)/3;
          for(int i=0;i<anzahlwerwoelfe;i++){
               int speicher=(int)(Math.random()* moeglicheWerwolfcharacter.size());
               //wenn die gewaelte charakter kein einfacher Werwolf ist, wird er aus der Liste der moeglichen Charakteren entfernt.
               if (speicher!=0) {
                    spielendecharactere[i]=moeglicheWerwolfcharacter.get(speicher);
                    moeglicheWerwolfcharacter.remove(speicher);
               }else{
                    spielendecharactere[i]=new Werwolf();
               }
          }

          for(int i=anzahlwerwoelfe;i<spielendecharactere.length;i++){
               int speicher=(int)(Math.random()* moeglicheDorfbewohner.size());
               //wenn die gewaelte charakter kein einfacher Werwolf ist, wird er aus der Liste der moeglichen Charakteren entfernt.
               if (speicher!=0) {
                    spielendecharactere[i]=moeglicheDorfbewohner.get(speicher);
                    moeglicheDorfbewohner.remove(speicher);
               }else{
                    spielendecharactere[i]=new Dorfbewohner();
               }
          }

          this.charackteremischen();
          for(int i=0;i<spielendecharactere.length;i++){
               spielendecharactere[i].setSpieler(i+1);
          }
          this.sotiren();
     }
     public void sotiren(){

               Character vergleich;
               for (int b = 0; b < spielendecharactere.length - 1; b++) {
                    for (int i = 0; i < spielendecharactere.length - b - 1; i++) {
                         if (spielendecharactere[i].getReinfolge() > spielendecharactere[i + 1].getReinfolge()) {
                              //tausche der vergleichten zahlen
                              vergleich = spielendecharactere[i];
                              spielendecharactere[i] = spielendecharactere[i + 1];
                              spielendecharactere[i + 1] = vergleich;

                         }
                    }
               }

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
     public void spielen(){
          List<Character> angeklagte= new ArrayList<>();
          List<Integer> stimmen= new ArrayList<>();
          this.characktereerstellen();
          this.sotiren();
          for(int i=0;i<spielendecharactere.length;i++){
               if(spielendecharactere[i].getReinfolge()<15){
                    System.out.println("Spieler "+spielendecharactere[i].getSpieler()+", du bist dran. Du bist "+ spielendecharactere[i].getClasse());
                    spielendecharactere[i].Feahikeit();
               }
          }
          for (int i=0;i<spielendecharactere.length;i++){
               if (spielendecharactere[i].getLeben()<1){
                    System.out.println("Spieler "+spielendecharactere[i].getSpieler()+" wurde getötet. Er war"+ spielendecharactere[i].getClass());
                    //spielendecharactere[i].
               }
          }
          System.out.println("Der Tag hat begonnen");
          this.charackteremischen();
          angeklagte.clear();
          for (int i=0;i<spielendecharactere.length;i++){
              Character speicher= spielendecharactere[i].anklagen();
              if(!angeklagte.contains(speicher)){
                   angeklagte.add(speicher);
                   stimmen.add(0);
              }
          }
          System.out.println("Folgende Spieler sind angeklagt:");
          for (int i=0;i<angeklagte.size();i++){
               if(angeklagte.get(i).getSpieler()!=0){
                   System.out.println("["+i+"] Spieler "+angeklagte.get(i).getSpieler());
               }
          }
          for (int i=0;i<spielendecharactere.length;i++){
              System.out.println("Spieler "+spielendecharactere[i]+", wer glaubst du ist der Schuldige?");
              stimmen.add(stimmen.get(spielendecharactere[i].abstimmen())+1);
          }
     }
}
