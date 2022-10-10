
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    public BenutzerVerwaltungAdmin List = new BenutzerVerwaltungAdmin("","benutzer.list");

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main m = new Main();
        m.List = new BenutzerVerwaltungAdmin("","benutzer.list");
        m.startListenWahl();
    }

    /**
     * startet die Anmeldungsseite nachdem diese beim Login ausgewählt wurde
     * @throws IOException throws wenn anmeldung.fxml nicht gefunden wurde
     */
    public void neueAnmeldung() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("anmeldung.fxml"));
        Parent anwendung = (Parent) loader.load();
        AnmeldungsController anmeldungsController = loader.getController();
        anmeldungsController.setMain(this);
        Scene ac = new Scene(anwendung);
        Stage acs = new Stage();
        acs.setTitle("Benutzerverwaltung");
        acs.setScene(ac);
        acs.show();
    }


    /**
     * Startet das Fenster um die Liste auszuwählen. Entweder kann eine neue Liste initalisiert werden oder die alte Liste wieder geladen werden.
     * @throws IOException throws, wenn list.fxml nicht gefunden wird
     */
    public void startListenWahl() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
        Parent anwendung = (Parent) loader.load();
        ListController listController = loader.getController();
        listController.setMain(this);
        Scene ac = new Scene(anwendung);
        Stage acs = new Stage();
        acs.setTitle("Benutzerverwaltung");
        acs.setScene(ac);
        acs.show();
    }

    /**
     * Öffmet den Anwedungs-Controller, soll geöffnet werden wenn eine Anmeldung erfolgreich wr
     * @throws IOException throws, wenn anwendung.fxml nicht gefunden wird
     */
    public void startAC() throws IOException{

        Parent anwendung = FXMLLoader.load(getClass().getResource("anwendung.fxml"));
        Scene ac = new Scene(anwendung);
        Stage acs = new Stage();
        acs.setTitle("Benutzerverwaltung");
        acs.setScene(ac);
        acs.show();
    }

    /**
     * Legt einen neuen Benutzer an wenn die korrekten anforderungen gefunden wurden
     * @param benutzer der hinzugefügt werden soll zur Liste
     * @throws IOException throws wenn LoginController.fxml nicht gefunden wird
     */

    void neuerBenutzer(Benutzer benutzer) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginController.fxml"));
        Parent anwendung = (Parent) loader.load();
        AnmeldungsController anmeldungsController = loader.getController();
        anmeldungsController.setMain(this);

        try{
            List.benutzerEintrag(benutzer);
            benutzerLogin();
        } catch (passwortCheck k){
            startFehler("Passwort enspricht nicht den Vorgaben");
        } catch (UserAlreadyExists e){
            startFehler("Benutzer existiert bereits");
        }
    }

    /**
     * startet den LoginController
     * @throws IOException wenn LoginController.fxml nicht gefunden wird
     */
    public void benutzerLogin() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginController.fxml"));
        Parent anwendung = (Parent) loader.load();
        LoginController loginController = loader.getController();
        loginController.setMain(this);
        Scene lc = new Scene(anwendung);
        Stage lcs = new Stage();
        lcs.setTitle("Benutzerverwaltung");
        lcs.setScene(lc);
        lcs.show();
    }

    /**
     * start eine Fehlermeldung
     * @param fehler Fehlermeldung die Ausgegeben werden soll
     * @throws IOException throws wenn errorAnmeldung.fxml nicht gedunden wurde
     */
    public void startFehler(String fehler) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("errorAnmeldung.fxml"));
        Parent anwendung = (Parent) loader.load();
        ErrorAnmeldung errorAnmeldung = loader.getController();
        errorAnmeldung.setMain(this);
        errorAnmeldung.setError("Error: " + fehler);
        Scene ea = new Scene(anwendung);
        Stage eas = new Stage();
        eas.setTitle("Benutzerverwaltung");;
        eas.setScene(ea);
        eas.show();

    }

    /**
     * Öffnet die Fehlermeldung das der User nicht existiert
     * @throws IOException throws wenn UserDoesntExistError.fxml nicht gefunden wird
     */
    public void UserdoesntExist() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDoesntExistError.fxml"));
        Parent anwendung = (Parent) loader.load();
        UserDoesntExistC userDoesntExistC = loader.getController();
        userDoesntExistC.setMain(this);
        Scene ea = new Scene(anwendung);
        Stage eas = new Stage();
        eas.setTitle("Benutzerverwaltung");;
        eas.setScene(ea);
        eas.show();

    }
}
