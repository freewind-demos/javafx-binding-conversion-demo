package demo;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private TextField food;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = createRoot();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private VBox createRoot() {
        return new VBox() {{
            getChildren().addAll(
                    new HBox() {{
                        getChildren().addAll(
                                new Label("Write the food you want"),
                                new TextField() {{
                                    food = this;
                                }}
                        );
                    }},
                    new Label() {{
                        this.textProperty().bind(
                                // The key code is here:
                                Bindings.createStringBinding(
                                        () -> "I want to eat [" + food.textProperty().getValue() + "]",
                                        food.textProperty()
                                )
                        );
                    }}
            );
        }};
    }
}

