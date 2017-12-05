
package projeto.ipoo.pkg1718;

//manipulação do tempo, dias? tempo real?

import java.util.Arrays;
import java.util.Timer;
import java.util.Date;

//encher o deposito sempre que sair de um fogo, para que na p+rox vez que for chamado ter o deposito cheio?
//quantos carros por incendio? criterio de divisao de recursos, depende da dimensao do incendio, da distancia?
//quantos veiculos, quantos bombeiros?

public class main {

    private static Timer timer;
    private static Weather w;
    private static Date d;

    public static void main(String[] args) {
        int x = 2, y = 0, i = 0;
        while(i < 2){
        y += x + x/2;
        x = y;
        i++;
        }
        
        Vehicle v = new Vehicle(8, 0,0);
        FireMan f = new FireMan("Ze");
        FireMan f1 = new FireMan("Zeca");
        v.addFireMan(f);
        v.addFireMan(f1);
        v.showFiremenInVehicle();
        
        /*
        d = new Date();
        timer = new Timer();
        timer.scheduleAtFixedRate(w = new Weather(-1, -1, -1),d, 60*60*1000);
        timer.scheduleAtFixedRate(w = new Weather(-1, -1, -1),d, 24*60*60*1000);
        */
    }
    
}
