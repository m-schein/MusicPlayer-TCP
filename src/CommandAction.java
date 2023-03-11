import enums.SoundCommands;

public interface CommandAction {
    //comando comum em todas as açoes passa no execute
    //parametros para açoes especificas passa no construtor da factory
    void executeSoundCommand(SoundControl soundControl, SoundCommands command);
}
