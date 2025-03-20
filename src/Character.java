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
    public Character Schlafwandlerin; //merkt sich, bei wem sich die Schlafwandlerin befindet
    public int Stearke;//Gibt die steake der Karte an
    // sabotirt setzt die variable Sabotirt auf den mitgegebnenen @Parameter
    public boolean Angeklagt;
    public int spieler;
    public Character[] spielendecharactere;

    /**
     * setzt die Variable spieler auf den Parameter pSpieler.
     * @param pspieler nur als integer
     */
    public void setSpieler(int pspieler) {
        spieler = pspieler;
    }

    /**
     * Gibt den Spieler zurück.
     * @return int spieler
     */
    public int getSpieler() {
        return spieler;
    }

    /**
     * Diese Methode wird in den Unterklassen befüllt und aktiviert jeh nach Character die entsprechende Fähigkeit
     */
    public abstract void Feahikeit();

    /**
     * setzt Sabotirt auf true
     */
    public void sabotirt() {
        Sabotirt = true;
    }

    /**
     * gibt den Wert des Lebens zurück
     * @return int Leben
     */
    public int getLeben() {
        return Leben;
    }

    /**
     * reduziert den wert von Leben um eins
     */
    public void changeleben() {
        Leben -= 1;
    }

    /**
     * @return welchem Team das Objekt angehört (werwolf: 0,Dorfbewohner: 1,Liebende: 2,Vampir: 3,Weißerwerwolf: 4)
     */
    public int getTeam() {
        return Team;
    }

    /**
     * Setzt Team auf den Paramter pTeam
     * @param pTeam (werwolf: 0,Dorfbewohner: 1,Liebende: 2,Vampir: 3,Weißerwerwolf: 4)
     */
    public void setTeam(int pTeam){
       Team=pTeam;
    }

    /**
     * @return die Reinfolge welche bestimmt an welcher stelle der Reihenfolge der Character in der Nacht erwacht
     */
    public int getReinfolge() {
        return Reinfolge;
    }

    /**
     * @return wie viele Spieler bereits für diesen Character gestimmt haben
     */
    public int getStimmen() {
        return Stimmen;
    }

    /**
     * Erhöht die Anzahl der Spieler die für diesen Character gestimmt haben um eins
     */
    public void changeStimmen() {
        Stimmen = Stimmen + 1;
    }

    /**
     * Ändert ob der Character beschützt wird oder nicht.(Variable Protectet)
     * @param pProtectet true wenn Geschützt
     */
    public void changeProtectet(boolean pProtectet) {
        Protectet = pProtectet;
    }

    /**
     * Änder ob dieser Character bereits gebissen wurde
     */
    public void changeGebissen() {
        Gebissen = !Gebissen;
    }

    /**
     * @return den boolean Wert von gebissen
     */
    public boolean getGebissen() {
        return Gebissen;
    }

    /**
     * Ändert ob dieser Character Bürgermeister ist (Variable Buegermeister)
     */
    public void changeBuergemeister() {
        Buegermeister = !Buegermeister;
    }

    /**
     * läst den Benutzter aussuchen, wen er anklagen möchte.
     * Sollte niemand angeklagt werden wird ein Dumie erschaffen der später ignoriert wird.
     * @return den angeklagten Spieler
     */
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

    /**
     * Lästen den Benutzter aussuchen, wen der Angeklagten er auswerfen möchte.
     * @return denn ausgewählten spieler.
     */
    public int abstimmen(){
        System.out.println("Spieler "+spieler+", wer glaubst du ist der Schuldige?");
        return scanner.nextInt();
    }

    /**
     * Setzt Liebespatner auf den Parameter
     * @param pLiebespartner gibt das Character Objekt mit wit welchem derCharacter verliebt wird.
     */
    public void setLiebespatner(Character pLiebespartner) {
        Liebespatner = pLiebespartner;
    }

    /**
     * Merkt sich die Schlafwandlerin
     * @param pSchlafwandlerin
     */
    public void setSchlafwandlerin(Character pSchlafwandlerin){
        Schlafwandlerin=pSchlafwandlerin;
    }

    /**
     * Gibt zurück, welche Rolle der Charakter ist
     * @return den Namen der Rolle des Characters
     */
    public String getClasse() {
        return Classe;
    }

    /**
     *
     * @param pSpieler der gesuchte Spieler
     * @return das Character Objekt dem der gesuchte spieler zugewiesen ist
     */
    public Character findspieler(int pSpieler) {
        this.spielendecharactere= Erzaehler.spielendecharactere;
        for (int i = 0; i < spielendecharactere.length; i++) {
            if (spielendecharactere[i].getSpieler() == pSpieler) {
                return spielendecharactere[i];
            }
        }
        return spielendecharactere[spielendecharactere.length-1];
    }

    public void sterben(){
        Erzaehler.totespieler.add(this);
        System.out.println("spieler "+ spieler +". Du bist aus dem Dorf gescheucht worden." );
    }
}
















































