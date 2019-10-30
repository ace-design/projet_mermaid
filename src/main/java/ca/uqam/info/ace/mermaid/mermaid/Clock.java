package ca.uqam.info.ace.mermaid.mermaid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private int period;
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


    public Clock(int delay, int period, ArrayList<Sensor> listSensor){
        this.clockStatus = false;
        this.delay = delay;
        this.listSensor = listSensor;
        timer = new Timer();
        timer.schedule(new ClockTask(),0,period);
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
