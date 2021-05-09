package TD1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

public class InterfacePolice extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Les boxs
        BorderPane home = new BorderPane();
        VBox box = new VBox();
        HBox OkAnnulerBox = new HBox(20);
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

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

        definir.setMinWidth(50);
        B_effet.setMinWidth(50);
        OK.setMinWidth(50);
        annuler.setMinWidth(50);

        //Les labels
        Label L_effet = new Label("Effets");
        Label L_aperçu = new Label("Aperçu");

        //Les checkboxs
        CheckBox barré = new CheckBox("Barré");
        barré.setPrefHeight(5);
        barré.setPrefWidth(150);
        CheckBox barréDouble = new CheckBox("Barré Double");
        barréDouble.setPrefHeight(5);
        barréDouble.setPrefWidth(150);
        CheckBox exposant = new CheckBox("Exposant");
        exposant.setPrefHeight(5);
        exposant.setPrefWidth(150);
        CheckBox indice = new CheckBox("Indice");
        indice.setPrefHeight(5);
        indice.setPrefWidth(150);
        CheckBox petiteMaj = new CheckBox("Petite Majusucle");
        petiteMaj.setPrefHeight(5);
        petiteMaj.setPrefWidth(150);
        CheckBox majuscule = new CheckBox("Majuscule");
        majuscule.setPrefHeight(5);
        majuscule.setPrefWidth(150);
        CheckBox masqué = new CheckBox("Masqué");
        masqué.setPrefHeight(5);
        masqué.setPrefWidth(150);

        //Police Verdana 14
        Font verdana14 = new Font("Verdana", 14);
        L_effet.setFont(verdana14);
        L_aperçu.setFont(verdana14);

        //Police Verdana 12
        Font verdana12 = new Font("Verdana", 12);
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

        //Anchor Pane
        Label label1 = new Label("Police :");
        AnchorPane.setTopAnchor(label1, 20.0);
        AnchorPane.setLeftAnchor(label1, 20.0);
        TextField textField1 = new TextField ();
        textField1.setPrefWidth(170);
        AnchorPane.setTopAnchor(textField1, 40.0);
        AnchorPane.setLeftAnchor(textField1, 20.0);

        ListView<String> listView1 = new ListView<>();
        AnchorPane.setTopAnchor(listView1, 70.0);
        AnchorPane.setLeftAnchor(listView1, 20.0);
        ObservableList<String> items1 = FXCollections.observableArrayList("Times New Roman", "Traditional Arabic", "Trajan Pro", "Trebuchet MS", "Tunga");
        listView1.setItems(items1);
        listView1.setPrefWidth(170);
        listView1.setPrefHeight(120);

        Label label2 = new Label("Style de Police :");
        AnchorPane.setTopAnchor(label2, 20.0);
        AnchorPane.setLeftAnchor(label2, 210.0);
        TextField textField2 = new TextField ();
        textField2.setPrefWidth(120);
        AnchorPane.setTopAnchor(textField2, 40.0);
        AnchorPane.setLeftAnchor(textField2, 210.0);
        ListView<String> listView2 = new ListView<>();
        AnchorPane.setTopAnchor(listView2, 70.0);
        AnchorPane.setLeftAnchor(listView2, 210.0);
        ObservableList<String> items2 = FXCollections.observableArrayList("Normal", "Italique", "Gras", "Gras Italique");
        listView2.setItems(items2);
        listView2.setPrefWidth(120);
        listView2.setPrefHeight(120);

        Label label3 = new Label("Taille :");
        AnchorPane.setTopAnchor(label3, 20.0);
        AnchorPane.setLeftAnchor(label3, 350.0);
        TextField textField3 = new TextField ();
        textField3.setPrefWidth(100);
        AnchorPane.setTopAnchor(textField3, 40.0);
        AnchorPane.setLeftAnchor(textField3, 350.0);
        ListView<String> listView3 = new ListView<>();
        AnchorPane.setTopAnchor(listView3, 70.0);
        AnchorPane.setLeftAnchor(listView3, 350.0);
        ObservableList<String> items3 = FXCollections.observableArrayList("8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72");
        listView3.setItems(items3);
        listView3.setPrefWidth(100);
        listView3.setPrefHeight(120);


        // ligne 2
        Label label4 = new Label("Couleur de police :");
        AnchorPane.setTopAnchor(label4, 200.0);
        AnchorPane.setLeftAnchor(label4, 30.0);
        ColorPicker colorPicker = new ColorPicker();
        AnchorPane.setTopAnchor(colorPicker, 220.0);
        AnchorPane.setLeftAnchor(colorPicker, 30.0);

        choixPolice.getChildren().addAll(label1,textField1,listView1, label2, textField2, listView2, label3, textField3, listView3, label4, colorPicker);

        //Apparence
        Color blanc = Color.WHITE;
        BackgroundFill bfNoir = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill bfGray = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);
        Background bNoir = new Background(bfNoir);
        Background bGray = new Background(bfGray);
        CornerRadii taille_5 = new CornerRadii(5);
        BorderStroke BS_blanc = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, taille_5, BorderWidths.DEFAULT);
        BorderStroke TF_blanc = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        Border B_blanc = new Border(BS_blanc);
        Border T_blanc = new Border(TF_blanc);

        //Les couleurs
        home.setBackground(bNoir);

        L_aperçu.setTextFill(blanc);
        L_effet.setTextFill(blanc);

        barré.setTextFill(blanc);
        barréDouble.setTextFill(blanc);
        exposant.setTextFill(blanc);
        indice.setTextFill(blanc);
        petiteMaj.setTextFill(blanc);
        majuscule.setTextFill(blanc);
        masqué.setTextFill(blanc);

        definir.setBackground(bNoir);
        definir.setTextFill(blanc);
        definir.setBorder(B_blanc);

        OK.setBackground(bNoir);
        OK.setTextFill(blanc);
        OK.setBorder(B_blanc);

        annuler.setBackground(bNoir);
        annuler.setTextFill(blanc);
        annuler.setBorder(B_blanc);

        B_effet.setBackground(bNoir);
        B_effet.setTextFill(blanc);
        B_effet.setBorder(B_blanc);

        label1.setTextFill(blanc);
        textField1.setBackground(bGray);
        textField1.setBorder(T_blanc);

        label2.setTextFill(blanc);
        textField2.setBackground(bGray);
        textField2.setBorder(T_blanc);

        label3.setTextFill(blanc);
        textField3.setBackground(bGray);
        textField3.setBorder(T_blanc);

        label4.setTextFill(blanc);

        //Les commandes
        home.setCenter(box);
        home.setStyle("");
        home.setBottom(OkAnnulerBox);

        //Margin
        OkAnnulerBox.setMargin(definir, new Insets(0, -10, 10, 10));
        OkAnnulerBox.setMargin(B_effet, new Insets(0, 0, 10, 0));
        OkAnnulerBox.setMargin(OK, new Insets(0,-10,10,0));
        OkAnnulerBox.setMargin(annuler, new Insets(0,10,10,0));

        Flow_effets.setMargin(L_effet, new Insets(20, 0, 2, 10));
        Flow_aperçu.setMargin(L_aperçu, new Insets(5, 0, 5, 10));

        //GetChildren
        Flow_effets.getChildren().add(L_effet);
        Flow_aperçu.getChildren().add(L_aperçu);
        Tile_effets.getChildren().addAll(barré, barréDouble, exposant, indice, petiteMaj, majuscule, masqué);

        box.getChildren().addAll(choixPolice, Flow_effets, Tile_effets, Flow_aperçu, Grid_aperçu);
        OkAnnulerBox.getChildren().addAll(definir, B_effet, region1, OK, annuler);

        Tile_effets.setHgap(130);
        Tile_effets.setVgap(5);
        Tile_effets.setPadding(new Insets(10));

        //Evenement
        annuler.setOnAction(actionEvent -> primaryStage.close());
        listView1.setOnMousePressed(actionEvent -> textField1.setText(listView1.getSelectionModel().getSelectedItem()));
        listView1.setOnKeyPressed(actionEvent -> textField1.setText(listView1.getSelectionModel().getSelectedItem()));

        listView2.setOnMousePressed(actionEvent -> textField2.setText(listView2.getSelectionModel().getSelectedItem()));
        listView2.setOnKeyPressed(actionEvent -> textField2.setText(listView2.getSelectionModel().getSelectedItem()));

        listView3.setOnMousePressed(actionEvent -> textField3.setText(listView3.getSelectionModel().getSelectedItem()));
        listView3.setOnKeyPressed(actionEvent -> textField3.setText(listView3.getSelectionModel().getSelectedItem()));

        colorPicker.setOnAction(actionEvent -> label4.setTextFill(colorPicker.getValue()));

        //Aperçu
        Canvas canvas = new Canvas(500, 100);
        Label text = new Label("Police TrueType, identique à l'écran et à l'impression");
        text.setTextFill(blanc);
        var gc = canvas.getGraphicsContext2D();
        gc.setStroke(blanc);
        gc.setLineWidth(2);

        var rect_height = 80;
        var rect_width = 400;
        var x = Math.round((canvas.getWidth() / 2) - (400 / 2));
        var y = Math.round((canvas.getHeight() / 2) -  (80 / 2));

        gc.strokeRect(x,y,rect_width,rect_height);

        Grid_aperçu.getChildren().addAll(canvas, text);


        //Exécution
        primaryStage.setTitle("Police");
        primaryStage.setScene(new Scene(home, 300, 275));
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(620);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
