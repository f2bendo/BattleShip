package interfaces.controleurs.positionnementBateau;

import interfaces.vue.PositionnementBateau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearControleur implements ActionListener {

    private PositionnementBateau fenetre;

    public ClearControleur(PositionnementBateau fenetre){
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CLEAR");
    }
}
