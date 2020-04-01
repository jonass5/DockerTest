package DockerExample;

import DockerExample.Event.StageReadyEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class MainFX extends Application {

    public static Stage primaryStage;
    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public void init() {
        configurableApplicationContext = new SpringApplicationBuilder(Main.class).run();
    }

    @Override
    public void stop() {
        configurableApplicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) {
        MainFX.primaryStage = primaryStage;
        configurableApplicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }
}
