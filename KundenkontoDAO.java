import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class KundenkontoDAO {     
    
    //Methode, die ein Bestellobjekt in die Datenbank speichert!

    public void speichereKunde(Kunde kunde) {

        String sql = "INSERT INTO kunde (vorname, nachname, email, telefonnr, geburtstag)  VALUES (?, ?, ?, ?, ?)";

        //1. Schritt: Verbindung aufbauen
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //2. Schritt: Stmt mit Werten verknüpfen - für jedes Fragezeichen muss ein Wert mitgeschickt
            //            werden.
            // ACHTUNG, je nach Typ muss die richtige Setter-Funktion genutzt werden.
            stmt.setString(1, kunde.getVorname());
            stmt.setString(2, kunde.getNachname());
            stmt.setString(3, kunde.getEmail());
            stmt.setString(4, kunde.getTelefonnr());
            stmt.setString(5, kunde.getGeburtstag());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kundenkonto wurde gespeichert.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kundenkonto konnte nicht gespeichert werden.");
        }

    } //end speichereBestellung

    public void bearbeiteKunden(Kunde kunde, int id){
        String sql = "UPDATE medium SET vorname = ?, nachname =? , email = ?, telefonnr =?, geburtstag = ? WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, kunde.getVorname());
            stmt.setString(2, kunde.getNachname());
            stmt.setString(3, kunde.getEmail());
            stmt.setString(4, kunde.getTelefonnr());
            stmt.setString(5, kunde.getGeburtstag());
            stmt.setInt(6, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kundenkonto wurde bearbeitet.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kundenkonto konnte nicht bearbeitet werden.");
        }

    }

}
