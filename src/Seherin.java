import java.util.Objects;

public class Seherin extends Character{
    public Seherin(){
        Leben=1;
        Classe="Seherin";
        Team=1;
        Reinfolge=5;
    }

    /**
     * Gibt die Rolle des vom Benutzter gewählten Spielers zurück
     * (Außer der Schattenwerwolf wird betrachtet, dann wird Dorfbewohner ausgegeben)
     */
    public void Feahikeit(){
        if (!Sabotirt){
            System.out.println("Von welchem Spieler möchtest du die Rolle sehen?");
            int gesuchterspieler = scanner.nextInt();
            String erblickteklasse = findspieler(gesuchterspieler).getClasse();
            if (erblickteklasse.equals("Schattenwerwolf")){
                System.out.println("Der erblickte Spieler ist Dorfbewohner");
            }else{
                System.out.println("Der erblickte Spieler ist "+erblickteklasse);
            }
        }else{
            Sabotirt=false;
            System.out.println("HAHA");
        }

    }
}
