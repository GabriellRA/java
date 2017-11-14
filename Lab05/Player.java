public class Player{
    private String name;
    private int score, wins;
    public Player(String playerName){
        if(validateName(playerName)) name = playerName;
    }
    public boolean validateScore(int newScore){
        if(newScore > 0){
            return true;
        }else{
            System.err.println("ERROR: Invalid Score");
            return false;
        }
    }
    public boolean validateName(String name){
        if(name != null){
            return true;
        }else{
            System.err.println("ERROR: Invalid Name");
            return false;
        }
    }
    public void setName(String playerName){
        if(validateName(playerName)) name = playerName;
    }
    public String getName(){
        return name;
    }
    public void setScore(int newScore){
        if(validateScore(newScore)) score = newScore;
    }
    public int getScore(){
        return score;
    }
    public void incrementWin(){
        wins++;
    }
    public int getWins(){
        return wins;
    }
    public void addScore(int addScore){
        if(validateScore(addScore)) score += addScore;
    }
    public void reset(){
        score = 0;
    }
}