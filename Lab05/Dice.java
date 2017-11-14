import java.util.Random;
public class Dice{
    final int faces;
    public Dice(){
        faces = 6;
    }
    public int roll(){
        Random randomNumber = new Random();
        int randomInt= 0;
        return randomInt = randomNumber.nextInt(faces) + 1;
    }
    public int getFaces(){
        return faces;
    }
}