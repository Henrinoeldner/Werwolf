import java.util.Scanner;
public abstract class Character {
    protected Scanner scanner=new Scanner(System.in);
    public int Leben; //Leben gibt die Anzahl der Leben wieder. Wenn die leben Null ereichen Stirbt der Chahrakter
    public String Classe; //Gibt an welche klasse (Werwolf, hexe,...) an
    public int Team; //Team gibt an, welches Team der Charackter ist (werwolf:0,Dorfbewohner:1,Liebende:2,Vampir:3;Weißerwerwolf:4)
    public boolean Sabotirt;// wenn Sabotirt, dann kann feahikeit nicht benutzt werden
    public int Reinfolge;// Reinfolge bestimmt, wann die karte dran ist (Bsp: erst 1 dann 3 und dann 4)
    public int Stimmen; // Stimmen gibt an wie viele Leute bereits für diesen charakter gestimmt haben
    public boolean Protectet; // wenn Protecte stimmt, dann kann dieser Character in der Nacht nicht sterben
    public boolean Gebissen; // wenn alle gebissen wahr dann gewint der vampier zusätzlich muss team geander werden
    public boolean Buegermeister;// wenn Buegermeister wahr ist, hat diese Karte zwei stimmen auser bei unentschieden. Dann nur 1
    public Character Liebespatner;// merkt sich, wer der Liebespatner ist.
    public String Schlafwandlerin; //merkt sich, bei wem sich die Schlafwandlerin befindet
    public int Stearke;//Gibt die steake der Karte an
    // sabotirt setzt die variable Sabotirt auf den mitgegebnenen @Parameter
    public boolean Angeklagt;
    public int spieler;
    public Character[] spielendecharactere;

    public void setSpieler(int pspieler) {
        spieler = pspieler;
    }

    public int getSpieler() {
        return spieler;
    }

    public abstract void Feahikeit();

    public void sabotirt() {
        Sabotirt = true;
    }

    //getLeben gibt die Variable Leben zurueck
    public int getLeben() {
        return Leben;
    }

    public void changeleben() {
        Leben -= 1;
    }

    public int getTeam() {
        return Team;
    }
    public void setTeam(int pTeam){
       Team=pTeam;
    }

    public int getReinfolge() {
        return Reinfolge;
    }

    public int getStimmen() {
        return Stimmen;
    }

    public void changeStimmen() {
        Stimmen = Stimmen + 1;
    }

    public void changeProtectet(boolean pProtectet) {
        Protectet = pProtectet;
    }

    public void changeGebissen() {
        Gebissen = !Gebissen;
    }

    public boolean getGebissen() {
        return Gebissen;
    }

    public void changeBuergemeister() {
        Buegermeister = !Buegermeister;
    }

    public Character anklagen(){
        System.out.println("Spieler "+spieler+", welchen Spieler möchtest du anklagen (0 wenn du niemanden anklagen möchtest)? ");
        int gesuchterspieler =scanner.nextInt();
        if (gesuchterspieler!=0) {
            return findspieler(gesuchterspieler);
        }else{
            Character dumie=new Dorfbewohner();
            dumie.setSpieler(0);
            return dumie;
        }

    }

    public Character anklagen(){
        System.out.println("Spieler "+spieler+", welchen Spieler möchtest du anklagen (0 wenn du niemanden anklagen möchtest)? ");
        int gesuchterspieler =scanner.nextInt();
        if (gesuchterspieler!=0) {
            return findspieler(gesuchterspieler);
        }else{
            Character dumie=new Dorfbewohner();
            dumie.setSpieler(0);
            return dumie;
        }

    }
    public int abstimmen(){
        return scanner.nextInt();
    }

    public boolean getAngeklagter() {
        return Angeklagt;
    }

    public void changeAngeklagt() {
        Angeklagt = !Angeklagt;
    }

    public void setLiebespatner(Character pLiebespartner) {
        Liebespatner = pLiebespartner;
    }

    public void changeClass(String pCharacter) {
        Classe = pCharacter;
    }

    public String getClasse() {
        return Classe;
    }


    public Character findspieler(int pSpieler) {
        this.spielendecharactere= Erzaehler.spielendecharactere;
        for (int i = 0; i < spielendecharactere.length; i++) {
            if (spielendecharactere[i].getSpieler() == pSpieler) {
                return spielendecharactere[i];
            }
        }
        return spielendecharactere[spielendecharactere.length-1];
    }
}
















































