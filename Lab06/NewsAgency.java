public class NewsAgency{
    private News news[];
    private int m;
    public NewsAgency(){
        news = new News[200];
    }
    private void addNews(News n){
        if(n != null){
            for(int i = 0; i < 200; i++){
                if(news[i] == null){
                    news[i] = n;
                    m++;
                    break;
                }
            }
        }else{
            System.err.println("ERROR: Invalid News");
        }
    }
    public void showNewsToReview(){
        for(int i = 0; i < 200; i++){
            if(news[i] != null){
                if(news[i].getDateOfPublication() == null){
                    System.out.println(news[i]);
                }
            }
        }
    }
    public void showPublishedNews(){
        for(int i = 0; i < 200; i++){
            if(news[i] != null){
                if(news[i].getDateOfPublication() != null){
                    System.out.println(news[i]);
                }
            }
        }
    }
    public void showNewsByAuthor(String author){
        System.out.println("Author: " + author + "\n");
        for(int i = 0; i < 200; i++){
            if(news[i] == null){
                if(news[i].getAuthorName() == author){
                    System.out.println(news[i]);
                }
            }
        }
    }
}