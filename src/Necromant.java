public class Necromant extends Character{
    /**
     * Im Konstruktor wird die Variablen Leben, Classe, Team und rheinfolge mit Inhalt
     * befüllt.(genaue Erklärung der Variable siehe Classe Character)
     */
    public Necromant(){
        Leben=1;
        Classe="Necromant";
        Team=1;
        Reinfolge=13;
    }

    /**
     * Der Spieler kann sich ein Charakter aus der Totenlist aussuchen der daraufhin wieder dem Spiel hinzugefügt wird
     */
    public void Feahikeit(){
        if (!Sabotirt&&Leben>0) {
            //Listet alle Spieler auf die in dem aktuellen Spiel bisher gestorben sind
            System.out.println("Welchen der Toten möchtest du wiederbeleben? Du kannst dies nur einmal pro Spiel tu ");
            for(int i=0;i<Erzaehler.totespieler.size();i++){
                System.out.println("["+i+1+"] Spieler "+Erzaehler.totespieler.get(i) );
            }
            //Der wiederbelebte Spieler wird wieder dem Array der Spielendencharakteren hinzugefügt
            // und die Anzahl seiner Leben wird auf eins gesetzt
            Character wiederbelbterSpiler=Erzaehler.totespieler.get(scanner.nextInt());
            wiederbelbterSpiler.setLeben(1);
            Erzaehler.totespieler.remove(wiederbelbterSpiler);
            Character[] temporeresarray=new Character[Erzaehler.spielendecharactere.length];

            for (int i=0;i<Erzaehler.spielendecharactere.length;i++){
                temporeresarray[i]=spielendecharactere[i];
            }
            temporeresarray[Erzaehler.spielendecharactere.length+1]=wiederbelbterSpiler;
            System.out.println("Spieler "+wiederbelbterSpiler.getSpieler()+"wurde erfolgreich wiederbelebt");
        }else{
            System.out.println("Du wurdest sabotiert und kannst deshalb deine Fähigkeit nicht benutzten");
            Sabotirt=false;
        }
    }
}
