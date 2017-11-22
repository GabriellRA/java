public class Photo {

    private String fileName;
    private String caption;

    public Photo(String pictureName, String caption){
        if(pictureName != null){
            this.fileName = pictureName;
        }
        else{
            this.fileName = "";
        }
        if(caption != null) {
            this.caption =  caption;
        }
        else{
            this.caption = "";
        }
    }
    public String getImageFile(){
        return fileName;
    }
    public String getCaption(){
        return caption;
    }
    public String toString(){
        return "["+ fileName + "]: " + caption;  
    }
}