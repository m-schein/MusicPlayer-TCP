package graphicalView.Components;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

public class Buttons extends JButton {
    public Buttons(String nome, int x, int y) {
        setText(nome);
        setHorizontalAlignment(CENTER);
        setBounds(x, y, 130, 45);
    }
}
