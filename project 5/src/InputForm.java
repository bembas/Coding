import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InputForm extends JFrame {

    private ArrayList<Tameio> tameia;
    private JPanel panel;
    private JPanel asfalismenoipanel;
    private JList list;
    private JTextField titlosField;
    private JTextField edraField;
    private JTextField nameField;
    private JTextField afmField;
    private JTextField kratiseisField;
    private JTextField apodoxesField;
    private JTextField PmeloiField;
    private JTextField suntakshField;

    private JButton kataxwrisi;
    private JButton ektypwsi;

    public InputForm(ArrayList<Tameio> tameia) {

        this.tameia = tameia;

        panel = new JPanel();
        asfalismenoipanel = new JPanel();

        titlosField = new JTextField("Titlos");
        edraField = new JTextField("Edra");
        nameField = new JTextField("FullName");
        afmField = new JTextField("Afm");
        kratiseisField = new JTextField("Pososto Kratiseon");
        apodoxesField = new JTextField("Apodoxes");
        PmeloiField = new JTextField("Prostateuomena Meloi");
        suntakshField = new JTextField("Suntaksh");
        kataxwrisi = new JButton("Kataxwrisi");
        ektypwsi = new JButton("Ektypwsi");

        GridLayout grid = new GridLayout(5, 2);
        asfalismenoipanel.setLayout(grid);

        asfalismenoipanel.add(nameField);
        asfalismenoipanel.add(afmField);
        asfalismenoipanel.add(kratiseisField);
        asfalismenoipanel.add(apodoxesField);
        asfalismenoipanel.add(PmeloiField);
        asfalismenoipanel.add(suntakshField);
        asfalismenoipanel.add(kataxwrisi);
        asfalismenoipanel.add(ektypwsi);

        DefaultListModel model = new DefaultListModel();
        for (Tameio t : tameia) {
            model.addElement(t.getTitlos());
        }

        list = new JList(model);

        list.setModel(model);


        BorderLayout border = new BorderLayout();
        panel.setLayout(border);

        panel.add(list, BorderLayout.NORTH);
        panel.add(asfalismenoipanel, BorderLayout.CENTER);


        this.setContentPane(panel);

        ButtonListener listener = new ButtonListener();
        kataxwrisi.addActionListener(listener);
        ektypwsi.addActionListener(listener);

        this.setSize(500, 250);
        this.setVisible(true);
        this.setTitle("Input Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            String tameioName = (String) list.getSelectedValue();

            Tameio atameio = null;
            for (Tameio tameio : tameia) {
                if (tameio.getTitlos().equals(tameioName))
                    atameio = tameio;
            }


            if (e.getSource() == kataxwrisi) {

                String name = nameField.getText();
                String afm = afmField.getText();
                String kratiseisText = kratiseisField.getText();
                double kratiseis = Double.parseDouble(kratiseisText);
                String apodoxesText = apodoxesField.getText();
                String PmeloiText = PmeloiField.getText();
                String suntakshText = suntakshField.getText();
                //Elegxo ama to text me tis apodoxes kai ta prostateumena meloi den einai keno tote dhmiourgo ena object gia ton ergazomeno
                //allios and to text me thn suntaksh den einai keno tote dhmiourgo enan suntaksiouxo
                if ((!apodoxesText.equals(""))||(!PmeloiText.equals(""))) {
                    double apodoxes = Double.parseDouble(apodoxesText);
                    int Pmeloi = Integer.parseInt(PmeloiText);
                    Ergazomenoi newAsfalismenos = new Ergazomenoi(name, afm, kratiseis, apodoxes, Pmeloi);
                    atameio.addAsfalismeno(newAsfalismenos);
                }
                if (!suntakshText.equals("")) {
                    double suntakseis = Double.parseDouble(suntakshText);
                    Suntaksiouxoi newAsfalismenos2 = new Suntaksiouxoi(name, afm, kratiseis, suntakseis);
                    atameio.addAsfalismeno(newAsfalismenos2);
                }

                // Blepo se poio tameio kataxorithike (extra)
                System.out.println("Kataxorithike sto Tameio : " + atameio.getTitlos());


            } else {
                // kalo tin klasei getprint i opoia ektuponei auta pou xriazontai gia olous tous asfalismenous pou kataxorithikan
                atameio.GetPrint();
            }

        }
    }

}

