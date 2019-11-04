package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock implements Visualizable{

    private int period;
    private boolean clockStatus ;
    private Timer timer;
    private IntegerProperty duration;
    private ArrayList<Sensor> listSensor;

    public boolean isClockStatus() {
        return clockStatus;
    }
    public Integer getDuration() {
        return duration.get();
    }
    public void setDuration(Integer duration) {
        this.duration.set(duration);
    }
    public Timer getTimer() {
        return timer;
    }


    public Clock(IntegerProperty duration, int period, ArrayList<Sensor> listSensor){
        this.clockStatus = false;
        this.duration = duration;
        this.period = period;
        this.listSensor = listSensor;
        timer = new Timer();
        timer.schedule(new ClockTask(),0,period);
    }

     class ClockTask extends TimerTask { ;
        public void run() {
            if (duration.get() > 0){
                for (int i = 0; i <= listSensor.size() -1; i++){
                    Sensor sensor = listSensor.get(i);
                    sensor.udapte();
                }
                clockStatus = true;
                duration.set(duration.get()-1);
            }
            else if (duration.get() == -1){
                for (int i = 0; i <= listSensor.size() -1; i++){
                    Sensor sensor = listSensor.get(i);
                    sensor.udapte();
                }
                clockStatus = true;
            }
            else {
                clockStatus = false;
                for (int i = 0; i <= listSensor.size() -1; i++){
                    Sensor sensor = listSensor.get(i);
                    sensor.udapte();
                }
                timer.cancel();
            }
        }

    }

    @Override
    public void accept(MermaidVisualizer v) {
        Listener ClockListener = new Listener();
        ClockListener.Listener(duration,v);
    }

}
