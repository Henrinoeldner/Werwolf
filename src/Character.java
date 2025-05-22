import java.util.Scanner;
public abstract class Character {
    protected Scanner scanner=new Scanner(System.in);
    protected int Leben; //Leben gibt die Anzahl der Leben wieder. Wenn die leben Null ereichen Stirbt der Chahrakter
    protected String Classe; //Gibt an welche klasse (Werwolf, hexe,...) an
    protected int Team; //Team gibt an, welches Team der Charackter ist (werwolf:0,Dorfbewohner:1,Liebende:2,Vampir:3;Weißerwerwolf:4)
    protected boolean Sabotirt;// wenn Sabotirt, dann kann feahikeit nicht benutzt werden
    protected int Reinfolge;// Reinfolge bestimmt, wann die karte dran ist (Bsp: erst 1 dann 3 und dann 4)
    protected int Stimmen; // Stimmen gibt an wie viele Leute bereits für diesen charakter gestimmt haben
    protected boolean Protectet; // wenn Protecte stimmt, dann kann dieser Character in der Nacht nicht sterben
    protected boolean Gebissen; // wenn alle gebissen wahr dann gewint der vampier zusätzlich muss team geander werden
    protected boolean Buegermeister;// wenn Buegermeister wahr ist, hat diese Karte zwei stimmen auser bei unentschieden. Dann nur 1
    protected Character Liebespatner;// merkt sich, wer der Liebespatner ist.
    protected Character Schlafwandlerin; //merkt sich, bei wem sich die Schlafwandlerin befindet
    protected int Stearke;//Gibt die steake der Karte an
    // sabotirt setzt die variable Sabotirt auf den mitgegebnenen @Parameter
    protected boolean Angeklagt;
    protected int spieler;
    protected Character[] spielendecharactere=Erzaehler.spielendecharactere;

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
    } // Wird aufgerufen wenn der saborteur jemanden
    // sabortiert hat und setzt die Variable für den Spieler auf true

    /**
     * gibt den Wert des Lebens zurück
     * @return int Leben
     */
    public int getLeben() {
        return Leben;
    }

    public void setLeben(int pLeben){
        Leben=pLeben;
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
        //Abfrage wer angeklagt wird
        System.out.println("Spieler "+spieler+", welchen Spieler möchtest du anklagen (0 wenn du niemanden anklagen möchtest)? ");
        int gesuchterspieler =scanner.nextInt();
        // Der spieler wird gesucht
        // (bei 0 wurde niemand angeklegt dementsprechend wird keiner gesucht)
        if (gesuchterspieler!=0) {
            //Der spieler wird als angeklagt zurückgegeben
            return findspieler(gesuchterspieler);
        }else{
            return null;
        }

    }

    /**
     * Lästen den Benutzter aussuchen, wen der Angeklagten er auswerfen möchte.
     * @return denn ausgewählten spieler.
     */
    public int abstimmen(){
        //Abfrage für wen man glaubt von den Spielern der schuldige ist.
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
        //die liste der character wird durchgegangen
        for (int i = 0; i < spielendecharactere.length; i++) {
            // abfrage ob der gesuchte spieler gefunden wurde
            if (spielendecharactere[i].getSpieler() == pSpieler) {
                //rückgabe des gesuchten spieler
                return spielendecharactere[i];
            }
        }
        // falls ein nicht exesiztenter spieler
        // angegeben wird, wird der Letzte spiler zurückgegeben damit das Programm nicht abstürzt
        return spielendecharactere[spielendecharactere.length-1];
    }


    /**entfernt das Element aus dem Array spielendecharactere und fügt es der Liste der Totenspieler hinzu.
     * Sollte das Objekt verliebt sein so wird auch der Liebespartner herausgeworfen .
     * Selbes gilt fuer die Schlafwandlerin
     */
    public void sterben(){
        Leben=0;
        Erzaehler.totespieler.add(this);

        //Unterscheidet, ob Tag oder Nacht ist und gibt eine endsprechende Todesnachricht aus
        if(Erzaehler.tagnacht) {
            System.out.println("spieler " + spieler + ". Du bist aus dem Dorf gescheucht worden.");
        }else{
            System.out.println("spieler " + spieler + ". Du wurdest in Nacht ermordet.");
        }
        //Liebespater stribt, wenn er einen hat
        if (Liebespatner!=null){
            Liebespatner.setLiebespatner(null);
            Liebespatner.sterben();
        }
        //Lässt die Schlafwandlerin sterben wenn sie bei dem Opfer gestorben ist.
        if (Schlafwandlerin!=null){
            Schlafwandlerin.sterben();
        }
        for (int i = 0; i < spielendecharactere.length; i++) {
            //geht das Array der Spielenden Charactere durch, bis der zu sterbende Spieler gefunden wurde
            if (spielendecharactere[i] == this) {
                //Rueckt alle Objekte nach dem zu sterbenden Spieler ein Platzt nach vorne
                for (int b = i; b < spielendecharactere.length - 1; b++) {
                    spielendecharactere[b] = spielendecharactere[b + 1];
                }
                //uebertraegt alle Objekte aus Spielende Charaktere in ein temporaeres Array damit Spielendecharctere um ein Platz in der Laenge verringert werden kann
                Character[] speicher = new Character[spielendecharactere.length - 1];
                for (int c = 0; c < spielendecharactere.length - 1; c++) {
                    speicher[c] = spielendecharactere[c];
                }
                //Uebertraegt die Objekte aus dem temporaerem array zurueck in spielendecharactere
                Erzaehler.spielendecharactere=new Character[speicher.length];
                Erzaehler.spielendecharactere = speicher;
            }
        }
    }
}
















































