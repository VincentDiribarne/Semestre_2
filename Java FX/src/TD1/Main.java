package TD1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Les boxs
        BorderPane home = new BorderPane();
        VBox box = new VBox();
        HBox OkAnnulerBox = new HBox(20);

        //Les conteneurs
        AnchorPane choixPolice = new AnchorPane();
        FlowPane Flow_effets = new FlowPane();
        TilePane Tile_effets = new TilePane();
        FlowPane Flow_aperçu = new FlowPane();
        GridPane Grid_aperçu = new GridPane();

        //Les boutons
        Button definir = new Button("Definir par défaut");
        Button B_effet = new Button("Effet par défaut");
        Button OK = new Button("Ok");
        Button annuler = new Button("Annuler");

        //Les labels
        Label L_effet = new Label("Effets");
        Label L_aperçu = new Label("Aperçu");

        //Les checkboxs
        CheckBox barré = new CheckBox("Barré");
        barré.setPrefHeight(10);
        barré.setPrefWidth(150);
        CheckBox barréDouble = new CheckBox("Barré Double");
        barréDouble.setPrefHeight(10);
        barréDouble.setPrefWidth(150);
        CheckBox exposant = new CheckBox("Exposant");
        exposant.setPrefHeight(10);
        exposant.setPrefWidth(150);
        CheckBox indice = new CheckBox("Indice");
        indice.setPrefHeight(10);
        indice.setPrefWidth(150);
        CheckBox petiteMaj = new CheckBox("Petite Majusucle");
        petiteMaj.setPrefHeight(10);
        petiteMaj.setPrefWidth(150);
        CheckBox majuscule = new CheckBox("Majuscule");
        majuscule.setPrefHeight(10);
        majuscule.setPrefWidth(150);
        CheckBox masqué = new CheckBox("Masqué");
        masqué.setPrefHeight(10);
        masqué.setPrefWidth(150);

        //Police Verdana 14
        Font verdana14 = new Font("Verdana", 14);
        L_effet.setFont(verdana14);
        L_aperçu.setFont(verdana14);

        //Police Verdana 12
        Font verdana12 = new Font("Verdane", 12);
        definir.setFont(verdana12);
        B_effet.setFont(verdana12);
        OK.setFont(verdana12);
        annuler.setFont(verdana12);

        barré.setFont(verdana12);
        barréDouble.setFont(verdana12);
        exposant.setFont(verdana12);
        indice.setFont(verdana12);
        petiteMaj.setFont(verdana12);
        majuscule.setFont(verdana12);
        masqué.setFont(verdana12);

        //Les commandes
        home.setCenter(box);
        //box.setStyle("-fx-background-color: red");
        home.setBottom(OkAnnulerBox);
        //OkAnnulerBox.setAlignment(Pos.BOTTOM_CENTER);
        definir.setAlignment(Pos.CENTER);
        //Tile_effets.setAlignment(Pos.CENTER);

        Flow_effets.getChildren().add(L_effet);
        Flow_aperçu.getChildren().add(L_aperçu);
        Tile_effets.getChildren().addAll(barré, barréDouble, exposant, indice, petiteMaj, majuscule, masqué);

        box.getChildren().addAll(choixPolice, Flow_effets, Tile_effets, Flow_aperçu, Grid_aperçu);
        OkAnnulerBox.getChildren().addAll(definir, B_effet, OK, annuler);

        Tile_effets.setHgap(130);
        Tile_effets.setVgap(10);
        Tile_effets.setPadding(new Insets(10));

        //Ombre sur le bouton
        DropShadow shadow = new DropShadow();
        definir.setEffect(shadow);
        definir.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<>() {
            public void handle(MouseEvent e) {
                definir.setEffect(shadow);
            }
        });

        definir.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<>() {
            public void handle(MouseEvent e) {
                definir.setEffect(null);
            }
        });

        //Exécution
        primaryStage.setTitle("Police");
        primaryStage.setScene(new Scene(home, 300, 275));
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
