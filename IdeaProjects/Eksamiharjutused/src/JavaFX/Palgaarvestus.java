import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Palgaarvestus extends Application {

    public void start(Stage primaryStage) throws Exception {

        VBox vaade1 = new VBox();
        Scene stseen = new Scene(vaade1, 800, 600);

        primaryStage.setScene(stseen);
        primaryStage.show();

        Label palk = new Label("Sisesta palk:");
        TextField palgaField = new TextField();
        palgaField.setPromptText("Palk");

        Label kulu = new Label("Sisesta kulu tüüp:");
        TextField kuluField = new TextField();
        kuluField.setPromptText("Kulu tüüp");

        Label kuluSumma = new Label("Sisesta kulu summa:");
        TextField kuluSummaField = new TextField();
        kuluSummaField.setPromptText("Kulu summa");


        Label palkKokku = new Label(" ");
        Label kulud = new Label(" ");
        Label error = new Label("See kulu on liiga suur, võta midagi ette!");

        Button lisaKuluButton = new Button("Lisa kulu!");
        lisaKuluButton.setOnAction((event) -> {

            palkKokku.setText("Sinu palk on hetkel:"  + palgaField.getText());
            lisaKulu(kuluField.getText(), kuluSummaField.getText(), vaade1);

            int kuluKokku = Integer.parseInt(kuluSummaField.getText());
            int tuluKokku = Integer.parseInt(palgaField.getText());

            if (kuluKokku > tuluKokku) {
                vaade1.getChildren().add(error);
            }


        });

        vaade1.getChildren().addAll(palk, palgaField, kulu, kuluField, kuluSumma, kuluSummaField, kulud, lisaKuluButton, palkKokku, error);

    }

    public void lisaKulu (String kulutuup, String kulusuurus, VBox asukoht) {

        Label uusKulu = new Label();
        uusKulu.setText(kulutuup + ": " + kulusuurus);

        asukoht.getChildren().add(uusKulu);
    }

}
