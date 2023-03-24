import enums.SoundCommands;
import org.jfugue.pattern.Pattern;
public class SoundControl {

    private int volume;
    private int BPM;
    private int octave;
    private String musicalNote;
    public Pattern vocals;
    public SoundCommands soundCommand;
    public String previousNote;

    public SoundControl(int volume, int BPM, int octave, String musicalNote, SoundCommands soundCommand, Pattern vocals, String previousNote) {
        this.volume = volume;
        this.BPM = BPM;
        this.octave = octave;
        this.musicalNote = musicalNote;
        this.soundCommand = soundCommand;
        this.vocals = vocals;
        this.vocals.setInstrument(soundCommand.name()); //set default instrument (AGOGO)
        this.previousNote = previousNote;
    }
    public Pattern getVocals(){
        return this.vocals;
    }
    public void setVocals(Pattern vocals){
        this.vocals = vocals;
    }

    public int getVolume(){
        return this.volume;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }

    public int getBPM(){
        return this.BPM;
    }
    public void setBPM(int BPM){
        this.BPM = BPM;
    }

    public int getOctave() { return this.octave; }
    public void setOctave(int octave) { this.octave = octave; }

    public Pattern getInstrument(){
        return this.vocals.getPattern();
    }
    public void setInstrument(String instrument){
        this.vocals = vocals.setInstrument(instrument);
    }

    public String getMusicalNote(){
        return this.musicalNote;
    }
    public void setMusicalNote(String musicalNote){
        this.musicalNote = musicalNote;
    }
    public String getPreviousMusicalNote(){
        return this.musicalNote;
    }
    public void setPreviousMusicalNote(String musicalNote){
        this.musicalNote = musicalNote;
    }

    public SoundCommands getSoundCommand() {
        return soundCommand;
    }
    public void setSoundCommand(SoundCommands soundCommand) {
        this.soundCommand = soundCommand;
    }
}
