package com.projet_t1.ihm;

import javafx.scene.Parent;
import javafx.scene.control.Button;

public class Button_refresh extends Parent {

        public Button_refresh() {
            Button btn = new Button("Refresh");
            btn.setOnAction(click ->{
                this.getChildren().clear();
                Affichage text = new Affichage();
                this.getChildren().add(text);
                this.getChildren().add(btn);
            });
            this.getChildren().add(btn);
        }
}
