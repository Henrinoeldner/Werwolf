public class Totengreaber extends Character {
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Totengreaber(){
        Leben=1;
        Classe="Totengreaber";
        Team=0;
        Reinfolge=13;
    }
    public void Feahikeit(){
        if (!Sabotirt&&Leben>0) {
        System.out.println("Von welchen verstorbenen möchtest du die Rolle wissen?");
        System.out.println("[0]Niemand");
        for(int i=0;i<Erzaehler.totespieler.size();i++){
            System.out.println("["+i+1+"] Spieler "+Erzaehler.totespieler.get(i) );
        }
        int option=scanner.nextInt();
        if (option>0) {
            System.out.println("Dieser Spieler war " + Erzaehler.totespieler.get(option).getClasse());
        }
        }else{
            System.out.println("Du wurdest sabotiert und kannst deshalb deine Fähigkeit nicht benutzten");
            Sabotirt=false;
        }
    }
}
