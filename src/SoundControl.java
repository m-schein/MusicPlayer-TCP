import enums.SoundCommands;

public class SoundControl {

    private int volume;
    private int BPM;
    private String instrument;
    private char musicalNote;
    public SoundCommands specialCommand;

    public SoundControl(int volume, int BPM, String instrument, char musicalNote, SoundCommands specialCommand) {
        this.volume = volume;
        this.BPM = BPM;
        this.instrument = instrument;
        this.musicalNote = musicalNote;
        this.specialCommand = specialCommand;
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

    public String getInstrument(){
        return this.instrument;
    }
    public void setInstrument(String instrument){
        this.instrument = instrument;
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
