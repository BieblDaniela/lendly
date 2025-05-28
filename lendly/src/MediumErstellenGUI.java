import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MediumErstellenGUI extends JFrame{

    JLabel lbl_ueberschrift, lbl_titel, lbl_herausgeber, lbl_medium, lbl_gebuehren;
    JTextField txt_titel, txt_herausgeber, txt_gebuehren;
    JComboBox<String> cbo_medium;
    JButton btn_speichern, btn_hauptmenue;

    final String Buch = "Buch";
    final String Film = "Film";
    final String Serien = "Serien";

    public MediumErstellenGUI() {
        this.setTitle("Medium erstellen");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();

        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        //Überschrift
        JLabel lbl_ueberschrift  = new JLabel("Hier können Sie ein Medium erstellen.");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2; 
        c.gridheight = 1; 
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(20, 10, 10, 10);
        this.add(lbl_ueberschrift, c);

        //Titel
        JLabel lbl_titel = new JLabel("Titel:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1; 
        c.gridheight = 1; 
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_titel, c);

        JTextField txt_titel = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_titel, c);

        //Mediumart
        JLabel lbl_medium = new JLabel("Mediumart:");
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_medium,c);

        String[] medium = {Buch, Film, Serien};
        JComboBox<String> cbo_medium = new JComboBox<>(medium);
        c.gridx = 3;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(cbo_medium, c);

        //Herausgeber
        JLabel lbl_herausgeber = new JLabel("Herausgeber:");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_herausgeber, c);

        JTextField txt_herausgeber = new JTextField(15);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_herausgeber,c);

        //Gebühr
        JLabel lbl_gebuehren = new JLabel("Gebühren/Wocher:");
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_gebuehren,c);

        JTextField txt_gebuehren = new JTextField(15);
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_gebuehren,c);

        //Buttons
        MyActionListener mylistener = new MyActionListener();

        JButton btn_speichern = new JButton("Speichern in DB");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 15, 10);
        this.add(btn_speichern, c);
        btn_speichern.addActionListener(mylistener);
        
        JButton btn_hauptmenue = new JButton("Zurück zum Hauptmenü");
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 15, 10);
        this.add(btn_hauptmenue, c);
        btn_hauptmenue.addActionListener(mylistener);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e){
                //new StartGUI();
            }
        });
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_speichern) {
                System.out.println("test");
                String titel = txt_titel.getText();
                String herausgeber = txt_herausgeber.getText();
                Double gebuehren = Double.parseDouble(txt_gebuehren.getText());
                String kategorie = cbo_medium.getSelectedItem().toString();

                Medium neuesMedium = new Medium(titel, herausgeber, kategorie, gebuehren);

                MediumDAO dao = new MediumDAO();
                dao.speichereMedium(neuesMedium);

            }else if (e.getSource() == btn_hauptmenue) {
                dispose();
                //new StartGUI;
            }
        }
    
        
    }
    
}