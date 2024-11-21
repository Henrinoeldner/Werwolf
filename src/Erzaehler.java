import java.util.Random;

public class Erzaehler {
     public Character[] spielendecharactere = new Character[5];
     public Character[] moeglichecharacters=
     public void test(){
     for(int i=0;i<spielendecharactere.length;i++){
         spielendecharactere[i]=moeglichecharacters[(int)(Math.random()* moeglichecharacters.length)];

     }

     }

}
