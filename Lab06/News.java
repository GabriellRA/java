import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class News{
    private String title,text;
    private Author author;
    private Photo photos[];
    private Review reviews[];
    private int numberOfPhotos, numberOfReviews;
    private LocalDateTime dateOfPublication;

    /*public News(){
    title = "";
    text = "";
    author = new Author();
    photos = new Photo[20];
    reviews = new Review[3];
    numberOfPhotos = 0;
    numberOfReviews = 0;
    dateOfPublication = null;
    }*/

    public News(){
        System.out.print('\u000C');
        title = "Lisboa treme";
        text = "Um terramoto de intensidade 4.5 foi sentido em Lisboa.";
        author = new Author();
        photos = new Photo[20];
        reviews = new Review[3];
        numberOfPhotos = 0;
        numberOfReviews = 0;
        Photo photo;
        addPhoto(photo = new Photo("lisboa.jpg"," Lisboa a capital Portuguesa"));
        Review r1,r2;
        addReview(r1 = new Review());
        addReview(r2 = new Review());
        System.out.println(display());
        displayComReviews();
        publish();
    }
    public News(String title, String text, Author author){
        this.title = validateString(title);
        this.text = validateString(text);
        if(author != null){
            this.author = author;
        }else{
            author = new Author();
        }
    }
    private String validateString(String string) {
        if(string != null) {
            return string;
        }
        return "";
    }
    public String getTitle(){
        return title;
    }
    public String getText(){
        return text;
    }
    public String getAuthorName(){
        return author.getName();
    }
    public String getAuthorEmail(){
        return author.getEmail();
    }
    public LocalDateTime getDateOfPublication(){
        return dateOfPublication;
    }
    public void addPhoto(Photo photo){
        if(photo != null){
            for(int i = 0; i < 20; i++){
                if(photos[i] == null){
                    photos[i] = photo;
                    numberOfPhotos++;
                    break;
                }
            }
        }else{
            System.err.println("ERROR: Invalid Photo");
        }
    }
    public String display(){
        String str = "" + title + "\n" + author.toString() + "\n" + text + "\n";
        for(int i = 0; i < 20; i++){
            if(photos[i] != null){
                str += "[" + photos[i].getImageFile() + "]: " + photos[i].getCaption() + "\n";
            }
        }
        if(dateOfPublication == null){
            str += "Not Published\n";
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss");
            String formatDateTime = dateOfPublication.format(formatter);
            str += formatDateTime;
        }
        System.out.println("Skrrat");
        return str;
    }
    public void addReview(Review r){
        if(r != null){
            for(int i = 0; i < 3; i++){
                if(reviews[i] == null){
                    reviews[i] = r;
                    numberOfReviews++;
                    break;
                }
            }
        }else{
            System.err.println("ERROR: Invalid Review");
        }
    }
    public void displayComReviews(){//ta a printar muita coisa pq tenho um show() no construtor da review
        System.out.println("skidi-kat-kat");
        System.out.println(display());
        System.out.println("The ting goes skrrrahh");
        for(int i = 2; i >= 0; i--){
            if(reviews[i] != null){
                reviews[i].show();
            }
        }
        System.out.println("2 + 2 = 4 - 1 = 3 quick maths");
    }
    public void publish(){
        dateOfPublication = dateOfPublication.now();
    }
    public int findReviewByEditor(String email){
        for(int i = 0; i < 3; i++){
            if(reviews[i].getEditor().getEmail() == email){
                return i;
            }
        }
        return -1;
    }
    public void addComment(String email, String comment){
        if(comment != null){
            for(int i = 0; i < 10; i++){
                if(findReviewByEditor(email) == -1){
                    Editor e = new Editor(email);
                    reviews[findReviewByEditor(email)+1].addComment(comment);
                    break;
                }
            }
        }else{
            System.err.println("ERROR: Invalid Comment");
        }
    }
}