package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public class DoubleVolumeAction implements CommandAction {
    static final int MIN_VOLUME = 15;
    static final int MAX_VOLUME = 75;

    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommand command, String input) {
        int curVolume = soundControl.getVolume();
        int newVolume;
        if(curVolume < MAX_VOLUME) {
            newVolume = curVolume*2;
        }
        else {
            newVolume = MIN_VOLUME;
        }
        soundControl.setVolume(newVolume);
        soundControl.vocals.add("v" + newVolume);
    }
}
