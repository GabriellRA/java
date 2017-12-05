package projeto.ipoo.pkg1718;


public class FireMan {
    
    private int id, workingHours;
    private static int increment;
    private String name;
    private double energy;//100% = 18H?
    private boolean drivingAllowed, working, resting;
    Vehicle vehicle;
    //private Fire fire;
    
    public FireMan(String name){
        id = increment;
        increment++;
        energy = 100;//100?100%?
        drivingAllowed = false;//carta de condução? ou se esta noutro veiculo?
        if(checkName(name))this.name = name;
        else this.name = "Fireman " + increment;
        resting = false;
        working = false;
        workingHours = 0;
    }
    private boolean checkName(String name){
        return !(name == null || name.equals(""));
    }
    //mudar as coordenadas no veiculo, quando o condutor poder conduzir, quando existirem 3 bombeiros no carro,
    public void driveVehicle(Position p){
        if(drivingAllowed){
            if(vehicle.getCurrentFiremen() >= 3){
                vehicle.move(p);
            }else{
                System.err.println("ERROR: Not Enough FireMen In The Vehicle");
            }
        }else{
            System.err.println("ERROR: FireMan Not Allowed To Drive");
        }
    }
    
    /*
    //retirar agua do veiculo, se tem agua, se esta no veiculo?, verificar posição?, verificar se tem energia suficiente para voltar ao quartel?
    public void useHose(){
        
    }
    */
    
    //retiar energia do bombeiro, quanta energia usa cada ação(viajar, apagar fogos)
    public void useEnergy(){
        if(working){
            energy -= 2;
            workingHours++;
        }else{
            energy -= 1;
        }
    }
    //adicionar energia consoante as horas descansadas, verificar posição, 
    public void rest(int hours){
        if(resting){
            System.out.println("FireMan Already Resting");
        }else{
            if(workingHours >= 18 && hours >= 6 || workingHours < 18 && hours > 0){
                for (int i = 0; i < hours; i++){
                    if (energy < 100) {
                        energy += 100 / 18;
                        if (energy > 100){
                            energy = 100;
                        }
                    }else{
                        workingHours = 0;
                        System.out.println("Energy Full");
                    }
                }
            }else{
                System.err.println("ERROR: Not Enough Hours To Rest");
            }
        }
    }
    
    /*
    public void getInTheVehicle(){
        
    }
    
    public void getOffTheVehicle(){
        
    }
    */
    
    //SELETORES
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getEnergy(){
        return energy;
    }
    public boolean isdrivingAllowed(){
        return drivingAllowed;
    }
}