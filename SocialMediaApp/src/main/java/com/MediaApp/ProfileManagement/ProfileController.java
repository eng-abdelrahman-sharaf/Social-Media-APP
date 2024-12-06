package com.MediaApp.ProfileManagement;

import com.MediaApp.ContentManagement.*;
import com.gui.content_mangement_components.ContentContainerComponent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.time.Instant;

public class ProfileController {

    @FXML
    private ImageView avatar;

    @FXML
    private ImageView cover;

    @FXML
    private Button dobButton;

    @FXML
    private Button emailButton;

    @FXML
    private Button passwordButton;

    @FXML
    private ContentContainerComponent postsContainer;

    @FXML
    private ContentContainerComponent storiesContainer;


    @FXML
    private ScrollPane postsPanel;

    @FXML
    private ScrollPane storiesPanel;

    @FXML
    private Button unameButton;

    public void initialize() {


        IContent content = new Content("apwldp[wkfoawmjopamnfomwaopfmaw[f[pawkmf[wpamfwap[mfp[awmf[pawlkfdp[aw [kwa[p kw[pfak [pkwap[f lkwap[ kp[wkaf [pk[p k [pkawp[ k[pdwakp[ fkw[ap");
        content.addAttachment("/com/gui/content_mangement_components/cover.jpg");
        content.addAttachment("/com/gui/content_mangement_components/cover.jpg");
        content.addAttachment("/com/gui/content_mangement_components/cover.jpg");
        Medium[] mediums= {
                new Post("4613646" , "4f6a68w" , content , Instant.now()),
                new Story("4684" , "46984" , content , Instant.now()),
        };
        postsContainer.setItems(mediums);
        storiesContainer.setItems(mediums);
    }

}
