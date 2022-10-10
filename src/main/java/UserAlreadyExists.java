/**
 * Exception wenn der Benutzer schon existiert.
 */
public class UserAlreadyExists extends Exception{
    UserAlreadyExists(String S){super(S);}
}
