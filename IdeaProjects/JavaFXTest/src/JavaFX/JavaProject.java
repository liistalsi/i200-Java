package JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        List<String> zoneList = new ArrayList(allZones);
        Collections.sort(zoneList);

        /*
          Defining main project window settings
         */

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(30, 30, 30, 30));
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

        Label outcome = new Label ("");

        Button submitButton = new Button("Calculate!");
        submitButton.setOnAction((event) -> {

            String CurrentLocation = locationField.getText();
            String TargetLocation = targetField.getText();

            /*
               Input validation, if input is empty then show error, if not then proceed
             */

            if (CurrentLocation.equals("") || TargetLocation.equals("")) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Whoops! Something went wrong!");
                alert.setHeaderText("No such City available!");
                alert.setContentText("Please make sure you entered two Cities.");

                alert.showAndWait();

            } else {

                /*
                   Input validation, if City is entered with ' ' converts it to '_'
                 */

                String formattedCurrentLocation = CurrentLocation.replace(' ', '_');
                String formattedTargetLocation = TargetLocation.replace(' ', '_');

                LocalTime now1 = null;
                LocalTime now2 = null;

                /*
                   Converts all the input to lowercase and gives the result to now1 and now2
                 */

                for (String city : zoneList) {

                      if (city.toLowerCase().contains(formattedCurrentLocation.toLowerCase())) {

                        ZoneId zone1 = ZoneId.of(city);
                        now1 = LocalTime.now(zone1);
                      }
                }

                for (String city : zoneList) {

                    if (city.toLowerCase().contains(formattedTargetLocation.toLowerCase())) {

                        ZoneId zone2 = ZoneId.of(city);
                        now2 = LocalTime.now(zone2);
                    }
                }

                /*
                  Input validation, if data doesn't make any sense, show new error message
                 */

                if (now1 != null && now2 != null) {

                    outcome.setText("\nTime in your city of " + CurrentLocation + " is "
                            + now1.toString().substring(0, 5) + " \nand\n" + "time in the target city of " + TargetLocation + " is "
                            + now2.toString().substring(0, 5));

                    now1 = null;
                    now2 = null;

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Whoops! Something went wrong!");
                    alert.setHeaderText("No such City available!");
                    alert.setContentText("Please enter new/other Cities.");

                    alert.showAndWait();
                }
            }
        });

        vbox.getChildren().addAll(location, locationField, time, timeField, target, targetField, submitButton, outcome);

    }
}
