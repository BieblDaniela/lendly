import javax.swing.*;
import java.awt.*;

public class AusleihenGUI extends JFrame {

    JLabel lbl_ueberschrift, lbl_kid, lbl_mid, lbl_dauer;
    JTextField txt_kid, txt_mid;
    JRadioButton opt_7, opt_14, opt_21, opt_28;
    JButton btn_ausleihen, btn_hauptmenue;

    public AusleihenGUI(){
        this.setTitle("Medium Ausleihen");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();

        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Überschrift
        lbl_ueberschrift = new JLabel("Hier können Sie ein Medium ausleihen");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 10, 10);
        this.add(lbl_ueberschrift, c);

        //kid & mid eingabe
        lbl_kid = new JLabel("KundenID:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth =1;
        c.gridheight = 1;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_kid, c);

        txt_kid = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_kid,c);

        lbl_mid = new JLabel("MedienID:");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_mid, c);

        txt_mid = new JTextField(10);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_mid, c);

        //Dauer
        lbl_dauer = new JLabel("Wie lange wollen Sie das Medium ausleihen?");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_dauer, c);

        ButtonGroup dauer = new ButtonGroup();
        opt_7 = new JRadioButton("7 Tage");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(opt_7,c);
        
    }
    
}