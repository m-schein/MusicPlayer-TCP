import enums.SoundCommands;

import java.util.Scanner;
public class Music {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String inputText = scan.nextLine();

        SoundControl control = new SoundControl(50, 100, "Piano", 'A', SoundCommands.INC_80_BPM);
        readSpecialCommand(inputText, control);


        System.out.println(control.getSpecialCommand());
        System.out.println(control.getBPM());

        if(control.getSpecialCommand() ==  SoundCommands.INC_80_BPM){
            System.out.println("increases BPM in 80");
        }

        if(control.getSpecialCommand() == SoundCommands.CHANGE_INSTRUMENT){
            System.out.println("change type of instrument playing");
        }
    }
    public static void readSpecialCommand(String inputText, SoundControl control){
        for (SoundCommands command : SoundCommands.values()) {
            if(inputText.matches(command.getValue())){
                control.setSpecialCommand(SoundCommands.valueOf(command.name()));
            }
        }
    }

}
