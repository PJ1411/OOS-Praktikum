import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController{
    @FXML
    Button alteListe;
    @FXML Button neueListe;
    private Main main;

    public void setMain(Main m) {main=m;}

    @FXML
    private void neueListe(ActionEvent actionEvent) throws IOException {
        main.List.dbInit();
        Stage stage = (Stage) neueListe.getScene().getWindow();
        stage.close();
        main.List = new BenutzerVerwaltungAdmin("","benutzer.list");
        main.List.dbInit();
        main.benutzerLogin();
    }

    @FXML
    private void listeAufrufen(ActionEvent actionEvent) throws IOException {
        main.List.dbRead();
        main.benutzerLogin();
        Stage stage = (Stage) neueListe.getScene().getWindow();
        stage.close();
    }
}
