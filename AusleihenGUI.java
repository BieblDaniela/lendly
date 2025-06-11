import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        c.gridwidth = 2;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_dauer, c);

        ButtonGroup dauer = new ButtonGroup();
        opt_7 = new JRadioButton("7 Tage");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(opt_7,c);

        opt_14 = new JRadioButton("14 Tage");
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(opt_14,c);

        opt_21 = new JRadioButton("21 Tage");
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(opt_21,c);

        opt_28 = new JRadioButton("28 Tage");
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(opt_28,c);

        dauer.add(opt_7);
        dauer.add(opt_14);
        dauer.add(opt_21);
        dauer.add(opt_28);

        //Buttons
        MyActionListener mylistener = new MyActionListener();

        btn_ausleihen = new JButton("Ausleihen");
        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 5, 10);
        this.add(btn_ausleihen, c);
        btn_ausleihen.addActionListener(mylistener);

        btn_hauptmenue = new JButton("Bestellen");
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(10, 0, 5, 10);
        this.add(btn_hauptmenue, c);
        btn_hauptmenue.addActionListener(mylistener);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e){
                new StartGUI();
            }
        });
        
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    
        
    }
    
}