package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommands;

public class ChangeInstrumentAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command, String input) {
        soundControl.setInstrument(command.name());
        soundControl.setSoundCommand(command);
    }
}
