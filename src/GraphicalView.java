import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import graphicalView.Components.Button;


import javax.swing.*;

public class GraphicalView extends JFrame {
    static final int WIDTH = 960;
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

        final JPanel panel1 = new JPanel(null);
        panel1.setBackground(Color.decode("#8473c9"));

        JTextArea textBox = new JTextArea();
        textBox.setBounds(700, 50, 150, 25);
        panel1.add(textBox);

        final JComboBox<String> instrumentos = new JComboBox<String>();
        instrumentos.addItem("Item 1");
        instrumentos.addItem("Item 2");
        instrumentos.addItem("Item 3");

        instrumentos.setBounds(650, 150, 280, 50);
        panel1.add(instrumentos);

        // input text in the view
        TextConversor inputTextBox = new TextConversor();
        final JScrollPane scrollPane = new JScrollPane(inputTextBox);
        scrollPane.setBounds(50, 50, 550, 400);
        panel1.add(scrollPane);
        getButtons(panel1, inputTextBox);
        add(panel1);

    }

    public void getButtons(final JPanel painel, TextConversor inputTextBox) {
        final Button playButton = new Button("Play", 185, 475);
        painel.add(playButton);
        inputTextBox.playAction(playButton);

        final Button stopButton = new Button("Stop", 335, 475);
//        texto.stopAction(stopButton);
        painel.add(stopButton);

        final Button importButton = new Button("Import", 650, 250);
//        texto.importAction(importButton);
        painel.add(importButton);

        final Button exportButton = new Button("Export", 800, 250);
//        texto.exportAction(exportButton);
        painel.add(exportButton);

    }
}
