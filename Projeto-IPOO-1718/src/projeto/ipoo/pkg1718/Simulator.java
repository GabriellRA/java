package projeto.ipoo.pkg1718;
    
import java.util.Random;

    
public class Simulator {
    private Barrack[] barracks;
    private Vehicle[] vehicles;
    private FireMan[] firemen;
    private FillingStation[] fillingStations;
    private Fire[] fires;
    private Weather weather;
    
    
    public void create(){
        Random rn = new Random();
        barracks = new Barrack[rn.nextInt(70) + 30];
        for(int i = 0; i < barracks.length; i++){
            barracks[i] = new Barrack(-9.5+(rn.nextDouble()*(-6.2 + 9.5)),36.8+(rn.nextDouble()*(42.2-36.8)));
        }
        vehicles = new Vehicle[rn.nextInt(300) + 700];
        for(int i = 0; i < vehicles.length; i++){
            vehicles[i] = new Vehicle(rn.nextInt(20000-1500) + 1500,-9.5+(rn.nextDouble()*(-6.2 + 9.5)),36.8+(rn.nextDouble()*(42.2-36.8)));
        }
        firemen = new FireMan[rn.nextInt(400) + 800];
        for(int i = 0; i < firemen.length; i++){
            firemen[i] = new FireMan("");
        }
        fillingStations = new FillingStation[rn.nextInt(30) + 20];
        for(int i = 0; i < fillingStations.length; i++){
            fillingStations[i] = new FillingStation("",-9.5+(rn.nextDouble()*(-6.2 + 9.5)),36.8+(rn.nextDouble()*(42.2-36.8)));
        }
        fires = new Fire[rn.nextInt(30) + 10];
        for(int i = 0; i < fires.length; i++){
            fires[i] = new Fire(rn.nextInt(5000-1000) + 1000,-9.5+(rn.nextDouble()*(-6.2 + 9.5)),36.8+(rn.nextDouble()*(42.2-36.8)));
        }
        weather = new Weather(-1,-1,-1);
    }
}
