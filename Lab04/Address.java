public class Address{
    private String address, locality, postalCode;
    public Address(String addr, String code, String local){
        if(addr == null){
            address = "desconhecido";
        }else{
            address = addr;
        }if(code == null){
            postalCode = "0000-000";
        }else{
            locality = local;
        }if(local == null){
            locality = "xxxxxxxx";
        }else{
            postalCode = code;
        }
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String addr){
        if(addr == null){
            address = "desconhecido";
        }else{
            address = addr;
        }
    }
    public String getLocal(){
        return locality;
    }
    public void setLocal(String local){
        if(local == null){
            locality = "xxxxxxxx";
        }else{
            postalCode = local;
        }
    }
    public String getCode(){
        return postalCode;
    }
    public void setCode(String code){
        if(code == null){
            postalCode = "0000-000";
        }else{
            locality = code;
        }
    }
}