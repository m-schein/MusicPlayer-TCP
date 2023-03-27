package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public class ChangeInstrumentAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommand command, String input) {
        soundControl.setInstrumentByName(command.name());
        soundControl.setSoundCommand(command);
    }
}
