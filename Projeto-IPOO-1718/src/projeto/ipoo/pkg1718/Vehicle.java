package projeto.ipoo.pkg1718;

import java.util.Random;

public class Vehicle {

    private int id;
    private static int increment;
    private int currentCapacity;
    private int maxCapacity;
    //private FillingStation station;
    //private Barrack barrack;
    //private Fire fire;
    private FireMan[] firemen;
    private int currentFiremen;
    private Position position;

    public Vehicle(int maxCapacity, double lat, double lon) { //quantas mangueiras tem o veiculo? Ex quando estao 5 pessoas num carro num incendio, 1 fica na bomba de agua, dois ficam numa mangueira e o resto?
        id = increment;
        increment++;
        currentCapacity = 0;
        Random r = new Random();
        if (checkCapacity(maxCapacity)) {
            this.maxCapacity = maxCapacity;
        } else {
            this.currentCapacity = 1500;
        }
        firemen = new FireMan[8];
        if(checkPos(lat, lon))position = new Position(lat,lon);
        else position = new Position(-9.5+(r.nextDouble()*(-6.2 + 9.5)),36.8+(r.nextDouble()*(42.2-36.8)));
    }

    private boolean checkCapacity(int maximum) {
        return !(maximum < 1500 || maximum > 20000);
    }
    private boolean checkPos(double lat, double lon){
        return lat > -9.5 && lat <-6.2 && lon > 36.8 && lon < 42.2;
    }

    //mudar as coordenadas do veiculo,onde fica este metodo? aqui ou no fireman(usar por ex. fm1.moveVehicle(), ou v1.move())
    public void move(Position p) {
        if(p != null)position = p;
        else System.err.println("ERROR: Invalid Position");
    }

    //adicionar agua ao tanque, verificar posição=abastecimento, capMax/500 = min para encher, 
    public void fill(){
        currentCapacity = maxCapacity;
    }

    //retirar agua do tanque, verificar posição=incendio, usar agua retirada para retirar a area do fogo?, 1000/2=500m quadrados apagados por minuto
    public void unfill() {
        
    }
    
    //adicionar um fireman ao veiculo, verificar espaços, posiçoes
    public void addFireMan(FireMan f) {
            for (int i = 0; i < firemen.length; i++) {
                if(firemen[i] == null){
                    firemen[i] = f;
                    currentFiremen++;
                    break;
                }
            }
            
    }
    //retirar um fireman ao veiculo, verificar espaços, posiçoes
    public void removeFireMan(FireMan f) {
            for (int i = 0; i < firemen.length; i++) {
                if(firemen[i] == f){
                    firemen[i] = null;
                    currentFiremen--;
                    break;
                }
            }
            System.err.println("ERROR: FireMan Not In The Vehicle");
    }

    //SELETORES
    public int getName() {
        return id;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public Position getPosition() {
        return position;
    }
    public int getCurrentFiremen(){
        return currentFiremen;
    }
    public FireMan[] getFiremen(){
        return firemen;
    }
    public void showFiremenInVehicle(){
        for(int i = 0; i < 8; i++){
            System.out.println(firemen[i]);
        }
    }
}
