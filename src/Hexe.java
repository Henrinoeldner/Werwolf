import java.util.ArrayList;
import java.util.List;

public class Hexe extends Character {
    private boolean Htrank; // Gibt an ob die Hexe den Heilungstrank noch benutzten kann. Bei true kann sie den Trank noch benutzten bei false nicht
    private boolean Ttrank;// Gibt an ob die Hexe den Tötungstrank noch benutzten kann. Bei true kann sie den Trank noch benutzten bei false nicht
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character);
     * Bei der Hexe werden zusätzlich die Variablen für die Tränke befüllt
     */
    public Hexe(){
        Htrank=true;
        Ttrank=true;
        Leben=1;
        Classe="Hexe";
        Team=1;
        Reinfolge=11;
    }

    public void Feahikeit() {
        if (!Sabotirt && Leben > 0) {
            if (Htrank){
                System.out.println("Welchen der Folgenden Spieler möchtest du retten?");
                System.out.println("[0]Niemanden");
                List<Character> Opfer=new ArrayList<>();
                int zaehler=1;
                for (Character character : spielendecharactere) {
                    if (character.getLeben() < 1) {
                        System.out.println("[" + zaehler + "] Spieler" + character.getSpieler());
                        Opfer.add(character);
                        zaehler++;
                    }
                }
                int option=scanner.nextInt();
                if (option!=0) {
                    Opfer.get(scanner.nextInt() - 1).setLeben(1);
                }
            }
        } else //falls der Spieler sabortiert wurde und nimanden beschützen kann
        {
            Sabotirt = false;
            System.out.println("HAHA Wurdest Sabortiert");
        }
    }
}
