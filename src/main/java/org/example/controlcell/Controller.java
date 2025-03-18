package org.example.controlcell;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

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
    @FXML
    private Slider slider;
    @FXML
    private ScrollBar scrollBar;
    @FXML
    private Rectangle rect;
    @FXML
    private Label lblSize;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private Label lblNumbers;


    Image dog = new Image(String.valueOf(getClass().getResource("/images/pies.jpg")));
    Image cat = new Image(String.valueOf(getClass().getResource("/images/kot.jpg")));
    Image turtle = new Image(String.valueOf(getClass().getResource("/images/zolw.jpg")));
    StringBuilder numbers = new StringBuilder("100");


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
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                rect.setWidth(300 *slider.getValue()/slider.getMax());
                rect.setHeight(240 *slider.getValue()/slider.getMax());
                scrollBar.setValue(slider.getValue());
                lblSize.setText((int)(300 *slider.getValue()/slider.getMax()) + " x " + ((int)(240 *slider.getValue()/slider.getMax())));

            }
        });

        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                rect.setWidth(300 *scrollBar.getValue()/scrollBar.getMax());
                rect.setHeight(240 *scrollBar.getValue()/scrollBar.getMax());
                slider.setValue(scrollBar.getValue());

            }
        });

        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(50,150,100,10);
        spinner.setValueFactory(spinnerValueFactory);

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                numbers.append("\n").append(spinnerValueFactory.getValue());
                lblNumbers.setText(String.valueOf(numbers));
            }
        });

    }
}
