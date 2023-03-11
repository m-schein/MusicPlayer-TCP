import enums.SoundCommands;

public class ChangeInstrumentAction implements  CommandAction{
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command) {
        soundControl.setSoundCommand(command);
        soundControl.setInstrument(command.name());
    }
}
