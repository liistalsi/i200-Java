package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by ltalsi on 23.10.2016.
 */
public class TestJavaFX extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene timeconverter = new Scene(vbox, 600, 500);
        primaryStage.setScene(timeconverter);
        primaryStage.show();

        Label asukoht = new Label("Mis on sinu asukoht (linn)?");
        TextField asukohaField = new TextField();
        asukohaField.setPromptText("Minu asukoht");

        Label kellaaeg = new Label("Mis on kell sinu asukohas (linn)?");
        TextField kellaaegField = new TextField();
        kellaaegField.setPromptText("Kellaaeg");

        Label sihtkoht = new Label("Mis on sind huvitav sihtkoht (linn)?");
        TextField sihtkohtField = new TextField();
        sihtkohtField.setPromptText("Sihtkoht");

        Button submitButton = new Button("Arvuta!");

        vbox.getChildren().addAll(asukoht, asukohaField, kellaaeg, kellaaegField, sihtkoht, sihtkohtField, submitButton);


    }
}
