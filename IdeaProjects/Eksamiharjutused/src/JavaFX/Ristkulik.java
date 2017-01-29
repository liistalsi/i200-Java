//package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Küsi kasutajalt alguskordinaadid ja laius-kõrgus ning joonista talle ristkülik.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class Ristkulik extends Application {

    public void start(Stage primaryStage) throws Exception {

        VBox vaade1 = new VBox();
        Scene stseen = new Scene(vaade1, 800, 600);

        Pane vaade2 = new Pane();
        Scene ristkulikuVaade = new Scene(vaade2, 800, 600);

        primaryStage.setScene(stseen);
        primaryStage.show();

        Label laius = new Label("Sisesta ristkuliku laius:");
        TextField laiusField = new TextField();
        laiusField.setPromptText("Ristkuliku laius");

        Label korgus = new Label("Sisesta ristkuliku korgus:");
        TextField korgusField = new TextField();
        korgusField.setPromptText("Ristkuliku korgus");

        Label koordinaatX = new Label("Sisesta ristkuliku X-koordinaat:");
        TextField koordinaatXField = new TextField();
        koordinaatXField.setPromptText("X-koordinaat");

        Label koordinaatY = new Label("Sisesta ristkuliku Y-koordinaat:");
        TextField koordinaatYField = new TextField();
        koordinaatYField.setPromptText("Y-koordinaat");

        Button submitButton = new Button("Tee ristkulik!");
        submitButton.setOnAction((event) -> {

            int ristkulikuLaius = Integer.parseInt(laiusField.getText());
            int ristkulikuKorgus = Integer.parseInt(korgusField.getText());
            int ristkulikuKoordinaatX = Integer.parseInt(koordinaatXField.getText());
            int ristkulikuKoordinaatY = Integer.parseInt(koordinaatYField.getText());

            Rectangle uusRistkulik = new Rectangle();
            uusRistkulik.setWidth(ristkulikuLaius);
            uusRistkulik.setHeight(ristkulikuKorgus);
            uusRistkulik.setX(ristkulikuKoordinaatX);
            uusRistkulik.setY(ristkulikuKoordinaatY);
            uusRistkulik.setFill(Color.BLACK);

            vaade2.getChildren().add(uusRistkulik);
            primaryStage.setScene(ristkulikuVaade);

        });

        vaade1.getChildren().addAll(laius, laiusField, korgus, korgusField, koordinaatX, koordinaatXField, koordinaatY, koordinaatYField, submitButton);

    }


}
