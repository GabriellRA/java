public class Editor{

    private String email;

    public Editor(){
        email = "reditor@newsagency.com";
    }

    public Editor(String email){
        if(verifyEmail(email))this.email = email;
    }
    
    public boolean verifyEmail(String email){
        if(email != null && email.contains("@") && email.contains(".com")){
            return true;
        }else{
            System.err.println("ERROR: Invalid email");
            this.email = "reditor@newsagency.com";
            return false;
        }
    }
    public void setEmail(String email){
        if(verifyEmail(email))this.email = email;
    }
    public String getEmail(){
        return email;
    }
}
