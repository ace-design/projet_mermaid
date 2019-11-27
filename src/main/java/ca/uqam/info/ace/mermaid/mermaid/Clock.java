package ca.uqam.info.ace.mermaid.mermaid;

import ca.uqam.info.ace.mermaid.gui.MermaidVisualizer;
import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock implements Visualizable{

    private int period;
    private Mermaid mermaid;
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


    public Clock(IntegerProperty duration, int period, Mermaid mermaid ){
        this.mermaid = mermaid;
        this.listSensor = mermaid.getlistSensor();
        this.clockStatus = false;
        this.duration = duration;
        this.period = period;
        timer = new Timer();
        timer.schedule(new ClockTask(),0,period);
    }

     class ClockTask extends TimerTask {
         public void run() {
             if (duration.get() > 0) {
                 udapteSensor();
                 udapteDepth();
                 clockStatus = true;
                 duration.set(duration.get() - 1);
             } else if (duration.get() == -1) {
                 udapteSensor();
                 udapteDepth();
                 clockStatus = true;
             } else {
                 clockStatus = false;
                 timer.cancel();
             }
         }
     }



    public void udapteSensor() {
        for (int i = 0; i <= listSensor.size() - 1; i++) {
            Sensor sensor = listSensor.get(i);
            sensor.udapte();
        }
    }

    public void udapteDepth(){
        int gapDepth = mermaid.getDepth()-mermaid.getDepthToGo();
        if (Math.abs(gapDepth) < (int) (mermaid.getSpeed() * (period * 0.001))){
            mermaid.setDepth(mermaid.getDepthToGo());
        }
        else {
            if (gapDepth < 0) {
                mermaid.setDepth(mermaid.getDepth() + ((int) (mermaid.getSpeed() * (period * 0.001))));
            } else if (gapDepth > 0) {
                mermaid.setDepth(mermaid.getDepth() - ((int) (mermaid.getSpeed() * (period * 0.001))));
            }
        }

        }



    @Override
    public void accept(MermaidVisualizer v) {
        Listener ClockListener = new Listener();
        ClockListener.Listener(duration,v);
    }

}
