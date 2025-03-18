package org.example.controlcell;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.IIOImage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView ImageView;

    @FXML
    private RadioButton radioCat;

    @FXML
    private ToggleGroup animal;

    @FXML
    private RadioButton radioDog;

    @FXML
    private RadioButton radioTurtle;

    @FXML
    private Label lblInfo;


    Image dog = new Image(String.valueOf(getClass().getResource("/images/pies.jpg")));
    Image cat = new Image(String.valueOf(getClass().getResource("/images/kot.jpg")));
    Image turtle = new Image(String.valueOf(getClass().getResource("/images/zolw.jpg")));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radioCat.setOnAction(actionEvent -> {
            ImageView.setImage(cat);
            lblInfo.setText("Zaznaczono zdjęcie z " + radioCat.getText());
        });
        radioDog.setOnAction(actionEvent -> {
            ImageView.setImage(dog);
            lblInfo.setText("Zaznaczono zdjęcie z " + radioDog.getText());
        });
        radioTurtle.setOnAction(actionEvent -> {
            ImageView.setImage(turtle);
            lblInfo.setText("Zaznaczono zdjęcie z " + radioTurtle.getText());
        });
    }
}
