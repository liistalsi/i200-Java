//package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Tee JavaFXiga detektiivi mäng, kus kasutaja saab nähtamatuid ringe otsida.
 * 1. Ekraanil (näiteks 500x500) on suvalistes kohtades 3 ringi, mida näha ei ole.
 * 2. Hiirega ringile vastu minnes tuleb ring nähtavale.
 */
public class Detektiiv extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();

        Pane kujund = new Pane();
        Scene stseen = new Scene(kujund, 500, 500);
        primaryStage.setScene(stseen);

        ArrayList<Circle> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            Circle joonistanRingi = new Circle(100);
            joonistanRingi.setTranslateX(Math.random() * 500);
            joonistanRingi.setTranslateY(Math.random() * 500);
            kujund.getChildren().add(joonistanRingi);
            list.add(joonistanRingi);
            joonistanRingi.setFill(Color.WHITE);
        }

        for (int i = 0; i < list.size(); i++) {
            Circle tsekinRingi = list.get(i);
            tsekinRingi.setOnMouseEntered(event -> {
                tsekinRingi.setFill(Color.BLACK);
            });
        }
    }
}
