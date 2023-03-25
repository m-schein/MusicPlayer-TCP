package graphicalView;


import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import graphicalView.Components.Buttons;

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
    private void initializePanels() {

        final JPanel panel1 = new JPanel(null);
        panel1.setBackground(Color.decode("#8473c9"));

//        JPanel panel = new JPanel();
//        JLabel label = new JLabel("Trying to add plain text");
//        label.setBounds(700, 50, 150, 25);
//        label.setFont(new Font("Serif", Font.BOLD, 7));
//        panel.setComponentZOrder(label, 1);
//        label.setForeground(Color.RED);
//        panel.add(label);


        JTextField textBox = new JTextField("Test");
        textBox.setBounds(700, 50, 150, 25);
        panel1.add(textBox);

        final JComboBox<String> instrumentos = new JComboBox<String>();
        instrumentos.addItem("Item 1");
        instrumentos.addItem("Item 2");
        instrumentos.addItem("Item 3");

        instrumentos.setBounds(650, 150, 280, 50);
        panel1.add(instrumentos);

        JTextArea textArea = new JTextArea();
//        scrollPane.setViewportView(textArea);
        final JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 50, 550, 400);
        panel1.add(scrollPane);

        getButtons(panel1, "texto");
        add(panel1);

    }

    private void getButtons(final JPanel painel, final String texto) {
        final Buttons playButton = new Buttons("Play", 185, 475);
//        texto.playAction(playButton);
        painel.add(playButton);

        final Buttons stopButton = new Buttons("Stop", 335, 475);
//        texto.stopAction(stopButton);
        painel.add(stopButton);

        final Buttons importButton = new Buttons("Import", 650, 250);
//        texto.importAction(importButton);
        painel.add(importButton);

        final Buttons exportButton = new Buttons("Export", 800, 250);
//        texto.exportAction(exportButton);
        painel.add(exportButton);

    }
}
