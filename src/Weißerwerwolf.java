public class Weißerwerwolf extends Character {
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Weißerwerwolf(){
        Leben=1;
        Classe="Weißerwerwolf";
        Team=4;
        Reinfolge=9;

    }

    public void Feahikeit(){
        System.out.println("Wähle den Spieler den gerne verspeisen möchtest.");
        int gesuchterspieler = scanner.nextInt();
        Character speicher= findspieler(gesuchterspieler);
        Werwolf.werwolfopfer.add(speicher);
        speicher.changeStimmen();

    }
}
