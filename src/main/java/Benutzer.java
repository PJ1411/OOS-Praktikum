

import java.io.Serializable;

/**
 * Kann BenutzerSystem.Benutzer erstellen, vergleichen und ausgeben
 */
public class Benutzer implements Serializable {

    String userID;
    char[] passWort;

    /**
     * Erstellt einen neuen BenutzerSystem.Benutzer
     * @param user übergibt die userID, muss ein String sein
     * @param pass übergibt das passWort, muss ein Char-Array sein
     */
    Benutzer(String user, char[] pass)
    {
        userID = user;
        passWort = pass;
    }

    /**
     * Erstellt einen neuen Nutzer der eine Kopie von x ist
     * @param x enthält die Werte für den neuen BenutzerSystem.Benutzer
     */
    Benutzer(Benutzer x)
    {
        userID = x.userID;
        passWort = x.passWort;
    }

    /**
     * Erstellt einen neuen BenutzerSystem.Benutzer wandelt einen String zum char-Array umwandelt
     * @param user übergibt die userID, muss ein String sein
     * @param pass wird später zu einem Char-Array und übergibt dann das passWort
     */
    public Benutzer(String user, String pass)
    {
        userID=user;
        passWort = pass.toCharArray();
    }

    /**
     * gibt die länge des passWort wieder.
     * @return int (länge des Passworts).
     */
    int getPWlength(){return passWort.length;}

    /**
     * Überprüft ob das passWort min. 8 lang ist und eine Zahl enthält.
     * @return true, wenn passWort den Anforderungen entspricht, sonst false.
     */
    boolean pwZahl(){

        for(int i=0;i<getPWlength();i++)
        {
            for(int k=0;k<10;k++){
                char b = (char)(k + '0');
                if(passWort[i]== b)
                    return true;
            }
        }
        return false;
    }

    /**
     * Wandelt userID und passWort zu String um.
     * @return "(userID, passWort)" als String
     */
    public String toString()
    {
        String s ="";
        s = s.copyValueOf(passWort);
        return ("(" + userID +", " + s+")");
    }

    /**
     * Überprüft ob die beiden BenutzerSystem.Benutzer gleich sind
     * @param x der zu vergleichene BenutzerSystem.Benutzer
     * @return true wenn beide BenutzerSystem.Benutzer gleich sind sonst falls
     */
    public boolean equals(Benutzer x)
    {
        String s1="";
        s1=s1.copyValueOf(this.passWort);
        String s2="";
        s2=s2.copyValueOf(x.passWort);
        if(this.userID.equals(x.userID)&&s1.equals(s2))
            return true;
        return false;
    }
}

