//package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Küsi kasutajalt x, y kordinaadid ja raadius ning joonista talle ring.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class Ring extends Application{

    public void start(Stage primaryStage) throws Exception {

        VBox kujund = new VBox();
        Scene stseen = new Scene(kujund, 800, 600);

        Pane taust = new Pane();
        Scene ringiVaade = new Scene(taust, 800, 600);

        primaryStage.setScene(stseen);
        primaryStage.show();

        Label raadius = new Label("Sisesta ringi raadius:");
        TextField raadiusField = new TextField();
        raadiusField.setPromptText("Ringi raadius");

        Label koordinaatX = new Label("Sisesta ringi X-koordinaat:");
        TextField koordinaatXField = new TextField();
        koordinaatXField.setPromptText("X-koordinaat");

        Label koordinaatY = new Label("Sisesta ringi Y-koordinaat:");
        TextField koordinaatYField = new TextField();
        koordinaatYField.setPromptText("Y-koordinaat");

        Button submitButton = new Button("Tee ring!");
        submitButton.setOnAction((event) -> {

            int ringiRaadius = Integer.parseInt(raadiusField.getText());
            int ringiKoordinaatX = Integer.parseInt(koordinaatXField.getText());
            int ringiKoordinaatY = Integer.parseInt(koordinaatYField.getText());

            Circle uusRing = new Circle();
            uusRing.setRadius(ringiRaadius);
            uusRing.setCenterX(ringiKoordinaatX);
            uusRing.setCenterY(ringiKoordinaatY);
            uusRing.setFill(Color.BLACK);

            taust.getChildren().add(uusRing);
            primaryStage.setScene(ringiVaade);

        });

        kujund.getChildren().addAll(raadius, raadiusField, koordinaatX, koordinaatXField, koordinaatY, koordinaatYField, submitButton);

    }


}
