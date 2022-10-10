import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Wird geöffnet wenn die beiden Passwörter nicht übereinstimmen und gibt eine Fehlermeldung aus
 */
public class ErrorAnmeldung{
    @FXML
    private Button tryagain;
    private Main main;
    @FXML private Label error;

    public void setMain(Main m) {
        this.main = m;
    }

    public void setError(String fehler){error.setText(fehler);}
    /**
     * schließt das Fenster und ermöglicht die eingabe eines neuen Passworts
     * @param event achtet auf die eingabe des Benutzers
     */
    public void goBack(Event event) throws IOException {
        main.neueAnmeldung();
        Stage stage = (Stage) tryagain.getScene().getWindow();
        stage.close();
    }

}
