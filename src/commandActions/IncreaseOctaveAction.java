package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public class IncreaseOctaveAction implements CommandAction {
    static final int DEFAULT_OCTAVE = 3;
    static final int MAX_OCTAVE = 9;
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommand command, String input) {
        int curOctave = soundControl.getOctave();
        int newOctave;
        if(curOctave < MAX_OCTAVE) {
            newOctave = curOctave++;
        }
        else {
            newOctave = DEFAULT_OCTAVE;
        }
        soundControl.setOctave(newOctave);
        soundControl.vocals.add("o" + newOctave);
    }
}
