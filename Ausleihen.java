public class Ausleihen {
     
    private int kid;
    private int mid;
    private String dauer;
    
    public Ausleihen(int kid, int mid, String dauer) {
        this.kid = kid;
        this.mid = mid;
        this.dauer = dauer;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getDauer() {
        return dauer;
    }

    public void setDauer(String dauer) {
        this.dauer = dauer;
    }

    
}
