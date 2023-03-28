import org.jfugue.midi.MidiFileManager;
import soundPlayer.SoundPlayer;
import commandActions.Factory.CommandActionFactory;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;
import graphicalView.Components.Button;
import org.jfugue.pattern.Pattern;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
                control.getMusicComposition().forEach(musicSnippet -> { player.getPlayer().play(musicSnippet); System.out.println(musicSnippet);});
                control.resetMusicComposition();
                control.resetVocals();
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
    }

    public void downloadMusicAction(final Button botao) {
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                setContent(getText());
                convertTextIntoCommands(textFieldContent, textFieldContent.length());
                // abre janela para salvar arquivo e salva em .MIDI
                final JFileChooser fileSaver = new JFileChooser();
                final FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo .MIDI", "MIDI");
                fileSaver.setFileFilter(filter);
                fileSaver.setAcceptAllFileFilterUsed(false);
                fileSaver.setFileSelectionMode(JFileChooser.FILES_ONLY);

                if (fileSaver.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    final File MIDIfile = new File(fileSaver.getSelectedFile().getAbsolutePath() + ".MIDI");
                    Pattern concatPattern = new Pattern();
                    control.getMusicComposition().forEach(musicSnippet -> {
                        concatPattern.add(musicSnippet);
                    });
                        try {
                            MidiFileManager.savePatternToMidi(concatPattern, MIDIfile);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                }
                    control.resetMusicComposition();
                    control.resetVocals();
            }
        });
    }
}
