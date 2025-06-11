import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AusleihenDAO {

    public void speichereAusleihen(Ausleihen ausleihen){

        String sql = "INSERT INTO ausleihen (mid,kid, dauer)  VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, ausleihen.getMid());
                stmt.setInt(2, ausleihen.getKid());
                stmt.setString(3, ausleihen.getDauer());
            
                stmt.executeUpdate();
                System.out.println("Ausleihen erfolgreich gespeichert!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Die Bestellung konnte leider nicht gespeichert werden.");
        }
    }y
}
