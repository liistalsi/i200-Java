package JavaFX;

/**
 * Küsi kasutajalt alguse ja lõpu x-y kordinaadid ning joonista talle joon.
 * Akna võime limiteerida 500x500 piksli peale.
 */

        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.control.TextInputDialog;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.StackPane;
        import javafx.scene.shape.Circle;
        import javafx.scene.shape.Line;
        import javafx.stage.Stage;

        import java.util.Scanner;

public class Joon extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 500, 500);
        primaryStage.setScene(scene);

        TextField xa = new TextField("X alg");
        TextField ya = new TextField("Y alg");
        TextField xl = new TextField("X lopp");
        TextField yl = new TextField("Y lopp");
        Button btn = new Button("Joonista");

        xa.setTranslateY(-80);
        xl.setTranslateY(-50);
        ya.setTranslateY(-20);
        yl.setTranslateY(10);
        btn.setTranslateY(50);
        stack.getChildren().addAll(xa,ya,xl, yl, btn);

        primaryStage.show();
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.ENTER) {
                btn.fire();
            }
        });




        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                int Xalg = Integer.parseInt(xa.getText());
                int Yalg = Integer.parseInt(ya.getText());
                int Xlopp = Integer.parseInt(xl.getText());
                int Ylopp = Integer.parseInt(yl.getText());

                stack.getChildren().removeAll(xa,ya,yl,yl,btn);


                Line line = new Line();

                line.setStartX(Xalg);
                line.setStartY(Yalg);
                line.setEndX(Xlopp);
                line.setEndY(Ylopp);

                stack.getChildren().add(line);
            }
        });


    }

}
