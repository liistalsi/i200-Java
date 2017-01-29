package JavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*  SEDA ON VAJA VEEL TEHA - aga tuleb vaadata ristkülik jms lahendust


 * Küsi kasutajalt x, y kordinaadid ja raadius ning joonista talle ring.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */


public class Ring extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            StackPane stack = new StackPane();
            Scene scene = new Scene(stack, 350, 350);
            primaryStage.setScene(scene);
            Circle ring = new Circle(50);
            stack.getChildren().add(ring);
            primaryStage.show();

        }
}
