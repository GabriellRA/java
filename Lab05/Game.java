import java.util.Random;
public class Game{
    private Player p1, p2;
    private Dice d1;
    private int pointsToWin;

    public Game(String p1Name, String p2Name, int pointsToWin){//nao esta como se pede (melhorar?? mudar??)
        d1 = new Dice();
        if(pointsToWin >= d1.getFaces() && pointsToWin <= 50){
            p1 = new Player(p1Name);
            p2 = new Player(p2Name);
            this.pointsToWin = pointsToWin;
        }else{
            Random randomNumber = new Random();
            int range = 50 - 5;
            int randomInt = randomNumber.nextInt(range) + 6;
            p1 = new Player(p1Name);
            p2 = new Player(p2Name);
            this.pointsToWin = randomInt;
        }
    }
    public Game(){
        d1 = new Dice();
        p1 = new Player("a");
        p2 = new Player("b");
        pointsToWin = 50;
        play();
    }
    public void play(){
        while(p1.getScore() < pointsToWin && p2.getScore() < pointsToWin){
            p1.addScore(d1.roll());
            System.out.println("Player 1 Score: " + p1.getScore());
            p2.addScore(d1.roll());
            System.out.println("Player 2 Score: " + p2.getScore());
        }
        if(p1.getScore() < p2.getScore()){
            p2.incrementWin();
            System.out.println("Player 2 Won With " + p2.getScore());
        }else if(p2.getScore() < p1.getScore()){
            p1.incrementWin();
            System.out.println("Player 1 Won With " + p1.getScore());
        }else if(p2.getScore() == p1.getScore()){
            p1.incrementWin();
            p2.incrementWin();
            System.out.println("Draw. Both Players Win With " + p1.getScore());
        }
    }
    public void reset(){
        p1.setScore(0);
        p2.setScore(0);
    }
}