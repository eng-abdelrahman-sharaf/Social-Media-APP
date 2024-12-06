package com.gui.content_mangement_components;

import com.MediaApp.ContentManagement.Content;
import com.MediaApp.ContentManagement.IContent;
import com.MediaApp.ContentManagement.IMedium;
import com.MediaApp.ContentManagement.Post;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.Instant;

public class TestController extends Pane {

    @FXML
    private ContentContainerComponent container;

    @FXML
    private void switchToSecondary() throws IOException {
    }

    public TestController() {
        super();
    }

    public void initialize() {
        try {
            System.out.println(container);
            container.setItems(new IMedium[]{new Post("4613646" , "4f6a68w" , new Content("apwldp[wkfoawmjopamnfomwaopfmaw[f[pawkmf[wpamfwap[mfp[awmf[pawlkfdp[aw [kwa[p kw[pfak [pkwap[f lkwap[ kp[wkaf [pk[p k [pkawp[ k[pdwakp[ fkw[ap") , Instant.now())});

        }catch (NullPointerException e){
            System.out.println("container does not exist");
        }
    }
}
