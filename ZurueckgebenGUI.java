import javax.swing.JButton;
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

public class ZurueckgebenGUI extends JFrame {

    JLabel lbl_ueberschrift, lbl_kid, lbl_mid;
    JTextField txt_kid, txt_mid;
    JButton btn_zurueckgeben, btn_hauptmenue;

    public ZurueckgebenGUI() {
        this.setTitle("Medium zurückgeben");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();

        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout (new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        //Überschrift
        lbl_ueberschrift  = new JLabel("In diesem Fenster können Sie ihre ausgeliehenen Medien zurückgeben.");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2; 
        c.gridheight = 1; 
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(20, 10, 10, 10);
        this.add(lbl_ueberschrift, c);

        //KID
        lbl_kid  = new JLabel("KundenID:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1; 
        c.gridheight = 1; 
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_kid, c);

        txt_kid = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1; 
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_kid, c);

        //MID
        lbl_mid  = new JLabel("MediumID:");
        c.gridx = 0;
        c.gridy = 2; 
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_mid, c);

        txt_mid = new JTextField(15);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_mid, c);

        //Buttons
        MyActionListener mylistener = new MyActionListener();

        btn_zurueckgeben = new JButton("Zurückgeben");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 15, 10);
        this.add(btn_zurueckgeben, c);
        btn_zurueckgeben.addActionListener(mylistener);

        btn_hauptmenue = new JButton("Zurück zum Hauptmenü");
        c.gridx = 1;
        c.gridy = 3;
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
            if (e.getSource() == btn_zurueckgeben) {

                int kid = Integer.parseInt(txt_kid.getText());
                int mid = Integer.parseInt(txt_mid.getText());

                AusleihenDAO dao = new AusleihenDAO();

                dao.zuerueckgebenAusleihen(kid, mid);
                
            }else if (e.getSource() == btn_hauptmenue) {
                dispose();
                //new StartGUI;
            }
        }   
    }  
}