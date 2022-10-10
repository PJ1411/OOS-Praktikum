
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Stellt den Zugriff auf die Anmeldungseite zur verfügung
 */
public class AnmeldungsController{
    @FXML private TextField newUserid;
    @FXML private TextField newPasswort;
    @FXML private TextField wiederholung;
    @FXML private  Button submit;
    private Main main;

    public void setMain(Main m) {main =m;}

    /**
     * Überprüft ob das Passwort und die Wiederholung übereinstimmem, wenn ja wird
     * ein neuer BenutzerSystem.Benutzer angelegt wenn nicht wird eine Fehlermeldung ausgegeben
     * @param event überprüft die eingabe des Benutzers
     * @throws IOException tritt auf wenn .fmxl von ErrorAnmeldung nicht gefunden wird
     */
    @FXML
    public void neuAnmeldung(Event event) throws IOException{
        if(!newPasswort.getText().equals(wiederholung.getText())){
            main.startFehler("Passwort!=Wiederholung");
            newPasswort.clear();
            wiederholung.clear();
            Stage stage = (Stage) submit.getScene().getWindow();
            stage.close();
        } else{
            Benutzer benutzer= new Benutzer(newUserid.getText(),newPasswort.getText());
            main.neuerBenutzer(benutzer);
            Stage stage = (Stage) submit.getScene().getWindow();
            stage.close();
        }
    }
}
