import enums.SoundCommands;

public class ChangeInstrumentAction implements  CommandAction{
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command) {
        soundControl.setInstrument(command.name());
        soundControl.setSoundCommand(command);
    }
}
