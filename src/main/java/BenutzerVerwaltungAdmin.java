

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Erstell eine Liste für Benutzer und verwaltet diese.
 * {@kink #benutzerEintrag()} fügt neuen Benutzer hinzu,
 * {@kink #benutzerVorhanden()} überprüft ob der Nutzer bereits existiert,
 * {@kink #benutzerLöschen()} löscht den Benutzer.
 * {@link #dbInit()} legt eine neue leere Datenstruktur an und serialisiert diese
 * {@link #dbRead()} liest eine Datei aus und übergibt diese einer Liste
 * {@link #dbWrite()} überschreibt die Datei
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {
    private List<Benutzer> list;
    private String dateipfad;
    private String name;

    /**
     * Erstell eine neue Liste zur Datenhaltung der Nutzer
     */
    public BenutzerVerwaltungAdmin()
    {
        list =new ArrayList<Benutzer>();
        dateipfad ="";
        name="";
    }

    /**
     * Erstellt eine neue leere Liste die serialisierte wird an dem angegebenen Dateipfad.
     * @param Dateipfad Ort an dem die Datei abgelegt wird
     * @param Name ,Name der Datei
     */
    public BenutzerVerwaltungAdmin(String Dateipfad, String Name)
    {
        dateipfad = Dateipfad;
        if(!(Name==null)&&!Name.equals(""))
            name = Name;
        else
            name="unkown.test";
    }


    /**
     * Wenn Benutzer noch nicht existiert wird er zur Liste hinzugefügt
     * @param benutzer der zur Liste hinzugefügt werden soll
     * @throws UserAlreadyExists , throws wenn Benutzer bereits in der Liste existiert
     */
    public void benutzerEintrag(Benutzer benutzer) throws UserAlreadyExists, passwortCheck {
        if(benutzerVorhanden(benutzer)) {
            throw new UserAlreadyExists("Benutzer existiert bereits!");
        }else if(benutzer.passWort.length >= 8) {
            if (benutzer.pwZahl()){
                if(dateipfad.equals("") && name.equals(""))
                    list.add(benutzer);
                else {
                    dbRead();
                    list.add(benutzer);
                    dbWrite();
                }
            }
        }else {
            throw new passwortCheck("Passwort entspricht nicht den Vorgaben!");
        }

    }

    public String getName(){return name;}

    /**
     * Überprüft ob Benutzer sich in der Liste befindet
     * @param benutzer , Benutzer der überprüft werden soll.
     * @return true wenn Benutzer schon existiert, false wenn nicht.
     */
    public boolean benutzerVorhanden(Benutzer benutzer)
    {
        if(!name.equals(""))
            dbRead();
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(benutzer))
                return true;
        }
        return false;
    }

    /**
     * Loescht den Benutzer wieder aus der Liste oder aus der serialisierten Datei.
     * @param benutzer gibt an welcher Benutzer gelöscht werden soll
     * @throws UserDoesNotExist , throws wenn Benutzer gar nicht in der Liste existiert.
     */
    public void benutzerLoeschen(Benutzer benutzer)throws UserDoesNotExist{
        if(!benutzerVorhanden(benutzer))
            throw new UserDoesNotExist("Der Benutzer existiert nicht!");
        for(int i=0; i< list.size();i++){
            if(list.get(i).equals(benutzer)){
                list.remove(i);
                if(!name.equals(""))
                    dbWrite();
                break;
            }
        }
    }

    /**
     * Gibt Liste der Benutzer aus
     */
    public void benutzerAusgeben(){
        if(!name.equals(""))
            dbRead();
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }
    }

    /**
     * Legt eine neue leere liste an und serialisiert diese an dem entsprechendem Dateipfad
     */
    public void dbInit(){
        list =new ArrayList<Benutzer>();
        try {
            FileOutputStream fos = new FileOutputStream(dateipfad+name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch(IOException e){
            System.out.println("Fehler bei dbInit");
            e.printStackTrace();
        }
    }

    /**
     * Liest die Liste aus und übergibt diese einer neuen liste
     */
    public void dbRead(){
        list = new ArrayList<Benutzer>();
        try{
            FileInputStream fis = new FileInputStream(dateipfad+name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Benutzer>) ois.readObject();

            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Überschreibt die serialisierte Liste mit der aktuellen Liste
     */
    public void dbWrite(){
        try{
            FileOutputStream fos = new FileOutputStream(dateipfad+name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
