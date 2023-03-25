import commandActions.Interface.CommandAction;
import commandActions.Factory.CommandActionFactory;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public class CommandReader {
    private final SoundControl soundControl;
    private final CommandActionFactory actionFactory;
    public CommandReader(SoundControl soundControl, CommandActionFactory actionFactory) {
        this.soundControl = soundControl;
        this.actionFactory = actionFactory;
    }
    public void readCommand(String inputText){
        for (SoundCommand command : SoundCommand.values()) {
            if(inputText.matches(command.getValue())){
                final CommandAction action = actionFactory.make(command.getCommandType());
                action.executeSoundCommand(soundControl,command,inputText);
            }
        }
    }
}
