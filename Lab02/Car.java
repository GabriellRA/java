public class Car{
    
    String brand, model;
    int tankCapacity, tankLevel, tripDistance, totalDistance, numberOfTrips;

    public Car(String brand, String model, int capacity){
        tankCapacity = capacity;
        this.model = model;
        this.brand = brand;
        tankLevel = 0;
        tripDistance = 0;
        totalDistance = 0;
        numberOfTrips = 0;
    }
    void setCapacity(int capacity){
        tankCapacity = capacity;
    }
    void setLevel(int level){
        tankLevel = level;
    }
    void setTripD(int tripD){
        tripDistance = tripD;
    }
    void setTotalD(int totalD){
        totalDistance = totalD;
    }
    void setTrips(int trips){
        numberOfTrips = trips;
    }
    void fillTank(){
        tankLevel = tankCapacity;
    }
    void makeTrip(int km, int l){
        tripDistance += km;
        totalDistance += km;
        tankLevel -= l;
        numberOfTrips += 1;
    }
    void showMeters(){
        System.out.println("Capacidade do Depósito:            " + tankCapacity + " Litros");
        System.out.println("Nível do Depósito:                  " + tankLevel + " Litros");
        System.out.println("Distância percorrida na viagem:     " + tripDistance + " Km");
        System.out.println("Distância total percorrida:         " + totalDistance + " Km");
    }
    void resetTrip(){
        numberOfTrips = 0;
        tripDistance = 0;
    }
    int averageConsumption(){ 
        return (tankLevel * 100) / tripDistance;
    }
    int estimatedRange(){
        return (tankLevel * 100) / 6;
    }
    void showInfo(){
        System.out.println("#"+ brand + " " + model + "#");
        System.out.println("Capacidade do Depósito:            " + tankCapacity + " Litros");
        System.out.println("Nível do Depósito:                  " + tankLevel + " Litros");
        System.out.println("Distância percorrida na viagem:     " + tripDistance + " Km");
        System.out.println("Distância total percorrida:         " + totalDistance + " Km");
        System.out.println("Total de viagens:                    " + tankLevel + " Litros");
    }
}