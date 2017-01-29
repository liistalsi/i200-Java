package JavaFX;

        import javafx.application.Application;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Slider;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.Pane;
        import javafx.scene.layout.VBox;
        import javafx.scene.paint.*;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.*;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

        import java.awt.*;    //VERSIOON !!!

/**
 * Joonista ekraanile hunnik ristkülikuid, erinevatel positsioonidel. Ühe korra kastile klikates
 * muutub ta 2x väiksemaks. Teist korda klikates kaob ta sootuks.
 */
public class PixelChaser extends Application {


    public void start(Stage primaryStage) throws Exception {
        Pane  pane = new Pane ();
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        int size = 50;

        Rectangle r = new Rectangle();
        r.setX((int) (Math.random() * 303));
        r.setY((int) (Math.random() * 303));
        r.setWidth(size);
        r.setHeight(size);
        Rectangle r2 = new Rectangle();
        r2.setX((int) (Math.random() * 303));
        r2.setY((int) (Math.random() * 303));
        r2.setWidth(size);
        r2.setHeight(size);
        Rectangle r3 = new Rectangle();
        r3.setX((int) (Math.random() * 303));
        r3.setY((int) (Math.random() * 303));
        r3.setWidth(size);
        r3.setHeight(size);

        r.setOnMousePressed((e) -> {
            r.setHeight(size / 2);
            r.setWidth(size / 2);
            r.setOnMousePressed((e2) -> {
                r.setHeight(0);
                r.setWidth(0);
            });
        });

        r2.setOnMousePressed((e) -> {
            r2.setHeight(size / 2);
            r2.setWidth(size / 2);
            r2.setOnMousePressed((e2) -> {
                r2.setHeight(0);
                r2.setWidth(0);
            });
        });

        r3.setOnMousePressed((e) -> {
            r3.setHeight(size / 2);
            r3.setWidth(size / 2);
            r3.setOnMousePressed((e2) -> {
                r3.setHeight(0);
                r3.setWidth(0);
            });
        });

        pane.getChildren().addAll(r, r2, r3);
    }
}
