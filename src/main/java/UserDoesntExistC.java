import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDoesntExistC extends LoginController {
    @FXML
    private Button tryagain;
    private Main main;

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * schließt das Fenster und ermöglicht die eingabe eines neuen Passworts
     * @param event achtet auf die eingabe des Benutzers
     */
    public void goBack(Event event) throws IOException {

        main.benutzerLogin();
        Stage stage = (Stage) tryagain.getScene().getWindow();
        stage.close();
    }
}
