
package projeto.ipoo.pkg1718;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Fire {
    
    
    private final Position position;
    private double burnedArea;//valor random
    private Vehicle[] vehicles;
    private LocalDateTime dateOfFire;
    private final String startHour;
    private String endHour;
    private Weather w;
    
    public Fire(double burnedArea, double lat, double lon){
        Random r = new Random();
        if(checkPos(lat, lon))position = new Position(lat,lon);
        else position = new Position(-9.5+(r.nextDouble()*(-6.2 + 9.5)),36.8+(r.nextDouble()*(42.2-36.8)));
        vehicles = new Vehicle[1000];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = dateOfFire.format(formatter);
        startHour = formatDateTime;
    }
    
    private boolean checkBurnedArea(double area){
        return !(area < 0 || area > 500000000);
    }
    private boolean checkPos(double lat, double lon){
        return lat > -9.5 && lat <-6.2 && lon > 36.8 && lon < 42.2;
    }
    
    public void ignite(){
        double humFactor = 0,tempFactor = 0,windFactor = 0;
        if(w.getHum() == 45){
            humFactor = 1;
        }if (w.getHum() < 45){//aumenta o T linearmente
            
        }if (w.getHum() > 45) {//diminuir
            
        }if(w.getTemp() == 20){
            tempFactor = 0;
        }else{
            tempFactor += (w.getTemp() - 20) * 0.1;
        }if(w.getWind() < 5){
            windFactor = 0;
        }else{
            if(w.getTemp() > 25 && w.getHum() < 30){
                windFactor += (w.getWind()*0.2)/5;
            }
        }
        burnedArea += Math.sqrt(humFactor + tempFactor + windFactor);
    }
    public void extinguishFire(){
        
    }
    public void addVehicle(Vehicle v){
        for(int i = 0; i < vehicles.length; i++){
            if(vehicles[i] == null){
                if(vehicles[i].getPosition()== getPosition()){
                vehicles[i] = v;
                break;
                }
            }
        }
    }
    public void removeVehicle(Vehicle v){
        for(int i = 0; i < vehicles.length; i++){
            if(vehicles[i] == v){
                vehicles[i] = null;
                break;
            }
        }
    }
    
    //SELETORES
    public Position getPosition() {
        return position;
    }
}
