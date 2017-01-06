package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by ltalsi on 23.10.2016.
 */
public class JavaProject extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        Set<String> allZones = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);

        VBox vbox = new VBox();
        Scene timeConverter = new Scene(vbox, 600, 500);
        primaryStage.setScene(timeConverter);
        primaryStage.show();

        Label location = new Label("What's your current location (City)?");
        TextField locationField = new TextField();
        locationField.setPromptText("My location");

        Label time = new Label("What time are you interested in?");
        TextField timeField = new TextField();
        timeField.setPromptText("Time");

        Label target = new Label("What destination (City) are you interested in?");
        TextField targetField = new TextField();
        targetField.setPromptText("Target destination");

        Button submitButton = new Button("Calculate!");
        submitButton.setOnAction((event) -> {

            String CurrentLocation = locationField.getText();
            String TargetLocation = targetField.getText();

            LocalTime now1 = null;
            LocalTime now2 = null;

            LocalDateTime dt = LocalDateTime.now();
            for (String city : zoneList) {
                ZoneId zone = ZoneId.of(city);
                ZonedDateTime zdt = dt.atZone(zone);

                if (city.contains(CurrentLocation)) {

                    ZoneId zone1 = ZoneId.of(city);
                    now1 = LocalTime.now(zone1);
                }
            }

            for (String city : zoneList) {
                ZoneId zone = ZoneId.of(city);
                ZonedDateTime zdt = dt.atZone(zone);

                if (city.contains(TargetLocation)) {

                    ZoneId zone2 = ZoneId.of(city);
                    now2 = LocalTime.now(zone2);
                }
            }

            System.out.println("Time in your city of " + CurrentLocation + " is " + now1.toString().substring(0, 5));
            System.out.println("and");
            System.out.println("Time in the target city of " + TargetLocation + " is " + now2.toString().substring(0, 5));
        });

        vbox.getChildren().addAll(location, locationField, time, timeField, target, targetField, submitButton);

    }
}
