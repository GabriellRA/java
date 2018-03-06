package lab00;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class WordGenerator {
    private ArrayList<String> words;
    
    public WordGenerator(){
        words = new ArrayList<>();
        fillArrayList();
    }
    
    private void fillArrayList(){
        words.add("boolean");
        words.add("break");
        words.add("byte");
        words.add("case");
        words.add("char");
        words.add("class");
        words.add("continue");
        words.add("do");
        words.add("double");
        words.add("else");
        words.add("if");
        words.add("enum");
        words.add("for");
        words.add("int");
        words.add("import");
    }
    public String generateWorld(){
        Random r = new Random();
        int n = r.nextInt(words.size());//gera um numero inteiro de 0 até words.size()
        return words.get(n);
    }
    public boolean addWord(String w){
        return words.add(w);
    }
    
}
