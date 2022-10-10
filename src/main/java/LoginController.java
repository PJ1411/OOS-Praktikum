
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Stellt ein login Fenster dar, ermöglicht Zugriff um einen neuen BenutzerSystem.Benutzer anzulegen
 */
public class LoginController extends AnmeldungsController{
    private boolean neuAnmeldung = false;
    @FXML private CheckBox anmeldung;
    @FXML private Button submitButton;
    @FXML private TextField userid;
    @FXML private TextField passwort;
    private Main main;

    public void setMain(Main m) {main =m;}



    /**
     * Öffnet ein Anmeldungsfenster wenn die neueAnmeldung Checkbox = true ist, sonst wird ein neuer BenutzerSystem.Benutzer angelget
     * und auf der Konsole ausgegeben
     * @param actionEvent überprüft die eingabe des Benutzers
     * @throws IOException throws wenn anmeldung.fxml nicht gefunden werden kann
     */
    @FXML
    public void sub(ActionEvent actionEvent) throws IOException {
        if(anmeldung.isSelected())
        {
            neuAnmeldung = true;
            System.out.println("neuAnmeldung");
            main.neueAnmeldung();
        } else {
            String name = userid.getText();
            String pass = passwort.getText();
            Benutzer benutzer = new Benutzer(name, pass);
            if (!main.List.benutzerVorhanden(benutzer)) {
                main.UserdoesntExist();
            } else {
                System.out.println(benutzer.toString());
                main.startAC();
            }
        }
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();


    }
}
