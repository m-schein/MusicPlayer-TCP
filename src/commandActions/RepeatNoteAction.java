package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public class RepeatNoteAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommand command, String input) {
        String previousNote = soundControl.getPreviousMusicalNote();
        if(previousNote.matches("[ABCDEFG]")){
            soundControl.getVocals().add(previousNote);
            soundControl.setPreviousMusicalNote("i"); //set previous note as some note that doesn't exist
        }else{
            soundControl.getVocals().add("R"); //adds a REST, aka 'pause' in the music
        }
    }
}
