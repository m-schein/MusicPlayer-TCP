import enums.CommandType;

public class CommandActionFactory {
    public CommandAction make(CommandType type){
        try {
            if (CommandType.CHANGE_INSTRUMENT.equals(type)) {
                return new ChangeInstrumentAction();
            }
            if (CommandType.MUSICAL_NOTE.equals(type)) {
                return new AddMusicalNoteAction();
            }
            if(CommandType.REPEAT.equals(type)){
                return new RepeatNoteAction();
            }
        }catch(NullPointerException e){
            System.out.println("input error"+e.getMessage());
        }
        return null;
    };
}