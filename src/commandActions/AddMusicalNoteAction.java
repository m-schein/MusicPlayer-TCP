package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;

public class AddMusicalNoteAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommand command, String musicalNote) {
        soundControl.getVocals().add(musicalNote);
        soundControl.setPreviousMusicalNote(musicalNote);
    }
}
