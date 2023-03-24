package enums;

public enum SoundCommands {
    // TODO: mudar para SoundCommand
    // TODO: PLANT UML para fazer diagrama UML
        AGOGO(CommandType.CHANGE_INSTRUMENT,"(\\!)"), //changes the instrument to general instrument that is AGOGO
        HARPSICHORD(CommandType.CHANGE_INSTRUMENT,"[OoIiUu]"),
//

        TUBULAR_BELLS(CommandType.CHANGE_INSTRUMENT,"($)|(\n)"),
        PAN_FLUTE(CommandType.CHANGE_INSTRUMENT,"(\\;)"),
        CHURCH_ORGAN(CommandType.CHANGE_INSTRUMENT,"(\\,)"),
        CHANGE_INSTRUMENT(CommandType.CHANGE_INSTRUMENT2,"([0-9])"),
        INC_OCTAVE(CommandType.INC_OCTAVE,"(\\?)|(\\.)"),
        DOUBLE_VOLUME(CommandType.DOUBLE_VOLUME, "(\\ )"),

        REPEAT_NOTE(CommandType.REPEAT, "[^ABCDEFG\\n\\s]"),
        LA(CommandType.MUSICAL_NOTE, "(A)"),
        SI(CommandType.MUSICAL_NOTE, "(B)"),
        DO(CommandType.MUSICAL_NOTE, "(C)"),
        RE(CommandType.MUSICAL_NOTE, "(D)"),
        MI(CommandType.MUSICAL_NOTE, "(E)"),
        FA(CommandType.MUSICAL_NOTE, "(F)"),
        SOL(CommandType.MUSICAL_NOTE, "(G)");
//        DOUBLE_VOLUME(CommandType.MUSICAL_NOTE, "( )"),
//        REPEAT_NOTE(CommandType.MUSICAL_NOTE, "[abcdefg]");

        private final String value;
        private final CommandType commandType;
        SoundCommands( CommandType commandType, String value){
            this.value = value;
            this.commandType = commandType;
        }

        public String getValue(){
            return this.value;
        }
        public CommandType getCommandType(){return this.commandType;}

    }


