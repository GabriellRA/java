package lab00;

/**
 *
 * @author Gabriel
 */
public class FullGame {
    private WordGuessingGame game;
    private InputReader reader;
    char s;
    
    public FullGame(){
        game = new WordGuessingGame();
        reader = new InputReader();
    }
    
    public void play(){
        s = 'S';
        do{
            game.play();
            game.reset();
            do{
                s = reader.getChar("Continuar? (S/N)");
            }while(s != 's' && s != 'S' && s != 'n' && s != 'N');
        }while(s == 'S' | s == 's');
    }
}
