package com.gui.content_mangement_components;

import javafx.stage.Stage;

public class StageGetter {
    private static StageGetter getter;
    private static Stage stage;
    private StageGetter() {
    }
    public static StageGetter getInstance() {
        if (stage == null) {
            getter = new StageGetter();
        }
        return getter;
    }

    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setResizable(false);
    }
}
