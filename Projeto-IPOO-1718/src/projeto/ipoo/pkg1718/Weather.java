package projeto.ipoo.pkg1718;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Weather extends TimerTask {

    private double temperature, humidity, windVelocity, maxTemperature, minTemperature;
    private Date date;
    private Timer timer;

    public Weather(double temperature, double humidity, double wind) {//reset a meia noite?
        if (checkTemperature(temperature)) {
            this.temperature = temperature;
        } else {
            this.temperature = 20;
        }
        if (checkHumidity(wind)) {
            this.humidity = humidity;
        } else {
            this.humidity = 45;
        }
        if (checkWind(wind)) {
            windVelocity = wind;
        } else {
            windVelocity = 5;
        }
        date = new Date();
        maxTemperature = 45;
        minTemperature = 0;

    }

    public boolean checkTemperature(double x) {
        return !(x < 0 || x > 45);
    }

    public boolean checkHumidity(double x) {
        return !(x < 0 || x > 100);
    }

    public boolean checkWind(double x) {
        return !(x < 0 || x > 100);
    }

    //mudar a temp consoante as horas, regra 3 simples(ex. min= 14, max=28, variar 14 graus em 8h das 6 as 14 tem de aumentar 14 graus, grausAAumentar/numHoras = graus a aumentar por horas, 1.75 por hora)
    public void changeTemperature() {
        while (date.getHours() < 14 || date.getHours() > 6) {
            double difference = maxTemperature - minTemperature;
            temperature += difference / 8;
        }
        while (date.getHours() > 14 || date.getHours() < 6) {
            double difference = maxTemperature - minTemperature;
            temperature -= difference / 8;
        }
    }

    //alterar velocidade consoante a velocidade existemte + ou - 30km/h, verificar max 0 e min 100, random? 
    public void changeWind() {
        Random r = new Random();
        windVelocity = windVelocity - 30 + (windVelocity + 30 - (windVelocity - 30)) * r.nextDouble();;
    }

    //aumnetar a humidade 10% entre as 20h e 8h
    public void changeHumidity() {
        if (date.getHours() > 20 || date.getHours() < 8) {
            humidity += 0.10 * humidity;
        }
    }

    @Override
    public void run(){//uma opção para alterar o tempo de hora a hora
        if (date.getHours() < 14 || date.getHours() > 6) {
            double difference = maxTemperature - minTemperature;
            temperature += difference / 8;
        }
        if (date.getHours() > 14 || date.getHours() < 6) {
            double difference = maxTemperature - minTemperature;
            temperature -= difference / 8;
        }

    }

    //SELETORES
    public double getTemp() {
        return temperature;
    }
    public double getHum() {
        return humidity;
    }
    public double getWind() {
        return windVelocity;
    }
}
