//package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Joonista ekraanile hunnik ristkülikuid, suvalistel positsioonidel. Ühe korra kastile klikates
 * muutub ta 2x väiksemaks. Teist korda klikates kaob ta sootuks.
 */
public class PixelChaser extends Application {

    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();

        Pane kujund = new Pane();
        Scene stseen = new Scene(kujund, 500, 500);
        primaryStage.setScene(stseen);

        ArrayList<Rectangle> uusRuut = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Rectangle joonistanRuudu = new Rectangle(100, 50);
            joonistanRuudu.setTranslateX(Math.random() * 500);
            joonistanRuudu.setTranslateY(Math.random() * 500);
            kujund.getChildren().add(joonistanRuudu);
            uusRuut.add(joonistanRuudu);
            joonistanRuudu.setFill(Color.RED);
        }

        for (int i = 0; i < uusRuut.size(); i++) {
            Rectangle tsekinRuutu = uusRuut.get(i);

            tsekinRuutu.setOnMousePressed((e) -> {

                if (tsekinRuutu.getWidth() == 100) {
                    tsekinRuutu.setHeight(50);
                    tsekinRuutu.setWidth(50);

                } else {
                    tsekinRuutu.setWidth(0);
                    tsekinRuutu.setHeight(0);

                }
            });
        }
    }
}