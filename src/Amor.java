public class Amor extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Amor(){
        Leben=1;
        Classe="Amor";
        Team=1;
        Reinfolge=3;
    }

    /**
     * Lässt dich zwei Spieler aussuchen dessen zugeordneten Character Objekte dann das jeweils ander als variable speichern (mit Methode setLiebespatner.)
     * Sollten die ausgewählten spieler unterschiedlichen teams angehören, so wird Ihr Team auf team 2 (Liebende) gesetzt (it der Methode setTeam).
     * Zum Schluss wird die Reinfolge auf 15 gesetzt, damit der Armor nicht erneut erwacht.
     */
    public void Feahikeit(){
        if (!Sabotirt) {
            System.out.println("Welchen spieler möchtest du verlieben?");
            int gesuchterspieler = scanner.nextInt();
            Character liebeEins = findspieler(gesuchterspieler);
            System.out.println("mit welchen Spieler möchtest du ihn verlieben?");
            gesuchterspieler = scanner.nextInt();
            Character liebeZwei = findspieler(gesuchterspieler);
            liebeEins.setLiebespatner(liebeZwei);
            liebeZwei.setLiebespatner(liebeEins);
            if (liebeEins.getTeam() != liebeZwei.getTeam()) {
                liebeEins.setTeam(2);
                liebeZwei.setTeam(2);
            }
        }else {
            System.out.println("HAHA");
            Sabotirt=false;
        }
        Reinfolge=15;
    }
}
