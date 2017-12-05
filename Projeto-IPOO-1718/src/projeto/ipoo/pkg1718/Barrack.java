package projeto.ipoo.pkg1718;

import java.util.Random;

public class Barrack {

    private Vehicle[] vehicles;
    private FireMan[] firemen;
    private String name;
    private final Position position;
    private int currentVehicles;
    private int currentFiremen;

    public Barrack(double lon, double lat) {
        Random r = new Random();
        if(checkPos(lat, lon))position = new Position(lat,lon);
        else position = new Position(-9.5+(r.nextDouble()*(-6.2 + 9.5)),36.8+(r.nextDouble()*(42.2-36.8)));
        vehicles = new Vehicle[10];
        firemen = new FireMan[150];
        if (checkName(name))this.name = name;
        else this.name = "Barrack";
        currentFiremen = 0;
        currentVehicles = 0;
    }

    private boolean checkName(String name) {
        return !(name == null || name.equals(""));
    }
    private boolean checkPos(double lat, double lon){
        return lat > -9.5 && lat <-6.2 && lon > 36.8 && lon < 42.2;
    }

    //verifica as condicoes(agua, bombeiros), posição= barrack
    public void verifyVehicle() {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getCurrentCapacity() == 0 && vehicles[i].getPosition() == getPosition()) {
                //LEVAR A STATION
                //TRAZER DE VOLTA
            }
        }if (vehicles.length * 3 > firemen.length) {
            System.err.println("ERROR: Not Enough Firemen");
        }
    }

    public void addVehicle(Vehicle v) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                vehicles[i] = v;
                break;
            }
        }
        System.err.println("ERROR: Station Full");
    }

    public void removeVehicle(Vehicle v) {

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == v) {
                vehicles[i] = null;
                break;
            }
        }
        System.err.println("ERROR: Vehicle Not In The Barrack");
    }

    public void addFireMan(FireMan f) {//adicionar bombeiros ao quartel
            for (int i = 0; i < firemen.length; i++) {
                if(firemen[i] != null){
                    firemen[i] = f;
                    break;
                }
            }
            System.err.println("ERROR: Vehicle Full");
    }
    public void removeFireMan(FireMan f) {
        for (int i = 0; i < firemen.length; i++) {
            if (firemen[i] == f) {
                firemen[i] = null;
                break;
            }
        }
        System.err.println("ERROR: FireMan Not In The Barrack");
    }

    public void call() {

    }
    
    //SELETORES
    
    public Position getPosition() {
        return position;
    }
}
