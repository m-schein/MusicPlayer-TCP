import soundPlayer.SoundPlayer;
import commandActions.*;
import commandActions.SoundControl.SoundControl;
import enums.SoundCommand;
import org.jfugue.pattern.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class SoundCommandsTest {
    SoundPlayer player = new SoundPlayer();
    ArrayList<Pattern> MusicComposition = new ArrayList<Pattern>();
    SoundControl control = new SoundControl(50, 100, 3,"A",SoundCommand.AGOGO, player.getVocals(), "R", MusicComposition);

    @Test
    @DisplayName("Test Change Instrument Action")
    public void testChangeIntrumentAction(){
        ChangeInstrumentAction changeInstrument = new ChangeInstrumentAction();
        changeInstrument.executeSoundCommand(control,SoundCommand.CHURCH_ORGAN, "");
        assertEquals(String.valueOf(control.getInstrument()), "I[Church_Organ] ");
    }

    @Test
    @DisplayName("Test Change Instrument Action from Int input")
    public void testChangeIntrumentFromIntAction(){
        ChangeInstrumentFromIntAction changeInstrumentFromInt =  new ChangeInstrumentFromIntAction();
        changeInstrumentFromInt.executeSoundCommand(control,SoundCommand.CHURCH_ORGAN, "9");
        assertEquals(String.valueOf(control.getInstrument()), "I[Glockenspiel] ");

        changeInstrumentFromInt.executeSoundCommand(control,SoundCommand.CHURCH_ORGAN, "23");
        assertEquals(String.valueOf(control.getInstrument()), "I[Tango_Accordian] ");

        changeInstrumentFromInt.executeSoundCommand(control,SoundCommand.CHURCH_ORGAN, "89");
        assertEquals(String.valueOf(control.getInstrument()), "I[Warm] ");
    }
    @Test
    @DisplayName("Test add musical note action")
    public void testAddMusicalNoteAction() {
        AddMusicalNoteAction addMusicalNote = new AddMusicalNoteAction();

        addMusicalNote.executeSoundCommand(control, SoundCommand.RE, "D");
        assertEquals(control.getMusicalNote(), "D");
        assertEquals(control.getPreviousMusicalNote(), "D");

        addMusicalNote.executeSoundCommand(control, SoundCommand.SOL, "G");
        assertEquals(control.getMusicalNote(), "G");
        assertEquals(control.getPreviousMusicalNote(), "G");
    }

    @Test
    @DisplayName("Test double volume action")
    public void testDoubleVolumeAction() {
        DoubleVolumeAction doubleVolume = new DoubleVolumeAction();
        doubleVolume.executeSoundCommand(control, SoundCommand.DOUBLE_VOLUME, " ");
        assertEquals(control.getVolume(), 100);
    }

    @Test
    @DisplayName("Test increase octave action")
    public void testIncreaseOctaveAction() {
        IncreaseOctaveAction increaseOctave = new IncreaseOctaveAction();
        increaseOctave.executeSoundCommand(control, SoundCommand.INC_OCTAVE, "?" );
        assertEquals(control.getOctave(), 3);

        increaseOctave.executeSoundCommand(control, SoundCommand.INC_OCTAVE, "." );
        assertEquals(control.getOctave(), 3);
    }

    @Test
    @DisplayName("Test repeat note action")
    public void testRepeatNoteAction(){
        RepeatNoteAction repeatNote = new RepeatNoteAction();
        repeatNote.executeSoundCommand(control, SoundCommand.REPEAT_NOTE, "p");
        assertEquals(control.getPreviousMusicalNote(), "i");
    }
}
