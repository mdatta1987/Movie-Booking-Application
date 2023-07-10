import java.util.Random;
public class Monopoly {
    private int currentPosition;
    public Monopoly(int startingPosition) {
        currentPosition = startingPosition;
    }
    public int throwDie(){
        Random rand = new Random();

        return rand.nextInt(5)+1;
    }
    public int advance(){
        int die1 = throwDie();
        int die2 = throwDie();
        currentPosition += die1+ die2;

        if(die1 == die2){
            advance();
        }

        return currentPosition;
    }
}
