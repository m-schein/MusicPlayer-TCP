import enums.SoundCommands;
import org.jfugue.pattern.Pattern;
import java.util.ArrayList;
public class SoundControl {

    private int volume;
    private int BPM;
    private String musicalNote;
    public Pattern vocals;
    public SoundCommands soundCommand;
    public String previousNote;
    public ArrayList<Pattern> musicComposition;

    public SoundControl(int volume, int BPM, String musicalNote, SoundCommands soundCommand, Pattern vocals, String previousNote, ArrayList<Pattern> musicComposition) {
        this.volume = volume;
        this.BPM = BPM;
        this.musicalNote = musicalNote;
        this.soundCommand = soundCommand;
        this.vocals = vocals;
        this.vocals.setInstrument(soundCommand.name()); //set default instrument (AGOGO)
        this.previousNote = previousNote;
        this.musicComposition = musicComposition;
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
        this.musicComposition.add(this.vocals);
        Pattern vocals = new Pattern();
        this.vocals = vocals;
        this.vocals.add("I["+instrument+"]");
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

    public ArrayList<Pattern> getMusicComposition(){
        return this.musicComposition;
    }
    public void setMusicComposition(Pattern vocals){
        this.musicComposition.add(vocals);
    }
    public SoundCommands getSoundCommand() {
        return soundCommand;
    }
    public void setSoundCommand(SoundCommands soundCommand) {
        this.soundCommand = soundCommand;
    }
}
