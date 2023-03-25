import commandActions.Factory.CommandActionFactory;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommands;
import graphicalView.Components.Button;
import org.jfugue.pattern.Pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

abstract class Arquivo extends JTextArea {
    String content;
}
public class TextConversor extends Arquivo {
    SoundPlayer player = new SoundPlayer();
    ArrayList<Pattern> MusicComposition = new ArrayList<Pattern>();
    SoundControl control = new SoundControl(50, 100, 3,"A", SoundCommands.AGOGO, player.getVocals(), "R", MusicComposition);
    CommandActionFactory actionFactory = new CommandActionFactory();
    CommandReader commandReader = new CommandReader(control, actionFactory);
    public TextConversor() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setText("");
        setOpaque(true);
        setBackground(Color.decode("#f2f5fc"));
    }
    private void setContent(final String texto) {
        this.content = texto;
    }
    public void playAction(final Button botao) {
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                setContent(getText());
                test(content, content.length());
            }
        });
    }

    public void test(String inputText, Integer inputSize){
        boolean keepReadingCommands = true;

        while (keepReadingCommands) {
            for(final char c : inputText.toCharArray()) {
                if (inputSize == 0) {
                    commandReader.readCommand(String.valueOf(c));
                    keepReadingCommands = false;
                } else {
                    commandReader.readCommand(String.valueOf(c));
                    inputSize -= 1;
                }
            }
        }
        control.getMusicComposition().forEach(musicSnippet -> { player.getPlayer().play(musicSnippet); System.out.println(musicSnippet);});
        control.resetCommands();
    }
}
