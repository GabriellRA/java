package lab00;

/**
 *
 * @author Gabriel
 */
public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    private WordGenerator generator;
    private String lUsed = "";
    private String hiddenAux;
    
    public WordGuessingGame(){
        reader = new InputReader();
        generator = new WordGenerator();
    }
    public String getHiddenWord(){
        return hiddenWord;
    }
    public String getGuessedWord(){
        return guessedWord;
    }
    public int getNumberOfTries(){
        return numberOfTries;
    }
    private void showGuessedWord(){
        System.out.println(getGuessedWord());
    }
    public void play(){
        hiddenWord = generator.generateWorld();
        hiddenAux = hiddenWord;//usada para verificar palavras que contêm mais de uma mesma letra
        initializeGuessedWord();
        showWelcome();
        do{
            showGuessedWord();
            char l = reader.getChar("Letra?");
            guess(l);
            numberOfTries++;
        }while(guessedWord.contains("_"));//enquanto a palavra a descobrir conter _ continua
        showGuessedWord();
        showResults();
       
    }
    private void showWelcome(){
        System.out.println("Boas");
    }
    private void guess(char l){
        if(lUsed.indexOf(l) < 0){//se a letra l ainda nao foi utilizada
            if(hiddenWord.indexOf(l) >= 0){//se a letra l está na palavra a descobrir
                char[] word = guessedWord.toCharArray();//passa a palavra que ja descobrimos para um array de char, para a modificarmos
                do{
                    word[hiddenAux.indexOf(l)] = l;//muda a letra na posição onde se encontra l da hiddenWord para l na guessedWord
                    guessedWord = String.valueOf(word);//passa para string
                    hiddenAux = hiddenAux.replaceFirst(String.valueOf(l), "_");//remove a letra descoberta da hiddenWord auxiliar, para o caso de existir duas letra iguais
                }while(hiddenAux.contains(String.valueOf(l)));//enquanto conter a letra escolhida pelo utilizador
            }
            lUsed += l;//adiciona a letra usada a uma string, para nao poder ser usada de novo
        }else{
            System.out.println("Já usou essa letra!");
        }
        
    }
    private void showResults(){
        System.out.println("Tentativas: " + numberOfTries);
    }
    private void initializeGuessedWord(){
        int n = hiddenWord.length();
        guessedWord = "";
        for(int i = 0; i < n; i++){//adiciona a guessedWord n "_"
            guessedWord += "_";
        }
    }
    public void reset(){
        hiddenWord = "";
        hiddenAux = "";
        guessedWord = "";
        lUsed = "";
        numberOfTries = 0;
    }
}
