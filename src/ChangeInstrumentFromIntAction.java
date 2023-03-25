import enums.SoundCommands;
import javax.sound.midi.*;

public class ChangeInstrumentFromIntAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommands command, String input) {
        Synthesizer synth;
        int increment = Integer.parseInt(input);
        try {
         synth = MidiSystem.getSynthesizer();
         synth.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            return;
        }
        MidiChannel channel = synth.getChannels()[0];
        int currentInstrument = channel.getProgram();
        int newInstrument = currentInstrument + increment;
        //channel.programChange(newInstrument);
        soundControl.getVocals().setInstrument(newInstrument);

    }
}
