public class Dieb extends Character{
    public Dieb(){
        Leben=1;
        Classe="Dieb";
        Team=1;
        Reinfolge=0;
    }

    /**
     * Tauscht den zugewiesenen Spieler mit dem Character Objekt des gewählten spieler.
     */
    public void Feahikeit(){
        System.out.println("Von welchem spieler möchtest du die Rolle stehlen?");
        int gesuchterspieler =scanner.nextInt();
        Character bestohlen=findspieler(gesuchterspieler);
        System.out.println("Deine neue Rolle ist: "+bestohlen.getClasse());
        int speicher= bestohlen.getSpieler();
        bestohlen.setSpieler(spieler);
        this.spieler=speicher;
        Classe="Dorfbewohner";
        Reinfolge=15;
    }
}
