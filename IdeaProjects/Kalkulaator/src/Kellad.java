import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

public class Kellad extends Dashboard {

    public static String[] locations = Dashboard.locations;
    private static StringProperty hintText = new SimpleStringProperty("Choose another hour to see the time at destinations at that point in time.");
    public static Boolean timersShouldStop = false;
    public static HashMap<String, StringProperty> timesAndLocations = new HashMap<>();
    public static Stage exportableStage;
    public static Scene exportableScene;

    public static Stage Kellad(Stage primaryStage) {

        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(5);

        HBox clockContainer = new HBox();
        clockContainer.setAlignment(Pos.CENTER);
        clockContainer.setSpacing(30);

        int locationsRealLength = 0;

        for (int i = 0; i < locations.length; i++) {
            if (locations[i] != null && locations[i] != "null") {
                locationsRealLength++;
            }
        }

        for (int i = 0; i < locationsRealLength; i++) {

            String location = locations[i];

            Label locationLabel = generateLabel(location, "Location", "location");
            Label timeLabel = generateLabel(location, "Time", "time");
            Label userTimeLabel = generateLabel(location, "Time", "time");
            Label periodLabel = generateLabel(location, "Period", "period");
            userTimeLabel.setManaged(false);

            VBox clockObject = new VBox();
            clockObject.setSpacing(5);
            clockObject.setAlignment(Pos.CENTER);
            clockObject.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1);");
            clockObject.setPadding(new Insets(20, 20, 20, 20));

            timesAndLocations.put(location, new SimpleStringProperty(""));

            clockObject.getChildren().addAll(locationLabel, timeLabel, userTimeLabel, periodLabel);
            clockContainer.getChildren().add(clockObject);

            userTimeLabel.textProperty().bindBidirectional(timesAndLocations.get(location));

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        timeLabel.setText(kellaAeg(location, "default"));
                    });

                    if (timersShouldStop) {
                        timer.cancel();
                        timer.purge();
                        timeLabel.setVisible(false);
                        timeLabel.setManaged(false);
                        userTimeLabel.setVisible(true);
                        userTimeLabel.setManaged(true);
                    }
                }
            }, 0, 100);
        }

        HBox hourButtons = new HBox();
        hourButtons.setAlignment(Pos.BASELINE_CENTER);
        hourButtons.setSpacing(10);
        hourButtons.setPadding(new Insets(5, 10, 5, 10));

        for (int i = 1; i < 13 ; i++) {

            Hyperlink hourLink = new Hyperlink("Hour");
            hourLink.setTextFill(Color.web("#ffffff"));
            hourLink.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 12));
            hourLink.setText("" + i + "");
            hourLink.setCursor(Cursor.HAND);
            hourLink.setPadding(new Insets(5, 10, 5, 10));

            hourLink.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    int clickedHour = Integer.parseInt(hourLink.textProperty().getValue());

                    Date date = new Date();
                    SimpleDateFormat currentHourFormat = new SimpleDateFormat("h");
                    SimpleDateFormat currentMinuteFormat = new SimpleDateFormat("m");
                    SimpleDateFormat currentSecondFormat = new SimpleDateFormat("s");

                    int hourString = Integer.parseInt(currentHourFormat.format(date));
                    int minuteString = Integer.parseInt(currentMinuteFormat.format(date));
                    int secondString = Integer.parseInt(currentSecondFormat.format(date));

                    int neededHour = clickedHour - hourString;
                    int neededMinute = 0 - minuteString;
                    int neededSecond = 0 - secondString;

                    Set set = timesAndLocations.entrySet();
                    Iterator iterator = set.iterator();

                    while(iterator.hasNext()) {

                        Map.Entry mapEntry = (Map.Entry)iterator.next();
                        String location = String.valueOf(mapEntry.getKey());

                        String locationTime = kellaAeg(String.valueOf(mapEntry.getKey()), "default");
                        DateFormat dateFormat = new SimpleDateFormat("h:mm:ss");

                        Date startDate = null;
                        try {
                            startDate = dateFormat.parse(locationTime);

                        } catch (ParseException error) {

                            error.printStackTrace();
                        }

                        DateFormat timeHereFormat = new SimpleDateFormat("h:mm:ss");

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(startDate);
                        cal.add(Calendar.HOUR, neededHour);
                        cal.add(Calendar.MINUTE, neededMinute);
                        cal.add(Calendar.SECOND, neededSecond);
                        String newTime = timeHereFormat.format(cal.getTime());

                        timesAndLocations.get(location).setValue(newTime);

                    }
                    timersShouldStop = true;
                }
            });

            hourButtons.getChildren().add(hourLink);
        }

        HBox hourButtonsText = new HBox();
        hourButtonsText.setAlignment(Pos.BASELINE_CENTER);
        hourButtonsText.setSpacing(10);
        hourButtonsText.setPadding(new Insets(30, 10, 5, 10));

        Label HourButtonsTextLabel = new Label();
        HourButtonsTextLabel.setTextFill(Color.web("rgba(255, 255, 255, .8)"));
        HourButtonsTextLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 12));
        HourButtonsTextLabel.textProperty().bind(hintText);

        HourButtonsTextLabel.setPadding(new Insets(5, 10, 5, 10));
        hourButtonsText.getChildren().add(HourButtonsTextLabel);

        container.getChildren().add(clockContainer);
        container.getChildren().add(hourButtonsText);
        container.getChildren().add(hourButtons);

        primaryStage.setTitle("Time zone calculator v0.1");
        container.setStyle("-fx-background-color: #000000;");

        Scene scene = new Scene(container, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        exportableStage = primaryStage;
        exportableScene = scene;

        return primaryStage;

    }

    public static Label generateLabel(String location, String labelName, String type) {

        if (type == "location") {

            Label locationLabel = new Label(labelName);
            locationLabel.setTextFill(Color.web("#ffffff"));
            locationLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 12));
            locationLabel.setText(location.toUpperCase());

            return locationLabel;

        } else if (type == "time") {

            Label timeLabel = new Label(labelName);
            timeLabel.setId("time");
            timeLabel.setTextFill(Color.web("#ffffff"));
            timeLabel.setFont(Font.font("Verdana", 20));

            return timeLabel;

        } else if (type == "period") {

            Label period = new Label(labelName);
            period.setTextFill(Color.web("#ffffff"));
            period.setFont(Font.font("Verdana", 12));
            period.setText(kellaAeg(location,"HH"));

            return period;
        }

        return null;
    }

    public static LocalTime getTime(String location) {

        Set<String> allZones = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList(allZones);
        Collections.sort(zoneList);

        LocalTime Time = null;

        for (String city : zoneList) {

            if (city.toLowerCase().contains(location.toLowerCase())) {

                ZoneId zone = ZoneId.of(city);
                Time = LocalTime.now(zone);
            }
        }

        return Time;
    }

    public static String kellaAeg(String city, String format) {

        SimpleDateFormat dateFormat;
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DATE);

        if (format == "HH") {

            dateFormat = new SimpleDateFormat("a");

        } else {

            dateFormat = new SimpleDateFormat("h:mm:ss");
        }

        LocalTime lt = getTime(city);
        Instant instant = lt.atDate(LocalDate.of(year + 1, month + 1, day + 1)).
                atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return dateFormat.format(date);
    }

}