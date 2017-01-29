package JavaFX;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**      netist.....
 * Küsi kasutajalt alguskordinaadid ja laius-kõrgus ning joonista talle ristkülik.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class Ristkulik extends Application{
    private Rectangle rectangle;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        BorderPane borderPane = new BorderPane();
        stackPane.getChildren().addAll(borderPane);
        Scene scene = new Scene(stackPane, 500, 500);
        stage.setScene(scene);

        rectangle = new Rectangle();
        rectangle.setFill(Color.YELLOWGREEN);
        rectangle.setStroke(Color.GREENYELLOW);
        stackPane.getChildren().addAll(rectangle);

        TextField xKoordinaat = new TextField();
        xKoordinaat.setPromptText("Sisesta x koordinaat");
        xKoordinaat.textProperty().addListener((observable, vanaX, uusX) -> {
            System.out.println("Uus väärtus: " + uusX);
            String x = xKoordinaat.getText();
            if (Double.parseDouble(x) > 250 || Double.parseDouble(x) < -250) {
                xKoordinaat.clear();
            } else {
                rectangle.setTranslateX(Double.parseDouble(x));
            }

        });
        TextField yKoordinaat = new TextField();
        yKoordinaat.setPromptText("Sisesta y koordinaat");
        yKoordinaat.textProperty().addListener((observable, vanaY, uusY) -> {
            System.out.println("Uus väärtus: " + uusY);
            String y = yKoordinaat.getText();
            if (Double.parseDouble(y) > 100 || Double.parseDouble(y) < -250) {
                yKoordinaat.clear();
            } else {
                rectangle.setTranslateY(Double.parseDouble(y));
            }
        });
        TextField laiusVali = new TextField();
        laiusVali.setPromptText("Laius");
        laiusVali.textProperty().addListener((observable, vanaLaius, uusLaius) -> {
            System.out.println("Uus väärtus: " + uusLaius);
            String laius = laiusVali.getText();
            rectangle.setWidth(Double.parseDouble(laius));
        });
        TextField korgusVali = new TextField();
        korgusVali.setPromptText("Korgus");
        korgusVali.textProperty().addListener((observable, vanaKorgus, uusKorgus) -> {
            System.out.println("Uus väärtus: " + uusKorgus);
            String korgus = korgusVali.getText();
            rectangle.setHeight(Double.parseDouble(korgus));
        });

        VBox vBox = new VBox(xKoordinaat, yKoordinaat, laiusVali, korgusVali);
        vBox.setSpacing(5);
        borderPane.setBottom(vBox);

        Slider sl = new Slider();
        sl.setMin(0);
        sl.setMax(360);
        sl.setShowTickLabels(true);
        sl.setOrientation(Orientation.HORIZONTAL);
        sl.setOnMouseDragged(event -> {
            rectangle.setRotate(sl.getValue());
        });

        borderPane.setTop(sl);

        stage.show();

    }
}

