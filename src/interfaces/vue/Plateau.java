package interfaces.vue;


import interfaces.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Plateau extends JFrame{


    private JButton help;
    private JButton setting;
    private PlateauImageComponent[][] listCase;

    public Plateau(String titre, PositionnementBateau positionnementBateau){
        super(titre);

        listCase = new PlateauImageComponent[10][];

        for (int i = 0; i < 10; i++){
            listCase[i] = new PlateauImageComponent[10];
        }

        JPanel plateau = new JPanel();
        plateau.setLayout(new BorderLayout());

        JPanel nord = new JPanel();
        nord.setLayout(new FlowLayout(FlowLayout.RIGHT));

        setting = new JButton("Setting");
        help = new JButton("Help");

        nord.add(setting);
        nord.add(help);



        JPanel sud = new JPanel();
        sud.setLayout(new FlowLayout());
        JLabel texte = new JLabel("Bateaux restants :                 ");
        JLabel texte1 = new JLabel("Touché(s) :                       ");
        JLabel texte3 = new JLabel("Fail(s) :                          ");

        sud.add(texte);
        sud.add(texte1);
        sud.add(texte3);

        JPanel east = new JPanel();
        east.setLayout(new GridLayout(10,10));

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                ImageShowingComponent img = new ImageShowingComponent(new int[]{x,y}, null, null);

                east.add(img);
            }
        }
        JPanel center =  new JPanel();
        center.setLayout(new GridLayout(10,10));

        for (int x=0; x<10; x++){
            for (int y=0; y<10; y++){

                PlateauImageComponent img = new PlateauImageComponent(new int[]{x,y}, this, positionnementBateau);

                listCase[x][y] = img;
                center.add(img);
            }
        }

        JPanel centre = new JPanel();
        JLabel score = new JLabel(" 0 : 0");
        centre.add(score);
        plateau.add(centre,BorderLayout.CENTER);


        center.setBorder(BorderFactory.createTitledBorder("Vos bateaux : "));
        east.setBorder(BorderFactory.createTitledBorder("Ciblage : "));

        plateau.add((sud),BorderLayout.SOUTH);
        plateau.add(nord,BorderLayout.NORTH);
        plateau.add(east,BorderLayout.EAST);
        plateau.add(center,BorderLayout.WEST);









        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200,700));
        this.setContentPane(plateau);


    }

    public void fixeListenerSettings(ActionListener action){
        setting.addActionListener(action);
    }

    public void fixeListenerHelp(ActionListener action){
        help.addActionListener(action);
    }

    public PlateauImageComponent[][] getCaselist() {
        return this.listCase;
    }


}
