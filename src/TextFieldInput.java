import soundPlayer.SoundPlayer;
import commandActions.Factory.CommandActionFactory;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;
import graphicalView.Components.Button;
import org.jfugue.pattern.Pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TextFieldInput extends JTextArea {
    SoundPlayer player = new SoundPlayer();
    ArrayList<Pattern> MusicComposition = new ArrayList<Pattern>();
    SoundControl control = new SoundControl(50, 100, 3,"A", SoundCommand.AGOGO, player.getVocals(), "R", MusicComposition);
    CommandActionFactory actionFactory = new CommandActionFactory();
    CommandReader commandReader = new CommandReader(control, actionFactory);
    Font font = new Font("Arial", Font.PLAIN, 20);
    String textFieldContent;
    public TextFieldInput() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setText("");
        setOpaque(true);
        setBackground(Color.decode("#f2f5fc"));
        setFont(font);
    }
    private void setContent(final String text) {
        this.textFieldContent = text;
    }
    public void playMusicAction(final Button botao) {
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                setContent(getText());
                convertTextIntoCommands(textFieldContent, textFieldContent.length());
            }
        });
    }

    public void convertTextIntoCommands(String inputText, Integer inputSize){
        boolean keepReadingCommands = true;
        while (keepReadingCommands) {
            for(final char c : inputText.toCharArray()) {
                if (inputSize == 0) {
                    control.setMusicComposition(control.vocals);
                    keepReadingCommands = false;
                    break;
                } else {
                    commandReader.readCommand(String.valueOf(c));
                    inputSize -= 1;
                }
            }
        }
        control.getMusicComposition().forEach(musicSnippet -> { player.getPlayer().play(musicSnippet); System.out.println(musicSnippet);});
        control.resetMusicComposition();
        control.resetVocals();
    }
}
