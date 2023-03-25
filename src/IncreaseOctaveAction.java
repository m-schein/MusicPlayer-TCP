import enums.SoundCommands;

public class IncreaseOctaveAction implements CommandAction {
    static final int DEFAULT_OCTAVE = 3;
    static final int MAX_OCTAVE = 9;
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command) {
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
