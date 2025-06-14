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
                JOptionPane.showMessageDialog(null, "Medium wurde ausgeliehen.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Medium konnte nicht ausgeliehen werden.");
        }
    }

    public void zuerueckgebenAusleihen(int kid, int mid){

        String sql = "DELETE FROM ausleihen WHERE ;";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Medium wurde zurückgegeben.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Medium konnte nicht zurückgegeben werden.");
        }
    }
}
