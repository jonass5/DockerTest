package DockerExample;

import DockerExample.Entity.Person;
import DockerExample.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class viewController {
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
    Button btnRemove;
    @FXML
    Button btnGet;

    public void initialize() {

        btnAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.repo.add(txtfname.getText(), txtlname.getText(), Integer.parseInt(txtage.getText()));
            }
        });

        btnGet.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Person p = Main.repo.getByID(Integer.parseInt(txtid.getText()));
                txtfname.setText(p.getFirstname());
                txtlname.setText(p.getLastname());
                txtage.setText(String.valueOf(p.getAge()));
            }
        });

        btnRemove.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.repo.removePerson(Integer.parseInt(txtid.getText()));
            }
        });
    }
}
