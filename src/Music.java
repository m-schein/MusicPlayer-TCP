import commandActions.Factory.CommandActionFactory;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommands;
import org.jfugue.pattern.Pattern;

import java.util.ArrayList;
import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        SoundPlayer player = new SoundPlayer();
        ArrayList<Pattern> MusicComposition = new ArrayList<Pattern>();
        SoundControl control = new SoundControl(50, 100, 3,"A", SoundCommands.AGOGO, player.getVocals(), "R", MusicComposition);
        CommandActionFactory actionFactory = new CommandActionFactory();
        CommandReader commandReader = new CommandReader(control, actionFactory);

        System.out.println("Write the desired SoundCommands and hit enter to check instrument sound changing");
        Scanner userInput = new Scanner(System.in);
        boolean keepReadingCommands = true;

        while (keepReadingCommands) {
            String inputText = userInput.nextLine();
            for(final char c : inputText.toCharArray()) {
                if (c == 'x') {
                    commandReader.readCommand(String.valueOf(c));
                    keepReadingCommands = false;
                    break;
                } else {
                    commandReader.readCommand(String.valueOf(c));
                }
            }
        }
        control.getMusicComposition().forEach(musicSnippet -> { player.getPlayer().play(musicSnippet); System.out.println(musicSnippet);});
    }

}
