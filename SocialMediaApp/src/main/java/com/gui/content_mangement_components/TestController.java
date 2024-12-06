package com.gui.content_mangement_components;

import com.MediaApp.ContentManagement.*;
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
//        Testing Container for posts and stories
        try {
            System.out.println(container);
            IContent content = new Content("apwldp[wkfoawmjopamnfomwaopfmaw[f[pawkmf[wpamfwap[mfp[awmf[pawlkfdp[aw [kwa[p kw[pfak [pkwap[f lkwap[ kp[wkaf [pk[p k [pkawp[ k[pdwakp[ fkw[ap");
            content.addAttachment("/com/gui/content_mangement_components/cover.jpg");
            content.addAttachment("/com/gui/content_mangement_components/cover.jpg");
            content.addAttachment("/com/gui/content_mangement_components/cover.jpg");
            Medium[] mediums= {
                    new Post("4613646" , "4f6a68w" , content , Instant.now()),
                    new Story("4684" , "46984" , content , Instant.now()),
            };
            container.setItems(mediums);
            container.setContainerWidth(200);
        }catch (NullPointerException e){
            System.out.println("container does not exist");
        }
    }
}
