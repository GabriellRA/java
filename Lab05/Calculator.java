public class Calculator{
    Menu mn;
    Operation op;
    InputReader reader;
    public void readOperators(){
        int x, y;
        reader = new InputReader();
        op = new Operation();
        x = reader.getIntegerNumber("Primeiro número: ");
        y = reader.getIntegerNumber("Segundo número: ");
        op.setFirst(x);
        op.setSecond(y);
    }

    public void start(){
        mn = new Menu();
        mn.display();
        int option = mn.readOption();
        if(option != 0){
            System.out.println(option);
            readOperators();
            if(option == 1){
                System.out.println("Chosen Add: ");
                op.add();
                System.out.println(op.getFirst() +" + "+ op.getSecond() +" = "+ op.add());
                start();
            }else if(option == 2){
                System.out.println("Chosen Sub: ");
                op.subtract();
                System.out.println(op.getFirst() +" - "+ op.getSecond() +" = "+ op.subtract());
                start();
            }else if(option == 3){
                System.out.println("Chosen Divide: ");
                op.divide();
                System.out.println(op.getFirst() +" / "+ op.getSecond() +" = "+ op.divide());
                start();
            }else if(option == 4){
                System.out.println("Chosen Multiply: ");
                op.multiply();
                System.out.println(op.getFirst() +" * "+ op.getSecond() +" = "+ op.multiply());
                start();
            }
        }else{
            System.out.println("Exit");
        }
    }
}