package sample.Harjutus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by ltalsi on 23.10.2016.
 */
public class JavaFX {
}
import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.layout.StackPane;
        import javafx.scene.shape.Circle;
        import javafx.stage.Stage;

class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

        Circle ring = new Circle(50);
        stack.getChildren().add(ring);

    }

}