package projeto.ipoo.pkg1718;

import java.util.Random;


public class FillingStation{
    
    private final String name;
    private int id;
    private static int increment;
    //private boolean hasWater?? contem agua... mas nao é ilimitada??;
    private final Position position;
    private Vehicle[] filling, parked;
   //?dois arrays, um para os que estao abastecer, outro para a fila de espera, criar um metodo que organiza a fila de espera? (pq um array normal nao funciona como uma fila..)
    
    
    public FillingStation(String name, double lat, double lon){
        id = increment;
        increment++;
        Random r = new Random();
        if(checkName(name))this.name = name;
        else this.name = "Station " + increment;
        if(checkPos(lat, lon))position = new Position(lat,lon);
        else position = new Position(-9.5+(r.nextDouble()*(-6.2 + 9.5)),36.8+(r.nextDouble()*(42.2-36.8)));
        filling = new Vehicle[8];
    }
    
    private boolean checkName(String name){
        return !(name == null || name.equals(""));
    }
    private boolean checkPos(double lat, double lon){
        return lat > -9.5 && lat <-6.2 && lon > 36.8 && lon < 42.2;
    }

    //adicionar um carro a fila de espera
    public void addParked(Vehicle v){
        if(parked[0] == null) {
            int i = 0;
            while (i < parked.length){
                    parked[i] = parked[i + 1];
                    parked[i + 1] = null;
            i++;
                if(i == parked.length - 1){
                    break;
                }
            }
        }
        for(int i = 0; i < parked.length; i++){
            if(parked[i] == null){
                parked[i] = v;
                break;
            }
        }
        System.err.println("ERROR: Park Full");
    }
    public void addFilling(Vehicle v){
        for(int i = 0; i < filling.length; i++){
            if(filling[i] == null){
                filling[i] = removeParked();
                break;
            }
        }
    }
    //retirar um carro a fila de espera verificar espaços, posiçoes
    public Vehicle removeParked(){
        if(parked[0] == null) {
            int i = 0;
            while (i < parked.length){
                    parked[i] = parked[i + 1];
                    parked[i + 1] = null;
            i++;
                if(i == parked.length - 1){
                    break;
                }
            }
        }
        Vehicle v = parked[0];
        parked[0] = null;
        return v;

    }
    //adicionar agua ao tanque, verificar posição=abastecimento, capMax/500 = min para encher, usar no metodo fill do veiculo.
    public void fill(){
        
    }
    //SELETORES
    public String getName(){
        return name;
    }
    /*
    public boolean hasWater(){
        return hasWater;
    }
    */
    public Position getposition(){
        return position;
    }
    
}
