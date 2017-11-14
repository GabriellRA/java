public class Menu{
    InputReader reader;
    
    public void display(){
        System.out.println(" Calculadora Básica ");
        System.out.println("1 - Adicionar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("0 - Sair");
        System.out.println("Escolha a sua opção: ");
    }
    public int readOption(){
        reader = new InputReader();
        int i = reader.getIntegerNumber("Opção");
        if(i > 4 || i < 0){
            System.out.println("Escolha uma opção correta (0 a 4)");
            readOption();
        }
        return i;
    }
}