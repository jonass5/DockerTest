package DockerExample;

import DockerExample.Entity.Person;
import DockerExample.Repo.PersonRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import org.springframework.stereotype.Component;

@Component
public class ViewController {

    PersonRepository personRepository;

    @FXML
    TextField txtid;
    @FXML
    TextField txtfname;
    @FXML
    TextField txtlname;
    @FXML
    TextField txtage;

    @FXML
    Button btnAdd;
    @FXML
    Button btnUpdate;
    @FXML
    Button btnRemove;
    @FXML
    Button btnGet;

    public void initialize() {
        personRepository = new PersonRepository();
        btnAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                personRepository.add(txtfname.getText(), txtlname.getText(), Integer.parseInt(txtage.getText()));
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setContentText("Person hinzugefügt!");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            } catch (Exception e) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setContentText(e.getCause().toString());
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            }
        });

        btnGet.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                Person p = personRepository.getByID(Integer.parseInt(txtid.getText()));
                txtlname.setText(p.getLastname());
                txtfname.setText(p.getFirstname());
                txtage.setText(String.valueOf(p.getAge()));
            } catch (Exception e) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setContentText("ID nicht gefunden!");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            }
        });

        btnRemove.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                personRepository.removePerson(Integer.parseInt(txtid.getText()));
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setContentText("Person gelöscht!");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            } catch (Exception e) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setContentText("ID nicht gefunden!");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            }
        });

        btnUpdate.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                personRepository.updatePerson(Integer.parseInt(txtid.getText()), txtfname.getText(), txtlname.getText(), Integer.parseInt(txtage.getText()));
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setContentText("Person geupdatet!");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            } catch (Exception e) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setContentText("ID nicht gefunden!");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(MainFX.primaryStage);
                dialog.showAndWait();
            }
        });
    }
}
