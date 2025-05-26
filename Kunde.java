public class Kunde {
    //Datenbanktabelle: kunde

    // Attribute
    String email, telefonnr, nachname, vorname, geburtstag;
    int kid;

    // Konstruktor
    public Kunde() {
        // Standardkonstruktor
    }
    

    public Kunde(String email, String telefonnr, String nachname, String vorname, String geburtstag, int kid) {
        this.email = email;
        this.telefonnr = telefonnr;
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtstag = geburtstag;
        this.kid = kid;
    }

    // Getter und Setter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

  
    

    
    

   

    
}