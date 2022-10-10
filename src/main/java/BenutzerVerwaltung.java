/**
 * enthät nur die beiden Methoden die später vom Benutzer verwendet werden dürfen
 */



public interface BenutzerVerwaltung {
    public void benutzerEintrag(Benutzer benutzer) throws UserAlreadyExists, passwortCheck;
    public boolean benutzerVorhanden(Benutzer benutzer) throws UserDoesNotExist;
}
