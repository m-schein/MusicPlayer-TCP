import enums.SoundCommands;
import org.jfugue.pattern.Pattern;
public class SoundControl {

    private int volume;
    private int BPM;
    private char musicalNote;
    public Pattern vocals;
    public SoundCommands specialCommand;

    public SoundControl(int volume, int BPM, char musicalNote, SoundCommands specialCommand, Pattern vocals) {
        this.volume = volume;
        this.BPM = BPM;
        this.musicalNote = musicalNote;
        this.specialCommand = specialCommand;
        this.vocals = vocals;
        this.vocals.setInstrument(specialCommand.name()); //set default instrument (AGOGO)
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

    public Pattern getInstrument(){
        return this.vocals.getPattern();
    }
    public void setInstrument(String instrument){
        this.vocals = vocals.setInstrument(instrument);
    }

    public char getMusicalNote(){
        return this.musicalNote;
    }
    public void setMusicalNote(char musicalNote){
        this.musicalNote = musicalNote;
    }

    public SoundCommands getSpecialCommand() {
        return specialCommand;
    }
    public void setSpecialCommand(SoundCommands newspecialCommands) {
        this.specialCommand = newspecialCommands;
    }
}
