import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Erzaehler {
     public static Character[] spielendecharactere;
     private List<Character> moeglicheWerwolfcharacter;
     private List<Character> moeglicheDorfbewohner;
     public static List<Character> totespieler;

     public Erzaehler(int pAnzahanspielern){
          moeglicheWerwolfcharacter=new ArrayList<>();
          moeglicheDorfbewohner=new ArrayList<>();
          spielendecharactere = new Character[pAnzahanspielern];
          moeglicheWerwolfcharacter.add(new Werwolf());
          moeglicheWerwolfcharacter.add(new BlinderWerwolf());
          moeglicheWerwolfcharacter.add(new Weißerwerwolf());
          moeglicheWerwolfcharacter.add(new Werwolfseher(this));


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
          moeglicheDorfbewohner.add(new Joker(this));

          totespieler= new ArrayList<>();

     }
     public Erzaehler(){}

     /**
      * Befült das Array der Spielende Charactere mit zufälligen Objekten der Listen möglichen Dorfbewohner und möglichen Werwölfen im Verhältnis
      * 3 Dorfbewohner 1 Werwolf. Wenn ein Dorfbewohner honzugefügt werden soll, wird ein neues Objekt erschaffen. Selbest gilt für den Werwolf.
      * Auch wird jedem Objekt ein zufälliger Spieler zugewiesen
      */
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

     /**
      * Sortiert das Array der Spielenden Charactere mit dem Bubblesort verfahren nach der Reihenfolge in welcher die Fähigkeiten in der Nacht aufwachen
      */
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

     /**
      * Mischt das Array der spielenden Charactern
      */
     public void charackteremischen(){
          Character charecterspeicher;

          for(int i=0;i<spielendecharactere.length;i++){
               int speicher=(int)(Math.random()* spielendecharactere.length);
               charecterspeicher=spielendecharactere[speicher];
               spielendecharactere[speicher]=spielendecharactere[i];
               spielendecharactere[i]=charecterspeicher;
          }

     }

     /**
      * Geht den Spielablauf durch (Nachts alle Fähigkeiten und Tags die Abstimmung)
      */
     public void spielen(){
          boolean werwoelfevorbei;
          List<Character> angeklagte= new ArrayList<>();
          List<Integer> stimmen= new ArrayList<>();
          this.characktereerstellen();

          while (!this.spielvorbei()) {
               this.sotiren();
               werwoelfevorbei=false;
               for (int i = 0; i < spielendecharactere.length; i++) {
                    if (spielendecharactere[i].getReinfolge() < 15) {
                         if (spielendecharactere[i].getReinfolge()>9&&!werwoelfevorbei) {
                              werwolfsterben();
                              werwoelfevorbei=true;
                         }
                         System.out.println("Spieler " + spielendecharactere[i].getSpieler() + ", du bist dran. Du bist " + spielendecharactere[i].getClasse());
                         spielendecharactere[i].Feahikeit();

                    }
               }
               if (!werwoelfevorbei){
                    werwolfsterben();
               }
               //Ausortirung der Toten//
              for (Character value : spielendecharactere) {
                  if (value.getLeben() <= 0) {
                      value.Feahikeit();
                      value.sterben();
                  }
              }

                    //Beginn des Tages und abstimmungen//
              for (Character character : spielendecharactere) {
                   character.setLiebespatner(null);
              }
               System.out.println("Der Tag hat begonnen");
               this.charackteremischen();
               angeklagte.clear();

               //Anklagenn//
               for (int i = 0; i < spielendecharactere.length; i++) {
                    Character speicher = spielendecharactere[i].anklagen();
                    if (!angeklagte.contains(speicher)) {
                         angeklagte.add(speicher);
                         stimmen.add(0);
                    }
               }
               if (!angeklagte.isEmpty()) {
                    //Weahlen welcher der angeklagten Spieler herausgeworfen wird//
                    System.out.println("Folgende Spieler sind angeklagt:");
                    for (int i = 0; i < angeklagte.size(); i++) {
                         if (angeklagte.get(i) != null) {
                              System.out.println("[" + i + "] Spieler " + angeklagte.get(i).getSpieler());
                         }
                    }
                    for (int i = 0; i < spielendecharactere.length; i++) {
                         int spielerplatz = spielendecharactere[i].abstimmen();
                         if (spielerplatz < stimmen.size()) {
                              stimmen.set(spielerplatz, stimmen.get(spielerplatz) + 1);
                         } else {
                              System.out.println("Da dein eingegebene Zahl größer war als die anzahl der angeklagten Spieler wird deine Wahl nicht gewertet");
                         }
                    }

                    //Bestimmung des Spielers mit der höchsten Stimmen Anzahl//
                    int großtestimmeanzahl = 0;
                    ArrayList<Character> schuldige = new ArrayList<>();
                    for (int i = 0; i < stimmen.size(); i++) {
                         if (stimmen.get(i) >= großtestimmeanzahl) {
                              if (stimmen.get(i) == großtestimmeanzahl) {
                                   schuldige.add(angeklagte.get(i));
                              } else {
                                   großtestimmeanzahl = stimmen.get(i);
                                   schuldige.clear();
                                   schuldige.add(angeklagte.get(i));
                              }
                         }
                    }

                    //--------Raugewaeltn Spiler rauswerfen ------------//
                    Character toter = schuldige.get((int) (Math.random() * schuldige.size()));
                    toter.setLeben(0);
                    toter.Feahikeit();
                    toter.sterben();
               }
          }
     }



     private boolean spielvorbei(){
          int erstesteam;
          erstesteam= spielendecharactere[0].getTeam();
          for (int i=1;i<spielendecharactere.length;i++){
               if (erstesteam!=spielendecharactere[i].getTeam()){
                    return false;
               }
          }
          System.out.println("Das Spiel ist vorbei" );
          //Ausgabe des Gewinnerteams muss noch gemacht werden
          return true;
     }

     public void werwolfsterben(){
          int großtestimmeanzahl=0;
          ArrayList<Character> schuldige = new ArrayList<>();
          for (int i = 0; i < Werwolf.werwolfopfer.size(); i++) {
               if (Werwolf.werwolfopfer.get(i).getStimmen() >= großtestimmeanzahl) {
                    if (Werwolf.werwolfopfer.get(i).getStimmen() == großtestimmeanzahl) {
                         schuldige.add(Werwolf.werwolfopfer.get(i));
                    } else {
                         großtestimmeanzahl = Werwolf.werwolfopfer.get(i).getStimmen();
                         schuldige.clear();
                         schuldige.add(Werwolf.werwolfopfer.get(i));
                    }
               }
          }
          Character toter = schuldige.get((int) (Math.random() * schuldige.size()));
          toter.setLeben(0);
          Werwolf.werwolfopfer.clear();
     }
}
