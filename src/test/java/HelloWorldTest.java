import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jonathan.lindegaard.starup.javafxwrapper.ApplicationWrapper;

import java.util.function.BiConsumer;

public class HelloWorldTest {

    public static void main(String[] args) {

        Runnable init = () -> System.out.println("init");
        Runnable stop = () -> System.out.println("stop");
        BiConsumer<Application, Stage> start = (application, primaryStage) -> {
            Button btn = new Button();
            btn.setText("Say 'Hello World'");
            btn.setOnAction(event -> System.out.println("Hello World!"));

            StackPane root = new StackPane();
            root.getChildren().add(btn);

            Scene scene = new Scene(root, 300, 250);

            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        };

        ApplicationWrapper.setInitFunction(init);
        ApplicationWrapper.setStartFunction(start);
        ApplicationWrapper.setStopFunction(stop);
        ApplicationWrapper.launchApp(args);
    }


}