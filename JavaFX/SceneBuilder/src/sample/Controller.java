package sample;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class Controller implements Initializable {

    @FXML
    ListView<String> policeList;

    @FXML
    ListView<String> tailleList;

    @FXML
    ListView<String> styleList;

    @FXML
    ColorPicker colorPicker1;

    @FXML
    String police;

    @FXML
    String taille;

    @FXML
    String style;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> item1 = observableArrayList("Arial", "Avant Garde", "Avenir", "BebasBell Gothic", "Benguiat Gothic", "Bitstream Vera Sans", "Calibri");
        ObservableList<String> item2 = observableArrayList("8", "9", "10", "11", "12", "14", "18", "24", "32", "64", "72", "96");
        ObservableList<String> item3 = observableArrayList("Normal", "Italique", "Gras", "Gras Italique");
        policeList.setItems(item1);
        tailleList.setItems(item2);
        styleList.setItems(item3);

        //EventHandler<>
    }
}
