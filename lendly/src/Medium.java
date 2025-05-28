public class Medium {

    private String titel;
    private String herausgeber;
    private String kategorie;
    private double gebuehr;
    
    public Medium(String titel, String herausgeber, String kategorie, double gebuehr) {
        this.titel = titel;
        this.herausgeber = herausgeber;
        this.kategorie = kategorie;
        this.gebuehr = gebuehr;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getHerausgeber() {
        return herausgeber;
    }

    public void setHerausgeber(String herausgeber) {
        this.herausgeber = herausgeber;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public double getGebuehr() {
        return gebuehr;
    }

    public void setGebuehr(double gebuehr) {
        this.gebuehr = gebuehr;
    }

    
}
