
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ermöglicht den Zugriff auf den abbrechen Button
 */
public class AnwendungsController {
    @FXML Button abbrechenButton;
    private Main main;

    public void setMain(Main m) {main = m;}

    /**
     * Wenn der Knopf gedrückt wird schließt das Fenster
     * @param event überprüft die Eingabe des Benutzers
     */
    @FXML
    public void abbrechen(Event event){
        System.out.println("Das Fenster wurde geschlossen!");
        Stage stage = (Stage) abbrechenButton.getScene().getWindow();
        stage.close();
    }
}
