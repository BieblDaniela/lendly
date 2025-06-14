import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KundenkontoBearbeiten extends JFrame{
    //attribute
    JButton btn_Speichern,btn_Zurueck;
    JLabel lbl_Vorname, lbl_Nachname, lbl_Geburtsdatum, lbl_Email, lbl_Telefonnummer, lbl_Info, lbl_kid;
    JTextField txt_Vorname, txt_Nachname, txt_Geburtsdatum, txt_Email, txt_Telefonnummer, txt_kid;


    public KundenkontoBearbeiten(){
        setTitle("Kundenkonto erstellen");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridBagLayout());
        

        initComponents();

        
        setVisible(true);
    }
    private void initComponents() {

        
        GridBagConstraints c = new GridBagConstraints();
        setLocationRelativeTo(null); //Fenster zentrieren

        Dimension buttonSize = new Dimension(180, 30);


        // KID eingabe
        lbl_kid = new JLabel("Kunden-ID");
        c.gridx = 0; //spalte
        c.gridy = 0; //zeile
        c.gridwidth = 1;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(lbl_kid, c);

        c.gridx = 1;
        txt_kid = new JTextField(10);
        add(txt_kid, c);

        // Info-Text
        lbl_Info = new JLabel("In diesem Fenster können Sie ein Kundenkonto erstellen");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        //c.anchor = GridBagConstraints.WEST; // Linksbündig
        lbl_Info.setHorizontalAlignment(JLabel.LEFT);
        add(lbl_Info, c);

        // Vorname
        lbl_Vorname = new JLabel("Vorname");
        c.gridwidth = 1;
        c.gridx = 0; //spalte
        c.gridy = 2;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(lbl_Vorname, c);

        c.gridx = 1;
        txt_Vorname = new JTextField(10);
        add(txt_Vorname, c);

        // Nachname
        lbl_Nachname = new JLabel("Nachname");
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(lbl_Nachname, c);

        
        c.gridx = 3;
        txt_Nachname = new JTextField(10);
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(txt_Nachname, c);

        // Geburtsdatum
        lbl_Geburtsdatum = new JLabel("Geburtsdatum");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(lbl_Geburtsdatum, c);

        c.gridx = 1;
        txt_Geburtsdatum = new JTextField(10);
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(txt_Geburtsdatum, c);

        // E-Mail
        lbl_Email = new JLabel("E-Mail");
        c.gridx = 2;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(lbl_Email, c);

        c.gridx = 3;
        txt_Email = new JTextField(10);
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(txt_Email, c);

        // Telefonnummer
        lbl_Telefonnummer = new JLabel("Telefonnummer");
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(lbl_Telefonnummer, c);

        c.gridx = 1;
        txt_Telefonnummer = new JTextField(10);
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(txt_Telefonnummer, c);

        // Speichern-Button (
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 4;
        c.anchor = GridBagConstraints.WEST; // Linksbündig
        btn_Speichern = new JButton("Speichern");
        btn_Speichern.setPreferredSize(buttonSize);
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        add(btn_Speichern, c);

        // Untere Buttons
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.anchor = GridBagConstraints.EAST; // Rechtsbündig
        c.insets = new Insets(5, 10, 5, 10); // Abstand
        btn_Zurueck = new JButton("Zurück zum Hauptmenü");
        btn_Zurueck = new JButton("Zurück zum Hauptmenü");
        add(btn_Zurueck, c);


        //ActionListener für die Buttons hinzufügen
        MyActionListener mylistener = new MyActionListener();
        btn_Speichern.addActionListener(mylistener);
        btn_Zurueck.addActionListener(mylistener);

    } 

   
    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_Speichern) {
                try {
                    int kundenID = Integer.parseInt(txt_kid.getText());
                    // Weiterverarbeitung...
                    // Logik zum Speichern des Kundenkontos
                // Die Daten aus dem Formular sollen in einem Bestellung-Objekt gespeichert
                // werden
                // (String name, String sorte, int anzahl, boolean abholer, BigDecimal preis)

                String vorname = txt_Vorname.getText();
                String nachname = txt_Nachname.getText();
                String email = txt_Email.getText();
                String telefonnr = txt_Telefonnummer.getText();
                String geburtstag = txt_Geburtsdatum.getText();

                //neue Bestellung erstellen
                //Daten aus dem Formular in einem Bestell Objekt speichern
                Kunde neuerKunde = new Kunde(vorname, nachname, email, telefonnr, geburtstag);

                //Weiterleiten des Bestellobjekts and die Klasse Bestellung DAO
                KundenkontoDAO dao = new KundenkontoDAO();
                //Die Klasse BestellungDaO sorgt dafür, dass die DAten aus dem Bestellobjekt 
                //In die Datenbank übertragen werden (INSERT INTO ....)
                dao.speichereKunde(neuerKunde);
            
                

                // Bestätigung anzeigen
               // JOptionPane.showMessageDialog(KundenkontoErstellenGUI.this, 
                   // "Kundenkonto erfolgreich erstellt!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bitte eine gültige Kunden-ID eingeben (nur Zahlen).");
               
                }
                
            } else if (e.getSource() == btn_Zurueck) {
                // Logik zum Zurückkehren zum Hauptmenü
                dispose(); // Schließt das aktuelle Fenster
                
            }
        }
        

    }
         
}
