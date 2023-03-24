import enums.SoundCommands;
import org.jfugue.player.Player;
import java.util.Scanner;
import org.jfugue.pattern.Pattern;
public class Music {
    public static void main(String[] args) {
        ///classe programa para instanciar todas as classes necessárias no main
        //o q nao da pra testar deixar no main

        SoundPlayer player = new SoundPlayer();
        SoundControl control = new SoundControl(50, 100, 3, "A", SoundCommands.AGOGO, player.getVocals(), "R");
        CommandActionFactory actionFactory = new CommandActionFactory();
        
        System.out.println("Write the desired SoundCommands and hit enter to check instrument sound changing");
        Scanner userInput = new Scanner(System.in);
        String inputText = userInput.nextLine();
        boolean keepAddingCommands = true;
        while (keepAddingCommands) {
            if (inputText.equals("x")) {
                keepAddingCommands = false;
                break;
            } else {
                System.out.println("write next command:");
                new CommandReader(control, actionFactory).readCommand(inputText);
                inputText = userInput.nextLine();
            }
        }
        player.getPlayer().play(player.getVocals());
    }

}
