//package JavaFX;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sun.text.resources.cldr.ia.FormatData_ia;

import java.util.ArrayList;

/**
 * Joonista 500x500 ekraanile hunnikuga punaseid ringe.
 * Kui hiir ringile vastu läheb, muutub ring roheliseks.
 * Kordan - ring muudab värvi juba hiire puudutusest, mitte klikist.
 */
public class FooridUnenaos extends Application {

    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();

        Pane kujund = new Pane();
        Scene stseen = new Scene(kujund, 500, 500);
        primaryStage.setScene(stseen);

        ArrayList<Circle> uusRing = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Circle joonistanRingi = new Circle(50);
            joonistanRingi.setTranslateX(Math.random()*500);
            joonistanRingi.setTranslateY(Math.random()*500);
            kujund.getChildren().add(joonistanRingi);
            uusRing.add(joonistanRingi);
            joonistanRingi.setFill(Color.RED);
        }

        for (int i = 0; i < uusRing.size(); i++) {
            Circle tsekinRingi = uusRing.get(i);
            tsekinRingi.setOnMouseEntered(event -> {
                tsekinRingi.setFill(Color.GREEN);
            });
        }
    }
}
