package JavaFX;
/**
 * Joonista 500x500 ekraanile hunnikuga punaseid ringe.
 * Kui hiir ringile vastu läheb, muutub ring roheliseks.
 * Kordan - ring muudab värvi juba hiire puudutusest, mitte klikist.
 */
        import javafx.application.Application;
        import javafx.event.EventHandler;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;
        import javafx.stage.Stage;
        import java.util.Random;

public class FooridUnenaos extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 500;
        int height = 500;
        int numberOfCircles = 10;

        Group root = new Group();
        Scene scene = new Scene(root, width, height);

        drawCircles(numberOfCircles, root);

        primaryStage.setTitle("Foorid");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (event.getTarget() instanceof Circle) {

                    Circle circle = (Circle) (event.getTarget());

                    circle.setFill(Color.GREEN);

                }
            }
        });

    }

    public void drawCircles(int numberOfCircles, Group root) {

        for (int i = 0; i < numberOfCircles; i++) {
            Circle c = new Circle();
            Random rn = new Random();

            c.setCenterX(rn.nextInt(450) + 50);
            c.setCenterY(rn.nextInt(450) + 50);
            c.setRadius(15);
            c.setFill(Color.RED);
            c.setCache(true);

            root.getChildren().add(c);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}