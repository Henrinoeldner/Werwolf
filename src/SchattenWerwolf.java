import java.util.ArrayList;
import java.util.List;

public class SchattenWerwolf extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public static List<Character> werwolfopfer=new ArrayList<>();
    public SchattenWerwolf(){

        Leben=1;
        Classe="SchattenWerwolf";
        Team=0;
        Reinfolge=9;
    }
    public void Feahikeit(){
        System.out.println("Wähle den Spieler den gerne verspeisen möchtest.");
        int gesuchterspieler = scanner.nextInt();
        Character speicher= findspieler(gesuchterspieler);
        werwolfopfer.add(speicher);
        speicher.changeStimmen();
    }
}
