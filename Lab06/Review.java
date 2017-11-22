import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Review{
    private LocalDateTime date;
    private String comments[];
    private int numberOfComments;
    private Editor editor;

    /*public Review(){
        date = date.now();
        comments = new String[10];
        numberOfComments = 0;
        editor = new Editor();
    }*/
    public Review(){
        date = date.now();
        comments = new String[10];
        numberOfComments = 0;
        editor = new Editor();
        addComment("aaa");
        addComment("bbb");
        show();
    }
    public Editor getEditor(){
        return editor;
    }
    public void addComment(String comment){
        if(comment != null){
            for(int i = 0; i < 10; i++){
                if(comments[i] == null){
                    comments[i] = comment;
                    numberOfComments++;
                    break;
                }
            }
        }else{
            System.err.println("ERROR: Invalid Comment");
        }
    }
    public void show(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss");
        String formatDateTime = date.format(formatter);
        System.out.println("Data: " + formatDateTime);
        int o = 1;
        for(int i = 0; i < 10; i++){
            if(comments[i] != null){
                System.out.println(o + "- " + comments[i]);
                o++;
            }
        }
    }
}