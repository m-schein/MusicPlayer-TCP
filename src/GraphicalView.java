import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import graphicalView.Components.Button;


import javax.swing.*;

public class GraphicalView extends JFrame {
    static final int WIDTH = 650;
    static final int  HEIGHT= 600;

    public GraphicalView() {
        setTitle("Music Player");
        setSize(WIDTH , HEIGHT);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initializePanels();
    }
    public void initializePanels() {

        final JPanel panel = new JPanel(null);
        panel.setBackground(Color.decode("#8473c9"));

        JLabel textBox = new JLabel("Write your music notes in the box below");
        Font font = new Font("Arial", Font.BOLD, 16);
        Color color = Color.BLACK;
        textBox.setFont(font);
        textBox.setForeground(color);
        textBox.setBounds(WIDTH/4, 10, 400, 25);
        panel.add(textBox);

        // input text in the view
        TextFieldInput textFieldInput = new TextFieldInput();
        final JScrollPane scrollPane = new JScrollPane(textFieldInput);
        scrollPane.setBounds(50, 50, 550, 400);
        panel.add(scrollPane);
        getButtons(panel, textFieldInput);
        add(panel);
    }

    public void getButtons(final JPanel panel,TextFieldInput textFieldInput) {
        final Button playButton = new Button("Play music", 260, 475);
        panel.add(playButton);
        textFieldInput.playMusicAction(playButton);
    }
}
