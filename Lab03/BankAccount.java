public class BankAccount{
    private String name;
    private int number;
    private char type;
    private double balance;
    private boolean isActive;
    
    public BankAccount(String nam, int numb){
        name = nam;
        number = numb;
        type = 'I';
        balance = 0;
        isActive = false;
    }
    public String yesNo(boolean b){
        if(b == true){
            return "Sim";
        }else{
            return "Não";
        }
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public char getType(){
        return type;
    }
    public void setType(char typ){
        if(typ == 'I' || typ == 'S' || typ == 'M' || typ == 'J'){
            type = typ;
        }else{
            System.out.println("ERROR: Invalid Type (I, S, M OR J)");
        }
    }
    public double getBalance(){
        return balance;
    }
    public boolean getIsActive(){
        return isActive;
    }
    public void open(double balance){
        if(isActive == false){
            if(balance >= 100){
                this.balance = balance;
                isActive = true;
            }else{
                System.out.println("ERROR: Balance Lower Than 100€");
            }
        }else{
            System.out.println("ERROR: Account Already Active");
        }
    }
    public void desposit(double add){
        if(isActive == true){
            if(add > 0){
                balance += add;
            }else{
                System.out.println("ERROR: Invalid Amount");
            }
        }else{
            System.out.println("ERROR: Account Not Active");
        }
    }
    public void withdraw(double take){
        if(isActive == true){
                if(take > 0){
                    if(balance > take){
                        balance -= take;
                    }else{
                        System.out.println("ERROR: Not Enough Balance (Balance: " + balance +")");
                    }
            }else{
                System.out.println("ERROR: Invalid Amount");
            }
        }else{
            System.out.println("ERROR: Account Not Active");
        }
    }
    public void showInfo(){
        System.out.println("\t***Dados da Conta***\nNome da Conta: "+ getName() + "\nNúmero da Conta: " + getNumber() + "\nTipo de Conta: " + getType() + "\nSaldo: " + getBalance() + "\nConta Ativa? " + yesNo(getIsActive()));
    }
    public double annualIntrest(){
        if(getBalance() < 2000){
            return (balance*0.9)/100;
        }if(getBalance() >= 2000 && getBalance() <= 5000){
            return balance/100;
        }if(getBalance() > 5000 && getBalance() <= 10000){
            return (balance*1.5)/100;
        }else{
            return (balance*2)/100;
        }
    }
    public void creditAnnualIntrest(){
        balance += annualIntrest();
    }
    public double monthInterest(){
        return (Math.pow((1 + juros()), (1/12))) - 1; //????????
    } 
    public double juros(){
        if(getBalance() < 2000){
            return 0.9;
        }if(getBalance() >= 2000 && getBalance() <= 5000){
            return 1;
        }if(getBalance() > 5000 && getBalance() <= 10000){
            return 1.5;
        }else{
            return 2;
        }
    }
}