import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MediumDAO {
    public void speichereMedium(Medium medium){

        String sql = "INSERT INTO medium (titel, herausgeber, kategorie, gebuehr)  VALUES (?, ?, ?, ?);";

        try (Connection conn = DatabaseConnector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medium.getTitel());
            stmt.setString(2, medium.getHerausgeber());
            stmt.setString(3, medium.getKategorie());
            stmt.setDouble(4, medium.getGebuehr());

            stmt.executeUpdate();
            System.out.println("Medium erfolgreich gespeichert!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Das Medium konnte leider nicht gespeichert werden.");
        }
    }//end speichereBestellung()

    public boolean existiertID(int id){
        String sql = "SELECT 1 FROM medium WHERE id = ? LIMIT 1";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();  // true wenn mindestens 1 Ergebnis da ist
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void bearbeiteMedium(Medium medium, int id){
        String sql = "UPDATE medium SET titel = ?, herausgeber =? , kategorie = ?, gebuehr =? WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medium.getTitel());
            stmt.setString(2, medium.getHerausgeber());
            stmt.setString(3, medium.getKategorie());
            stmt.setDouble(4, medium.getGebuehr());
            stmt.setInt(5, id);

            stmt.executeUpdate();
            System.out.println("Medium erfolgreich bearbeitet!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Das Medium konnte leider nicht bearbeitet werden.");
        }

    }
}