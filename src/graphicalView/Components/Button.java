package graphicalView.Components;

import javax.swing.*;

public class Button extends JButton {
    public Button(String nome, int x, int y) {
        setText(nome);
        setHorizontalAlignment(CENTER);
        setBounds(x, y, 130, 45);
    }
}
