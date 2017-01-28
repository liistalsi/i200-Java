import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Dashboard extends Application {

    Scene selectionScene, dashboardScene;

    public static String[] locations = new String[5];
    public static SimpleStringProperty locationsHeader = new SimpleStringProperty();
    public static ArrayList locationsList = new ArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(5);

        Button launchDashboard = new Button("Create a new Dashboard");
        Button checkTime = new Button("Quickly check the time");

        launchDashboard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VBox formContainer = new VBox();
                formContainer.setAlignment(Pos.CENTER);
                formContainer.setSpacing(5);
                formContainer.setStyle("-fx-background-color: #000000;");

                VBox textContainer = new VBox();
                textContainer.setAlignment(Pos.CENTER);
                textContainer.setSpacing(20);
                textContainer.setPadding(new Insets(0, 0, 30, 0));

                HBox controlsContainer = new HBox();
                controlsContainer.setAlignment(Pos.CENTER);
                controlsContainer.setSpacing(5);
                controlsContainer.setStyle("-fx-background-color: #000000;");

                Label cityNames = new Label();
                cityNames.textProperty().bindBidirectional(locationsHeader);
                cityNames.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1);");
                cityNames.setPadding(new Insets(20, 20, 20, 20));
                cityNames.setTextFill(Color.WHITE);
                cityNames.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 20));

                Label introText = new Label("Enter city name into the input field.");
                introText.setTextFill(Color.WHITE);
                introText.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 20));

                TextField cityName = new TextField();
                cityName.setPromptText("Enter City name here");

                Button addAnotherCity = new Button("Add to dashboard");
                Button launchTimezoneCalculator = new Button("Launch dashboard");

                textContainer.getChildren().addAll(cityNames, introText);
                controlsContainer.getChildren().addAll(cityName, addAnotherCity, launchTimezoneCalculator);
                formContainer.getChildren().addAll(textContainer, controlsContainer);

                launchTimezoneCalculator.setOnAction(event1 -> {

                    Stage newStage = Kellad.Kellad(primaryStage);

                    primaryStage.hide();
                    newStage.show();
                });

                addAnotherCity.setOnAction(event1 -> {

                    checkInputFields(cityName);
                });

                dashboardScene = new Scene(formContainer, 900, 500);
                primaryStage.setScene(dashboardScene);
            }
        });

        container.getChildren().addAll(launchDashboard, checkTime);
        primaryStage.setTitle("Timezone calculator v 0.1");
        container.setStyle("-fx-background-color: #000000;");

        selectionScene = new Scene(container, 900, 500);
        primaryStage.setScene(selectionScene);
        primaryStage.show();

    }

    public void checkInputFields(TextField field) {

        if (field.getText() != "") {

            City city = new City(field.getText());
            String cityName = city.getName();

            addCityToHeading(cityName);
        }
    }

    public void addCityToHeading(String cityName) {

        if (!locationsList.contains(cityName)) {
            locationsList.add(cityName);
        }

        String temporaryList = new String();

        for (int i = 0; i < locationsList.size(); i++) {

            temporaryList += locationsList.get(i) + "; ";
            locations[i] = locationsList.get(i).toString();

        }

        locationsHeader.set(temporaryList);

    }
}


