package jonathan.lindegaard.starup.javafxwrapper;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.function.BiConsumer;

public class ApplicationWrapper extends Application {

    private static BiConsumer<Application, Stage> startFunction = null;
    private static Runnable initFunction = null;
    private static Runnable stopFunction = null;
    private static boolean launched = false;

    public static void setStartFunction(BiConsumer<Application, Stage> startFunction) {
        if (launched) launchProtocolError("setStartFunction");
        ApplicationWrapper.startFunction = startFunction;
    }

    public static void setInitFunction(Runnable initFunction) {
        if (launched) launchProtocolError("setInitFunction");
        ApplicationWrapper.initFunction = initFunction;
    }

    public static void setStopFunction(Runnable stopFunction) {
        if (launched) launchProtocolError("setStopFunction");
        ApplicationWrapper.stopFunction = stopFunction;
    }

    @Override
    public void start(Stage stage) {
        if (startFunction != null) startFunction.accept(this, stage);
    }

    @Override
    public void init() {
        if (initFunction != null) initFunction.run();
    }

    @Override
    public void stop() {
        if (stopFunction != null) stopFunction.run();
    }

    public static void launchApp(String... args) {
        launched = true;
        launch(ApplicationWrapper.class, args);
    }

    // private methods

    private static void launchProtocolError(String functionName) {
        throw new RuntimeException(String.format("Must not call '%s' after calling 'launchApp'.", functionName));
    }
}
