package commandActions.Interface;

import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public interface CommandAction {
    //comando comum em todas as açoes passa no execute
    //parametros para açoes especificas passa no construtor da factory
    void executeSoundCommand(SoundControl soundControl, SoundCommand command, String input);
}
