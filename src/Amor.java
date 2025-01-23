public class Amor extends Character{
    public Amor(){
        Leben=1;
        Classe="Amor";
        Team=1;
        Reinfolge=3;
    }
    public void Feahikeit(){
        System.out.println("Welchen spieler möchtest du verlieben?");
        int gesuchterspieler =scanner.nextInt();
        Character liebeEins=findspieler(gesuchterspieler);
        System.out.println("mit welchen Spieler möchtest du ihn verlieben?");
        gesuchterspieler=scanner.nextInt();
        Character liebeZwei=findspieler(gesuchterspieler);
        liebeEins.setLiebespatner(liebeZwei);
        liebeZwei.setLiebespatner(liebeEins);
        if (liebeEins.getTeam()!=liebeZwei.getTeam()){
            liebeEins.setTeam(2);
            liebeZwei.setTeam(2);
        }
        Reinfolge=15;
    }
}
