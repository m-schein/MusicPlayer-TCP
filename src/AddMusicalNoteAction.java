import enums.SoundCommands;

public class AddMusicalNoteAction implements CommandAction{
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command, String input) {
        String musicalNote = command.getValue().replace('(', ' ').replace(')', ' ').trim();
        soundControl.getVocals().add(musicalNote);
        soundControl.setPreviousMusicalNote(musicalNote);
    }
}
