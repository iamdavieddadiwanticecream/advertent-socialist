import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private GameState state = new GameState();

    @Override
    public void start(Stage stage) {
        SaveManager.load(state);

        Button produceButton = new Button("Produce for the People!");
        Label resLabel = new Label();
        Label moneyLabel = new Label();

        Button upgradeButton = new Button("Upgrade Tools (+1/resource)");
        Button saveButton = new Button("Save");

        produceButton.setOnAction(e -> {
            state.produce();
            updateLabels(resLabel, moneyLabel);
        });

        upgradeButton.setOnAction(e -> {
            if (state.getMoney() >= 10) {
                state.upgradeClick();
                state.money -= 10;
                updateLabels(resLabel, moneyLabel);
            }
        });

        saveButton.setOnAction(e -> SaveManager.save(state));

        VBox root = new VBox(10, resLabel, moneyLabel, produceButton, upgradeButton, saveButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        updateLabels(resLabel, moneyLabel);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("People's Clicker");
        stage.show();
    }

    private void updateLabels(Label res, Label money) {
        res.setText("Resources: " + state.getResources());
        money.setText("Money (from taxes): $" + String.format("%.2f", state.getMoney()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
