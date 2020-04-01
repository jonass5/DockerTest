package DockerExample;

import DockerExample.Entity.Person;
import DockerExample.Repo.PersonRepoAlt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.bouncycastle.asn1.x509.sigi.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.border.Border;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Main extends Application {

    public static PersonRepoAlt repo;

    public static void main(String[] args) throws SQLException, IOException {
        SpringApplication.run(Main.class, args);

        PersonRepoAlt repoAlt = new PersonRepoAlt();
        repo = repoAlt;

        repoAlt.updatePerson(10, "Adelina", "Pitts");

        repoAlt.add("test321", "abc", 87);

        List<Person> list = repoAlt.getAll();
        System.out.println(list);

        Person p = repoAlt.getByID(5);
        System.out.println(p);

        System.out.println("test");

        repoAlt.removePerson(6);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("viewPerson.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}