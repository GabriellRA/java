public class Property{
    private int reference, grossArea, patrimonialValue;
    private double price;
    private String propertyType, typology;
    private Date constructionDate;
    private Address address;
    private boolean state;
    
    public Property(int refer, String pType, String typol, Address addr){
        reference = refer;
        propertyType = pType;
        typology = typol;
        address = addr;
        constructionDate = new Date(6, 11, 2017);
        state = true;
    }
    public int getReference(){
        return reference;
    }
    public void setReference(int ref){
        if(ref < 0){
            reference = 0;
        }else{
            reference = ref;
        }
    }
    public int getGrossArea(){
        return grossArea;
    }
    public void setGrossArea(int gArea){
        if(gArea < 0){
            grossArea = 0;
        }else{
            grossArea = gArea;
        }
    }
    public int getPatrimonialValue(){
        return patrimonialValue;
    }
    public void setPatrimonialValue(int pValue){
        if(pValue < 0){
            patrimonialValue = 0;
        }else{
            patrimonialValue = pValue;
        }
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if(price < 0){
            price = 0;
        }else{
            this.price = price;
        }
    }
    public String getPropertyType(){
        return propertyType;
    }
    public void setPropertyType(String pType){
        propertyType = pType;
    }
    public String getTypology(){
        return typology;
    }
    public void setTypology(String typol){
        typology = typol;
    }
    public Date getConstructionDate(){
        return constructionDate;
    }
    public Address getAddress(){
        return address;
    }
    public String getState(){
        if(state){
            return "Novo";
        }else{
            return "Usado";
        }
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void decreasePrice(double percentage){
        price = price -((percentage * price)/100);
    }
    public double municipalTax(){
        if(getAddress().getLocal().equals("Lisboa") || getAddress().getLocal().equals("Porto")){
            return 0.005 * patrimonialValue;
        }else{
            return 0.003 * patrimonialValue;
        }
    }
    public double earthquakeInsuranceValue(double safeCapital){
        if(safeCapital < (1.6 * patrimonialValue)){
            return safeCapital * 0.0002;//???????????????
        }else{
            System.err.println("ERROR: Safe Capital Greater Than 160% of Patrimonial Value");
            return 0;
        }
    }
    public void showRealStateCharges(){
        System.out.println("\t***Encargos Imóvel***\nReferência:  " + reference + 
                            "\nTipologia:  " + typology + "\nÁrea Bruta:  " + grossArea +
                            " m2\nMorada:  " + address.getAddress() + "\nLocalidade:  " + address.getLocal() +
                            "\nData de Construção:  " + constructionDate.getDay() + "-" +  
                            constructionDate.getMonth()+ "-" +  constructionDate.getYear()+ "\nIMI:  " + 
                            municipalTax() + "\nSeguro contra Sismos:  " + (0.07 * patrimonialValue));
    }
    public int propertyAge(){
        return constructionDate.getYearsTillToday();
    }
    public void aa(int day, int month, int year){
        constructionDate = new Date(day, month, year);
    }
    
}