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

    public void Feahikeit(){

    }
}
