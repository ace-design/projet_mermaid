package ca.uqam.info.ace.mermaid.gui;

import ca.uqam.info.ace.mermaid.mermaid.Mermaid;
import javafx.scene.Parent;
import javafx.scene.text.Text;

public class ClockVisualizer extends Parent {

    public ClockVisualizer (Mermaid mermaid) {
        if (mermaid.getClock().isClockStatus()) {
            Text text = new Text("Clock : "+mermaid.getClock().getDelay());
            this.getChildren().add(text);
        }
        else {
            Text text = new Text("Clock : Time's up ");
            this.getChildren().add(text);
        }
    }

}
