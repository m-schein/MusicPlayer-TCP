package commandActions;

import commandActions.Interface.CommandAction;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;
import javax.sound.midi.*;

public class ChangeInstrumentFromIntAction implements CommandAction {
    @Override
    public void executeSoundCommand(SoundControl soundControl, SoundCommand command, String input) {
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

        soundControl.setInstrumentByMIDINumber(newInstrument);

    }
}
