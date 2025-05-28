import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MediumDAO {
    public void speichereMedium(Medium medium){

        String sql = "INSERT INTO medium (titel, herausgeber, kategorie, gebuehr)  VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            //2. Schritt: Stmt mit Werten verknüpfen - für jedes Fragezeichen muss ein Wert mitgeschickt
            //            werden.
            // ACHTUNG, je nach Typ muss die richtige Setter-Funktion genutzt werden.
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
}
