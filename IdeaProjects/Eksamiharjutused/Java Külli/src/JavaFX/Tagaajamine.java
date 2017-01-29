package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Ky Rist    TEHTUD!!!
 * Joonista 500x500 ekraanile ring. Kui hiir ringile vastu läheb, leiab ring omale
 * uue koha.  Lihtsalt ilmub uues kohas ja kõik.
 * Ehk hiirega saab ringi taga ajada. Kordan - ring leiab uue koha juba hiire puudutusest,
 * mitte klikist. Aga alustada võid muidugi klikist.
 */
public class Tagaajamine extends Application {

    Circle circle;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);

        circle = new Circle(40);
        circle.setTranslateX(250);
        circle.setTranslateY(250);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.DARKBLUE);
        pane.getChildren().addAll(circle);

        reageeriHiirele();

        stage.show();
    }

    public void reageeriHiirele() {
        circle.setOnMouseEntered(event -> {

            System.out.println("Pihtas!");
            double x = (double) Math.random() * 500;
            double y = (double) Math.random() * 500;
            circle.setTranslateX(x);
            circle.setTranslateY(y);
        });
    }
}
