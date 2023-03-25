package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommands;

public class AddMusicalNoteAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command, String musicalNote) {
        soundControl.getVocals().add(musicalNote);
        soundControl.setPreviousMusicalNote(musicalNote);
    }
}
