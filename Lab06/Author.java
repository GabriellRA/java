public class Author {

    private String name;
    private String email;

    public Author(){        
        name = "Redação";
        email = "redacao@newsagency.com";
    }
    public Author(String name, String email){
        if (name != null){
            this.name = name;
        }
        else{
            this.name = "";
        }
        this.email = validateEmail(email);
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    private String validateEmail(String email){
        if (email != null && email.contains("@"))
            return email;   
        
        return "redacao@newsagency.com";
    }
    public String toString(){
        return name + " - " + email;
    }
}