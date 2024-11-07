//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Character {
    public int Leben=1; //Leben gibt die Anzahl der Leben wieder. Wenn die leben Null ereichen Stirbt der Chahrakter
    public String Classe; //Gibt an welche klasse (Werwolf, hexe,...) an
    public int Team; //Team gibt an, welches Team der Charackter ist (werwolf:0,Dorfbewohner:1,Liebende:2,Nar:3,Hexenjeager:4,Vampir:5)
    public boolean Sabotirt;// wenn Sabotirt, dann kann feahikeit nicht benutzt werden
    public int Reinfolge;// Reinfolge bestimmt, wann die karte dran ist (Bsp: erst 1 dann 3 und dann 4)
    public int Stimmen; // Stimmen gibt an wie viele Leute bereits für diesen charakter geatimmt haben
    public boolean Protectet; // wenn Protecte stimmt, dann kann dieser Character in der Nacht nicht sterben
    public boolean Gebissen; // wenn alle gebissen wahr dann gewint der vampier zusätzlich muss team geander werden
    public boolean Buegermeister;// wenn Buegermeister wahr ist, hat diese Karte zwei stimmen auser bei unentschieden. Dann nur 1
    public String Liebespatner;// merkt sich, wer der Liebespatner ist.
    public String Schlafwandlerin; //merkt sich, bei wem sich die Schlafwandlerin befindet
    public int Stearke;//Gibt die steake der Karte an

    // sabotirt setzt die variable Sabotirt auf den mitgegebnenen @Parameter
    public void sabotirt(boolean pIstSabotirt){
     Sabotirt=pIstSabotirt;
    }

    //getLeben gibt die Variable Leben zurueck
    public int getLeben(){
        return Leben;
    }
    public void changeleben(){
        Leben-=1;
    }


}