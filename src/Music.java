import enums.SoundCommands;
import org.jfugue.player.Player;
import java.util.Scanner;
import org.jfugue.pattern.Pattern;
public class Music {
    public static void main(String[] args) {
        Player myplayer = new Player();
        Pattern vocals = new Pattern();
        SoundControl control = new SoundControl(50, 100, 'A', SoundCommands.AGOGO, vocals);

        System.out.println("playing default agogo instrument sound");
        vocals.add("Rh G5is E5i Ri | G5s Ris E5q Rs | G5q E5i Rs D5q rs C5h Rs");
        myplayer.play(vocals);

        System.out.println("Write the desired SoundCommands and hit enter to check instrument sound changing");
        Scanner scan= new Scanner(System.in);
        String inputText = scan.nextLine();
        readSpecialCommand(inputText, control);
        myplayer.play(vocals);
        System.out.println(control.getSpecialCommand());
        System.out.println(control.getBPM());

        if(control.getSpecialCommand() == SoundCommands.CHANGE_INSTRUMENT){
            System.out.println("change type of instrument playing");
        }
    }
    public static void readSpecialCommand(String inputText, SoundControl control){
        for (SoundCommands command : SoundCommands.values()) {
            if(inputText.matches(command.getValue())){
                if(command.getCommandType() == 1){
                    control.setSpecialCommand(SoundCommands.valueOf(command.name()));
                    control.setInstrument(command.name());
                }
            }
        }
    }

}
