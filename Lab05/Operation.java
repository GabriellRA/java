public class Operation{  
    int first,second;

    public Operation(){

    }
    public void setFirst(int first){
        this.first = first;
    }
    public int getFirst(){
        return first;
    }
    public void setSecond(int second){
        this.second = second;
    }
    public int getSecond(){
        return second;
    }
    public int add(){
        return first + second;
    }
    public int subtract(){
        return first - second;
    }
    public int divide(){
        return first / second;
    }
    public int multiply(){
        return first * second;
    }
}   