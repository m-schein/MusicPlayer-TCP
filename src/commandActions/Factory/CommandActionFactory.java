package commandActions.Factory;

import commandActions.*;
import commandActions.Interface.CommandAction;
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
            if(CommandType.INC_OCTAVE.equals(type)){
                return new IncreaseOctaveAction();
            }
            if(CommandType.DOUBLE_VOLUME.equals(type)){
                return new DoubleVolumeAction();
            }
            if(CommandType.CHANGE_INSTRUMENT2.equals(type)){
                return new ChangeInstrumentFromIntAction();
            }

        }catch(NullPointerException e){
            System.out.println("input error"+e.getMessage());
        }
        return null;
    };
}
