package JavaFX;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

/** TEHTUD Laupäeval! Created by kullirist on 21/01/2017.
 * Marko M. mulle: Väga hea Soovitan kasutada alati Pane, kõik ülejäänud on kasutuse poolest väga spetsiifilised

 * Loo JavaFXis koristaja mäng.
 * 1. Ekraan (näiteks 500x500) on paksult ringe täis. Nii, et läbi ei näe.
 * 2. Ringile hiirega vastu minnes kaob ring ära.
 * 3. Ringide all on peidus sõnum (näiteks Labeliga), mida kasutaja lõpuks näeb.
 */
public class Koristaja extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The Stage Version of Ky Tree Program");
        primaryStage.show();

        StackPane kujund = new StackPane();
        Scene stseen = new Scene(kujund, 500, 500);
        primaryStage.setScene(stseen);
        kujund.setRotate(30);
        stseen.setFill(Paint.valueOf("#ff9900"));

        Label l = new Label();
        l.setText("Laiskvorst!");
        //FontLoader fontLoader = Toolkit.getToolkit().getFontLoader(); // http://stackoverflow.com/questions/21074024/how-to-get-label-getwidth-in-javafx
        l.setFont(Font.font("Ubuntu Bold", FontWeight.BOLD, 50));
        l.setTranslateX(150);

        l.setTranslateY(100);
        l.setScaleX(0.5);
        l.setScaleY(2);
        l.setRotate(10);
        kujund.getChildren().add(l);

        ArrayList<Circle> list = new ArrayList<>();

        for (int i = 0; i < 300; i++) {             //siin on ringide arv
            Circle joonistanRingi = new Circle(Math.random() * 70);
            joonistanRingi.setTranslateX(Math.random() * 500 - 250);
            joonistanRingi.setTranslateY(Math.random() * 500 - 250);   //asukoht xy telje suhtes
            joonistanRingi.setOnMouseEntered(event -> {
                joonistanRingi.setVisible(false);
            });
            kujund.getChildren().add(joonistanRingi);
            list.add(joonistanRingi);
        }
    }
}
