package ca.uqam.info.ace.mermaid.mermaid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private boolean clockStatus ;
    private Timer timer;
    private int delay;
    private ArrayList<Sensor> listSensor;

    public boolean isClockStatus() {
        return clockStatus;
    }
    public int getDelay() {
        return delay;
    }


    public Clock(int delay, ArrayList<Sensor> listSensor){
        this.clockStatus = false;
        this.delay = delay;
        this.listSensor = listSensor;
        timer = new Timer();
        timer.schedule(new ClockTask(),0,1*1000);  //period = 1sc , changement de valeur toutes les secondes
    }

     class ClockTask extends TimerTask { ;
        public void run() {
            if (delay > 0){
                for (int i = 0; i <= listSensor.size() -1; i++){
                    Sensor sensor = listSensor.get(i);
                    sensor.setValue(sensor.getLaw().build());
                }
                clockStatus = true;
                delay--;
            }
            else {
                for (int i = 0; i <= listSensor.size() -1; i++){
                    Sensor sensor = listSensor.get(i);
                    sensor.setValue(sensor.getLaw().build());
                }
                clockStatus = false;
                timer.cancel();
            }
        }

    }

}
