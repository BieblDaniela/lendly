import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class StartGUI extends JFrame{
    
    JLabel lbl_kunden, lbl_ausleihen, lbl_medium;
    JButton btn_kk, btn_kb, btn_me, btn_mb, btn_ausleihen, btn_zurueckgeben;

    public StartGUI(){
        this.setTitle("Start");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //Kundenverwaltung
        lbl_kunden = new JLabel("Kundenverwaltung");
        lbl_kunden.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = 2; 
        c.gridheight = 1; 
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(10, 10, 5, 10);
        this.add(lbl_kunden, c);

        this.btn_kk = new JButton("Kundenkonto erstellen");
        btn_kk.setPreferredSize(new Dimension(190,30));
        btn_kk.addActionListener(e -> {
            this.setVisible(false);
            //new KundenkontoErstellen();
        });
        c.gridx = 0;
        c.gridy = 1; 
        c.gridwidth = 1; 
        c.gridheight = 1; 
        c.insets = new Insets(10, 10, 5, 10);
        this.add(btn_kk,c);


        this.btn_kb = new JButton("Kundenkonto bearbeiten");
        btn_kb.setPreferredSize(new Dimension(190,30));
        btn_kb.addActionListener(e ->{
            this.setVisible(false);
            //new KundenkontoBearbeiten();
        });
        c.gridx = 1;
        c.gridy = 1; 
        c.insets = new Insets(10, 0, 5, 10);
        this.add(btn_kb,c);

        //Medienverwaltung
        lbl_medium = new JLabel("Medienverwaltung");
        lbl_medium.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0; 
        c.gridy = 2; 
        c.gridwidth = 2; 
        c.gridheight = 1; 
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(10, 10, 5, 10);
        this.add(lbl_medium, c);

        this.btn_me = new JButton("Medium erstellen");
        btn_me.setPreferredSize(new Dimension(190,30));
        btn_me.addActionListener(e -> {
            this.setVisible(false);
            //new MediumErstellen();
        });
        c.gridx = 0;
        c.gridy = 3; 
        c.gridwidth = 1; 
        c.gridheight = 1; 
        c.insets = new Insets(10, 10, 5, 10);
        this.add(btn_me,c);


        this.btn_mb = new JButton("Medium bearbeiten");
        btn_mb.setPreferredSize(new Dimension(190,30));
        btn_mb.addActionListener(e ->{
            this.setVisible(false);
            //new Mediumbearbeiten();
        });
        c.gridx = 1;
        c.gridy = 3; 
        c.insets = new Insets(10, 0, 5, 10);
        this.add(btn_mb,c);

        //Ausleihvorgänge
        lbl_ausleihen = new JLabel("Ausleihvorgänge");
        lbl_ausleihen.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0; 
        c.gridy = 4; 
        c.gridwidth = 2; 
        c.gridheight = 1; 
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(10, 10, 5, 10);
        this.add(lbl_ausleihen, c);

        this.btn_ausleihen = new JButton("Ausleihen");
        btn_ausleihen.setPreferredSize(new Dimension(190,30));
        btn_ausleihen.addActionListener(e -> {
            this.setVisible(false);
            //new Ausleihen();
        });
        c.gridx = 0;
        c.gridy = 5; 
        c.gridwidth = 1; 
        c.gridheight = 1; 
        c.insets = new Insets(10, 10, 10, 10);
        this.add(btn_ausleihen,c);


        this.btn_zurueckgeben = new JButton("Zurückgeben");
        btn_zurueckgeben.setPreferredSize(new Dimension(190,30));
        btn_ausleihen.addActionListener(e ->{
            this.setVisible(false);
            //new Zurückgeben();
        });
        c.gridx = 1;
        c.gridy = 5; 
        c.insets = new Insets(10, 0, 10, 10);
        this.add(btn_zurueckgeben,c);
    }
}
